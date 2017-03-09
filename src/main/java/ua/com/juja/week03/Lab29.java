package ua.com.juja.week03;

/**
 * В порт заходит большое количество разных кораблей. Для работы с ними был разработан базовый абстрактный класс
 * AbstractShip, который включает в себя все параметры, которые имеет каждый корабль: длинна (Length), ширина (Width),
 * водоизмещение (displacement) и несколько методов для получения информации про корабль. В этом классе описан
 * абстрактный метод calculatePayment(), который производит расчет оплаты за обслуживание портом разных типов кораблей.
 * Каждый корабль имеет параметр от которого зависит плата за обслуживание. Порт приинимает следующие типы кораблей:
 * лайнеры (Liner), танкеры (Tanker), грузовые (Cargo).
 * Необходимо реализовать класс для корабля типа танкер (Tanker), который наследует абстрактный класс AbstractShip.
 * Для этого необходимо реализовать конструктор и метод расчет оплаты за услуги порта по ставке ренты, которая
 * храниться в константе DEFAULT_RENTAL и для этого типа корабля равняется 250. Параметр от которого зависит
 * оплата для этого типа судна: Объем (volume).
 * Формула для расчет оплаты: Оплата = Объем * Рентный налог судна.
 * Необходимо спроектировать и реализовать calculatePayment(), при помощи которого станет возможным передача
 * рентной ставки налога для судна в качестве параметра. Типы данных параметра float. Формула для расчета не меняется.
 * Если передается отрицательное значение рентной ставки или 0 то использовать дефолтное значение для этого типа корабля.
 */

public class Lab29 extends AbstractShip{
    private float volume;
    public static final float DEFAULT_RENTAL = 250;

    public Lab29(String name, float length, float width, float displacement, float volume){
        super(name, length, width, displacement);
        this.volume = volume;
    }

    @Override
    public float calculatePayment() {
        if(volume <= 0 ){
            return DEFAULT_RENTAL;
        } else {
            return volume * DEFAULT_RENTAL;
        }
    }

    public float calculatePayment(float counter) {
        if(counter <= 0 ){
            return volume * DEFAULT_RENTAL;
        } else {
            return volume * counter;
        }
    }
}

