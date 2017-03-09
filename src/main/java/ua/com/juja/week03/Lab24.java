package ua.com.juja.week03;

/**
 * Для автоматизации работы библиотеки необходимо разработать иерархию классов.
 * На полках в библиотеке находится много печатных изданий. Вынесем все общие свойства печатных изданий в класс  Lab24.
 * В нем реализуем метод toPrint() , который выводит на печать информацию о издании в следующем формате
 * name=TestNameLab24,countPages=100. Класс Book расширяет класс Lab24 и добавляет новое свойство  authorBook,
 * которое характерно для книг.
 * Необходимо реализовать метод toPrint() для класса Book, который выводит на печать информацию про книгу в
 * следующем формате Book{name=<name>,countPages=<countPages>,author=<authorBook>}
 * Подсказка: для реализации метода  toPrint() необходимо использовать метод toPrint() класса Issue.
 */

public class Lab24 {
    private String name;
    private int countPages;

    public Lab24(String name, int countPages) {
        this.name = name;
        this.countPages = countPages;
    }

    public String toPrint() {
        return "name=" + name +
                ",countPages=" + countPages;
    }
}

class Book extends Lab24 {
    private String authorBook;

    public Book(String name, int countPages, String authorBook){
        super(name,countPages);
        this.authorBook = authorBook;
    }

    public String toPrint() {
        return "Book{" + super.toPrint() + ",author=" + authorBook + "}";
    }
}
