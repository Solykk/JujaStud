package ua.com.juja.week03;

/**
 * В порт заходит большое количество разных кораблей. Для работы с ними был разработан базовый абстрактный класс
 * AbstractShip, который включает в себя все параметры, которые имеет каждый корабль: длинна (Length), ширина (Width),
 * водоизмещение (displacement) и несколько методов для получения информации про корабль. В этом классе описан
 * абстрактный метод calculatePayment(), который производит расчет оплаты за обслуживание портом разных типов кораблей.
 * Каждый корабль имеет параметр от которого зависит плата за обслуживание. Порт приинимает следующие типы кораблей:
 * лайнеры (Liner), танкеры (Tanker), грузовые (Cargo).
 * Необходимо реализовать класс для корабля типа грузовой (Cargo), который наследует абстрактный класс AbstractShip.
 * Для этого необходимо реализовать конструктор и метод расчет оплаты за услуги порта по ставке ренты, которая
 * храниться в константе DEFAULT_RENTAL и для этого типа корабля равняется 550. Параметр от которого зависит
 * оплата для этого типа судна: Вес груза (tonnage).
 * Формула для расчет оплаты: Оплата = Вес груза * Рентный налог судна.
 * Необходимо спроектировать и реализовать calculatePayment(), при помощи которого станет возможным передача рентной
 * ставки налога для судна в качестве параметра. Типы данных параметра float. Формула для расчета не меняется.
 * Если передается отрицательное значение рентной ставки или 0 то использовать дефолтное значение для этого типа корабля.
 */

public class Lab30 extends AbstractShip{

    private float tonnage;
    public static final float DEFAULT_RENTAL=550;

    public Lab30(String name, float length, float width, float displacement, float tonnage) {
        super(name, length, width, displacement);
        this.tonnage = tonnage;
    }


    @Override
    public float calculatePayment() {
        if(tonnage <= 0 ){
            return DEFAULT_RENTAL;
        } else {
            return tonnage * DEFAULT_RENTAL;
        }
    }


    public float calculatePayment(float counter) {
        if(counter <= 0 ){
            return tonnage * DEFAULT_RENTAL;
        } else {
            return tonnage * counter;
        }
    }
}

