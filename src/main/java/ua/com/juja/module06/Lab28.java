package ua.com.juja.module06;

/**
 * В порт заходит большое количество разных кораблей. Для работы с ними был разработан базовый абстрактный класс
 * AbstractShip, который включает в себя все параметры, которые имеет каждый корабль: длинна (Length), ширина (Width),
 * водоизмещение (displacement) и несколько методов для получения информации про корабль. В этом классе описан
 * абстрактный метод calculatePayment(), который производит расчет оплаты за обслуживание портом разных типов кораблей.
 * Каждый корабль имеет параметр от которого зависит плата за обслуживание. Порт приинимает следующие типы кораблей:
 * лайнеры (Liner), танкеры (Tanker), грузовые (Cargo).
 * Необходимо реализовать класс для корабля типа лайнер (Liner), который наследует абстрактный класс AbstractShip.
 * Для этого необходимо реализовать конструктор и метод расчет оплаты за услуги порта по ставке ренты, которая
 * храниться в константе DEFAULT_RENTAL и для этого типа корабля равняется 1000. Параметр от которого зависит
 * оплата для этого типа судна: Количество пассажиров (passengers).
 * Формула для расчет оплаты: Оплата = Количество пассажиров * Рентный налог судна.
 * Необходимо спроектировать и реализовать calculatePayment(), при помощи которого станет возможным передача рентной
 * ставки налога для судна в качестве параметра. Типы данных параметра float. Формула для расчета не меняется.
 * Если передается отрицательное значение рентной ставки или 0 то использовать дефолтное значение для этого типа корабля.
 */

public class Lab28 extends AbstractShip{
    private int passengers;
    public static final float DEFAULT_RENTAL = 1000;

    public Lab28 (String name, float length, float width, float displacement, int passengers){
        super(name, length, width, displacement);
        this.passengers = passengers;
    }


    public float calculatePayment() {
        if(passengers <= 0 ){
            return DEFAULT_RENTAL;
        } else {
            return passengers * DEFAULT_RENTAL;
        }
    }

    public float calculatePayment(float counter) {
        if(counter <= 0 ){
            return passengers * DEFAULT_RENTAL;
        } else {
            return passengers * counter;
        }
    }

}

abstract class AbstractShip {
    private String name;
    private float length;
    private float width;
    private float displacement;

    public AbstractShip(String name, float length, float width, float displacement) {
        this.name = name;
        this.length = length;
        this.width = width;
        this.displacement = displacement;
    }

    public abstract float calculatePayment();

    public String toPrint() {
        return "Name=" + name +
                "Length=" + length +
                "Width=" + width +
                "Displacement=" + displacement;
    }

    public String getName() {
        return name;
    }
}
