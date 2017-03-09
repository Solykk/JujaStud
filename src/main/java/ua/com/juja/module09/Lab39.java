package ua.com.juja.module09;

/**
 * С выходом  Java 7 появились дополнительные инструменты для работы с ресурсами в блоке  try.
 * try-with-resources механизм, который позволяет закрывать все ресурсы открытые вначале блока.
 * Для понимания работы новых функций и поддержки старых прооектов рассмотрим следующую схему:
 * Интерфейс AutoCloseableFactory:
 * public AutoCloseable create() throws Throwable; - "эмулятор" работы конструктора некоторого экземпляра AutoCloseable.
 * Интерфейс TryBody:
 * public void runBody() throws Throwable; –  “эмулятор” “тела блока try”
 */

public class Lab39 {
    public static void twoResource(AutoCloseableFactory factoryA, AutoCloseableFactory factoryB, TryBody body) throws Throwable {
        Throwable exception = new Throwable();
        boolean isCloseA = false;

        try {
            AutoCloseable a = factoryA.create();
            try {
                AutoCloseable b = factoryB.create();
                try {
                    body.runBody();
                } catch (Throwable bodyEx) {
                    try {
                        b.close();
                    } catch (Throwable closeExB) {
                        bodyEx.addSuppressed(closeExB);
                    }
                    try {
                        isCloseA = true;
                        a.close();
                    } catch (Throwable closeExA) {
                        bodyEx.addSuppressed(closeExA);
                    }
                    throw bodyEx;
                }
                try {
                    b.close();
                } catch (Throwable closeExB) {
                    exception.addSuppressed(closeExB);
                }
                try {
                    isCloseA = true;
                    a.close();

                } catch (Throwable closeExA) {
                    exception.addSuppressed(closeExA);
                }

            } catch (Throwable ee){
                if(!isCloseA){
                    try {
                        isCloseA = true;
                        a.close();
                    } catch (Throwable closeA){
                        exception.addSuppressed(closeA);
                    }
                }
                exception.addSuppressed(ee);
            }
        } catch (Throwable e) {

        }
    }
}

interface AutoCloseableFactory {
    public AutoCloseable create() throws Throwable;
}

interface TryBody {
    public void runBody() throws Throwable;
}

