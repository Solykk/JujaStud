package ua.com.juja.module06;

/**
 * Для автоматизации работы библиотеки необходимо реализовать метод, который находит в каталоге все издания
 * с количеством страниц больше N.
 * На выходе ожидается конкатенация печатного вида всех изданий. Если количество элементов входного
 * массива  = 0 - вернуть пустую строку "".
 * (Примечание: В консоль писать нельзя! ).
 */

public class Lab27 {
    private String name;
    private int countPages;

    public Lab27(String name, int countPages) {
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

class Journal27 extends Lab27 {
    private String yearJournal;
    private String numberJournal;

    public Journal27(String nameJournal, int countPages, String yearJournal, String numberJournal) {
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

class Book27 extends Lab27 {

    private String authorBook;

    public Book27(String name, int countPages, String authorBook) {
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

class Library {

    public String getIssueWithCountPagesMoreN(Lab27[] catalog, int barrierCountPages) {
        String result = "";
        if(catalog == null){
            return result;
        }
        else if(catalog.length == 0){
            return result;
        } else{

            for (Lab27 issues: catalog) {
                if(issues != null && issues.getCountPages() > barrierCountPages){
                    result += issues.toPrint();
                }
            }
        }
        return result;
    }
}
