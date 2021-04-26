package tasks.two;

import tasks.Address;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CustomerMain {

    public static void main(String[] args) {
        Customer customerOne = new Customer("Ivan", "Ivanov", "Ivanovich", new Address(), 5489_4789L);
        Customer customerTwo = new Customer("Petr", "Petrov", "Petrovich", new Address(), 5489_1324L, 7897_4812_1236L);
        Customer customerThree = new Customer("Nikolay", "Nikolaev", "Nikolaevich",
                new Address("Tver", "Sovetskaya", 20), 5489_7777L);
        Customer customerFour = new Customer("Alexander", "Mikhaylenko", "Gennadyevich",
                new Address("Tver", "Sedova", 14, 20), 5489_9999L, 1234_5678_7894L);

        Customer[] testArray = new Customer[]{customerOne, customerTwo, customerThree, customerFour};

        System.out.println(getString(sortedCustomersByName(testArray))+"\n");
        System.out.println(getString(getCustomersByRangeOfNumberOfCard(testArray, 5489_4788L, 5489_9996L)));
    }

    /**
     * Сортировка покупателей по алфавитному порядку
     * @param customers Список покупателей
     * @return Отсортированный список покупателей
     */
    public static Customer[] sortedCustomersByName(Customer[] customers) {
        List<Customer> list = Arrays.asList(customers);
        Collections.sort(list);
        return list.toArray(new Customer[list.size()]);
    }

    /**
     * Поиск покупателей по номеру карты
     * @param customers Список покупателей
     * @param min Нижняя граница номеров карты
     * @param max Верхняя граница номеров карты
     * @return Список покупателей с картой, попадающий в нужный диапозон
     */
    public static Customer[] getCustomersByRangeOfNumberOfCard(Customer[] customers, long min, long max) {
        List<Customer> list = new ArrayList<>();
        for (Customer c : customers)
            if (c.getNumberOfCard() >= min && c.getNumberOfCard() <= max)
                list.add(c);

        return list.toArray(new Customer[list.size()]);
    }

    /**
     * Получение строкового представления массива покупателей
     * @param customers Список покупателей
     * @return строковое представление массива покупателей
     */
    public static String getString(Customer[] customers) {
        String result = "";
        for (Customer c : customers)
            if (c != null)
                result += c.toString() + "\n";
        return result;
    }
}
