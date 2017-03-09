package ua.com.juja.week03;

/**
 * В порт заходит большое количество разных кораблей. Для работы с ними был разработан базовый абстрактный класс
 * AbstractShip, который включает в себя все параметры, которые имеет каждый корабль: длинна (Length), ширина (Width),
 * водоизмещение (displacement) и несколько методов для получения информации про корабль. В этом классе описан
 * абстрактный метод calculatePayment(), который производит расчет оплаты за обслуживание портом разных типов кораблей.
 * Каждый корабль имеет параметр от которого зависит плата за обслуживание. Порт приинимает следующие типы кораблей:
 * лайнеры (Liner), танкеры (Tanker), грузовые (Cargo).
 * Для обеспечения эффективного использования ресурсов порта в классе OdessaSeaPort необходимо реализовать статический
 * метод, который распологает корабли по возрастанию оплаты услуг порта. На вход метода подается массив типа AbstractShip.
 * public static String sortSumPaymentAsc(AbstractShip[] arrayShips)
 * На выходе ожидается печать отсортированного массива в следующем формате:
 * TestTankerName=25000.0TestCargoName=55000.0TestLinerName=100000.0
 * Если во входном массиве 0 элементов или если в качестве параметра передан null вернуть пустую строку.
 */

public class Lab32 extends AbstractShip{

    private int passengers;
    public static final float DEFAULT_RENTAL = 1000;

    public Lab32(String name, float length, float width, float displacement, int passengers) {
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

class OdessaSeaPort32 {
    public static String sortSumPaymentAsc(AbstractShip[] arrayShips) {
        String result = "";

        if(arrayShips == null || arrayShips.length == 0){
            return "";
        }

        for(int i = arrayShips.length - 1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
                if(arrayShips[i] == null){
                    break;
                }
                if( arrayShips[j].calculatePayment() > arrayShips[j + 1].calculatePayment() ){
                    AbstractShip tmp = arrayShips[j];
                    arrayShips[j] = arrayShips[j + 1];
                    arrayShips[j + 1] = tmp;
                }
            }
        }

        for (int index = 0; index < arrayShips.length; index++){
            if(arrayShips[index] != null){
                result += arrayShips[index].getName() + "=" + arrayShips[index].calculatePayment();
            }
        }

        return result;
    }
}
