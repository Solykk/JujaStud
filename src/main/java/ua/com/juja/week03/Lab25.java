package ua.com.juja.week03;

/**
 * Для автоматизации работы библиотеки необходимо разработать иерархию классов.
 * На полках в библиотеке находится много печатных изданий. Вынесем все общие свойства печатных изданий в класс  Lab25.
 * В нем реализуем метод toPrint(), который выводит на печать информацию о издании в следующем формате
 * name=TestNameLab25,countPages=100. Класс Journal расширяет класс Lab25 и добавляет новые свойства yearJournal и
 * numberJournal, которые характерны для журналов.
 * Необходимо реализовать конструктор Journal, который принимает на вход 4 параметра:  nameJournal,
 * countPages, yearJournal, numberJournal и сохраняет их.
 * Необходимо реализовать метод toPrint() для класса Journal, который выводит на печать информацию про журнал
 * в следующем формате: Journal{name=<name>,countPages=<countPages>,year=<yearJournal>,number=<numberJournal>}
 * Подсказка: для реализации метода  toPrint() необходимо использовать метод toPrint() класу Lab25.
 */

public class Lab25 {
    private String name;
    private int countPages;

    public Lab25(String name, int countPages) {
        this.name = name;
        this.countPages = countPages;
    }

    public String toPrint() {
        return "name=" + name +
                ",countPages=" + countPages;
    }
}

class Journal extends Lab25 {
    private String yearJournal;
    private String numberJournal;

    public Journal(String name, int countPages,String yearJournal,String numberJournal){
        super(name,countPages);
        this.yearJournal = yearJournal;
        this.numberJournal = numberJournal;
    }

    public String toPrint(){
        return "Journal{" + super.toPrint() + ",year=" + yearJournal + ",number=" + numberJournal + "}";
    }
}
