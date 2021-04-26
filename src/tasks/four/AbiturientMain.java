package tasks.four;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AbiturientMain {

    public static void main(String[] args) {

    }

    /**
     * Поиск абитуриентов с неудовлетворительными оценками
     *
     * @param abiturients Список абитуриентов
     * @return Список абитуриентов с неудовлетворительными оценками
     */
    public static Abiturient[] getAbiturientsWithBadRating(Abiturient[] abiturients) {
        List<Abiturient> list = new ArrayList<>();
        for (Abiturient a : abiturients)
            for (Abiturient.Rating r : a.getRatings())
                if (r.getValue() <= 2) {
                    list.add(a);
                    break;
                }

        return list.toArray(new Abiturient[list.size()]);
    }

    /**
     * Поиск абитуриентов с суммой баллов выше указанной
     *
     * @param abiturients Список абитуриентов
     * @param minValue    Минимальное значение
     * @return Список абитуриентов с суммой баллов выше указанной
     */
    public static Abiturient[] getAbiturientsWithBigSum(Abiturient[] abiturients, int minValue) {
        List<Abiturient> list = new ArrayList<>();
        for (Abiturient a : abiturients) {
            if (a.getSumOfRatings() >= minValue)
                list.add(a);
        }

        return list.toArray(new Abiturient[list.size()]);
    }

    /**
     * Выбор указанного количества лучших абитуриентов
     *
     * @param abiturients Список абитуриентов
     * @param n           Количество лучших
     * @return Список абитуриентов с лучшими оценками
     */
    public static Abiturient[] getBestAbiturients(Abiturient[] abiturients, int n) {
        List<Abiturient> list = Arrays.asList(abiturients);
        Collections.sort(list);
        if (n > list.size()) {
            Abiturient[] result = new Abiturient[n];
            for (int i = 0; i < n; i++)
                result[i] = list.get(i);
            return result;
        } else
            return list.toArray(new Abiturient[list.size()]);
    }

    /**
     * Получение строкового представления массива абтуриентов
     *
     * @param abiturients Список абитуриентов
     * @return Строковое представление массива абитуриентов
     */
    public static String getString(Abiturient[] abiturients) {
        String result = "";
        for (Abiturient a : abiturients)
            if (a != null)
                result += a.toString() + "\n";
        return result;
    }
}
