package ua.com.juja.module06;

/**
 * Для автоматизации работы библиотеки необходимо реализовать метод, который печатает информацию про каждое издание,
 * которое находится в переданном каталоге.
 * На выходе ожидается конкатенация печатного вида всех изданий. Если количество элементов массива  = 0
 * вернуть пустую строку "".
 * (Примечание: В консоль писать нельзя ! ).
 */

public class Lab26 {
    private String name;
    private int countPages;

    public Lab26(String name, int countPages) {
        this.name = name;
        this.countPages = countPages;
    }

    public String toPrint() {
        return "Issue{" +
                "name=" + name +
                ",countPages=" + countPages +
                "}";
    }

    public int getCountPages() {
        return countPages;
    }

    public String getName(){
        return name;
    }

}

class Journal26 extends Lab26 {
    private String yearJournal;
    private String numberJournal;

    public Journal26 (String nameJournal, int countPages, String yearJournal, String numberJournal) {
        super(nameJournal, countPages);
        this.yearJournal = yearJournal;
        this.numberJournal = numberJournal;
    }

    @Override
    public String toPrint() {
        return "Journal{" +
                "name=" + getName() +
                ",countPages=" + getCountPages() +
                ",year=" + yearJournal +
                ",number=" + numberJournal +
                "}";
    }
}

class Book26 extends Lab26 {

    private String authorBook;

    public Book26(String name, int countPages, String authorBook) {
        super(name, countPages);
        this.authorBook = authorBook;
    }

    @Override
    public String toPrint() {
        return "Book{" +
                "name=" + getName() +
                ",countPages=" + getCountPages() +
                ",author=" + authorBook +
                "}";
    }
}

class Library26 {

    public String printCatalog(Lab26[] catalog) {
        String result = "";
        if(catalog == null){
            return result;
        }
        else if(catalog.length == 0){
            return result;
        } else{

            for (Lab26 issues: catalog) {
                if(issues != null){
                    result += issues.toPrint();
                }
            }
        }
        return result;
    }
}
