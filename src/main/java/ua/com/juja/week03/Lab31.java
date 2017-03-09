package ua.com.juja.week03;

/**
 * В порт заходит большое количество разных кораблей. Для работы с ними был разработан базовый абстрактный класс
 * AbstractShip, который включает в себя все параметры, которые имеет каждый корабль: длинна (Length), ширина (Width),
 * водоизмещение (displacement) и несколько методов для получения информации про корабль. В этом классе описан
 * абстрактный метод calculatePayment(), который производит расчет оплаты за обслуживание портом разных типов кораблей.
 * Порт приинимает следующие типы кораблей: лайнеры (Liner), танкеры (Tanker), грузовые (Cargo).
 * Для обобщения принципов работы очереди кораблей в порту был разработан интерфейс SeaPortQueue.
 * Необходимо реализовать этот интерфейс для конкретного порта в виде класса OdessaSeaPort. В качестве структуры
 * данных для очереди кораблей используйте массив типа AbstractShip и переменную indexShipInPort типа int, которая
 * хранит индекс последнего корабля в очереди. В начале работы indexShipInPort равна константе NO_SHIP_IN_ARRAY = -1.
 * Размер очереди порта равняется константе LENGTH_QUEUE_SHIP=3 из интерфейса SeaPortQueue.
 * addShipToEndQueue() - метод, который добавляет корабль в конец очереди. Если очередь полная необходимо вернуть -1.
 * Если корабль успешно добавлен в очередь, необходимо вернуть его индекс в массиве очереди.
 * removeShipFromBeginQueue() - метод, который удаляет корабль из начала очереди. Если очередь пуста необходимо
 * вернуть -1. Если корабль успешно удален вернуть 1. При удалении корабля обеспечить продвижение кораблей
 * в начало очереди.  (Подсказка: очередь - массив, поэтому можно использовать методы из стандартных пакетов
 * для работы с массивами)
 * printQueueShip() - метод, который печатает информацию про корабли в очереди. Если в очереди нет кораблей
 * вернуть строку "QueueEmpty", иначе на выходе ожидается строка в виде конкатенации печати информации о корабле.
 * Выходная строка имеет следующий вид:
 * {Name=<>Length=<>Width=<>Displacement=<>};{Name=<>Length=<>Width=<>Displacement=<>};
 */

public class Lab31 extends AbstractShip{

    private int passengers;
    public static final float DEFAULT_RENTAL = 1000;

    public Lab31(String name, float length, float width, float displacement, int passengers) {
        super(name, length, width, displacement);
        this.passengers = passengers;
    }

    @Override
    public float calculatePayment() {
        return passengers * DEFAULT_RENTAL;
    }

    public float calculatePayment(float rentTax) {
        if (rentTax > 0) {
            return passengers * rentTax;
        } else {
            return calculatePayment();
        }
    }
}

class Tanker extends AbstractShip {
    private float volume;
    public static final float DEFAULT_RENTAL = 250;

    public Tanker(String name, float length, float width, float displacement, float volume) {
        super(name, length, width, displacement);
        this.volume = volume;
    }

    @Override
    public float calculatePayment() {
        return volume * DEFAULT_RENTAL;
    }

    public float calculatePayment(float rentTax) {
        if (rentTax > 0) {
            return volume * rentTax;
        } else {
            return calculatePayment();
        }
    }
}

class Cargo extends AbstractShip {
    private float tonnage;
    public static final float DEFAULT_RENTAL=550;

    public Cargo(String name, float length, float width, float displacement, float tonnage) {
        super(name, length, width, displacement);
        this.tonnage = tonnage;
    }

    @Override
    public float calculatePayment() {
        return tonnage * DEFAULT_RENTAL;
    }

    public float calculatePayment(float rentTax) {
        if (rentTax > 0) {
            return tonnage * rentTax;
        } else {
            return calculatePayment();
        }
    }
}

interface SeaPortQueue {
    public final static int LENGTH_QUEUE_SHIP = 3;
    public int addShipToEndQueue(AbstractShip ship);
    public int removeShipFromBeginQueue();
    public String printQueueShip();
}

class OdessaSeaPort implements SeaPortQueue {
    private static final int NO_SHIP_IN_ARRAY = -1;
    private int indexShipInPort = NO_SHIP_IN_ARRAY;
    private AbstractShip[] arrayShip = new AbstractShip[LENGTH_QUEUE_SHIP];

    @Override
    public int addShipToEndQueue(AbstractShip ship) {

        for (int index = 0; index < arrayShip.length; index++) {
            if (arrayShip[index] == null) {
                arrayShip[index] = ship;
                indexShipInPort = index;
                return index;
            }
        }
        return NO_SHIP_IN_ARRAY;
    }

    @Override
    public int removeShipFromBeginQueue() {

        if (indexShipInPort == -1) {
            return -1;
        }

        for (int index = 0; index < indexShipInPort; index++) {
            arrayShip[index] = arrayShip[index + 1];
        }

        arrayShip[indexShipInPort] = null;

        indexShipInPort--;
        return 1;
    }

    @Override
    public String printQueueShip() {

        String result = "";

        if (arrayShip[0] == null) {
            return "QueueEmpty";
        }

        int i = 0;
        while (i < 3) {
            if (arrayShip[i] == null) {
                break;
            }
            result += arrayShip[i].toPrint();
            i++;
        }
        return result;
    }
}
