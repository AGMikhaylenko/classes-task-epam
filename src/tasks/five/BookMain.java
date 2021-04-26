package tasks.five;

import java.util.ArrayList;
import java.util.List;

public class BookMain {
    public static void main(String[] args) {

    }

    /**
     * Поиск книг заданного автора
     *
     * @param books Список книг
     * @return Список книг заданного автора
     */
    public static Book[] getBookByAuthors(Book[] books, Book.Author author) {
        List<Book> list = new ArrayList<>();
        for (Book b : books)
            for (Book.Author a : b.getAuthors())
                if (a.equals(author))
                    list.add(b);
        return list.toArray(new Book[list.size()]);
    }

    /**
     * Поиск книг заданного издательского дома
     *
     * @param books           Список книг
     * @param publishingHouse Издательский дом
     * @return Список книг заданного издательского дома
     */
    public static Book[] getBookByPublishingHouse(Book[] books, String publishingHouse) {
        List<Book> list = new ArrayList<>();
        for (Book b : books)
            if (b.getPublishingHouse().equals(publishingHouse))
                list.add(b);
        return list.toArray(new Book[list.size()]);
    }

    /**
     * Поиск книг, изданных после определенного года
     *
     * @param books Список книг
     * @param year  Год
     * @return Список книг, изданных после определенного года
     */
    public static Book[] getBookAfterYear(Book[] books, int year) {
        List<Book> list = new ArrayList<>();
        for (Book b : books)
            if (b.getYear() > year)
                list.add(b);
        return list.toArray(new Book[list.size()]);
    }

    /**
     * Получение строкового представления массива книг
     *
     * @param books Массив книг
     * @return строковое представление массива книг
     */
    public static String getString(Book[] books) {
        String res = "";
        for (Book b : books)
            if (b != null)
                res += b.toString() + "\n";
        return res;
    }
}
