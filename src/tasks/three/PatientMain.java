package tasks.three;

import tasks.Address;

import java.util.ArrayList;

public class PatientMain {
    public static void main(String[] args) {

        Patient patientOne = new Patient("Ivan", "Ivanov", "Ivanovich", new Address(), 9201587486L);
        Patient patientTwo = new Patient("Petr", "Petrov", "Petrovich", new Address(), 9801582369L, 1005869);
        Patient patientThree = new Patient("Nikolay", "Nikolaev", "Nikolaevich",
                new Address("Tver", "Sovetskaya", 20), 9607095005L, 5896324, Diagnosis.DIABETES);
        Patient patientFour = new Patient("Alexander", "Mikhaylenko", "Gennadyevich",
                new Address("Tver", "Sedova", 14, 20), 9065550088L, 2532895, Diagnosis.FLU);

        Patient[] testArray = new Patient[]{patientOne, patientTwo, patientThree, patientFour};

        System.out.println(getString(getPatientsByDiagnosis(testArray, Diagnosis.NONE)));
        System.out.println(getString(getPatientsByRangeOfNumberOfCard(testArray, 1001111, 5000000)));
    }

    /**
     * Поиск пациентов по диагнозу
     * @param patients Список пациентов
     * @param diagnosis Диагноз
     * @return Список пациентов с определенным диагнозом
     */
    public static Patient[] getPatientsByDiagnosis(Patient[] patients, Diagnosis diagnosis) {
        ArrayList<Patient> list = new ArrayList<>();
        for (Patient p : patients)
            if (p.getDiagnosis().equals(diagnosis))
                list.add(p);

        return list.toArray(new Patient[list.size()]);
    }

    /**
     * Поиск пациентов по номеру карт, находящихся в заданном диапазоне
     *
     * @param patients Список пациентов
     * @param min Нижняя граница значений номера карты
     * @param max Верхняя граница значений номера карты
     * @return Список пациентов с определенным номером карты
     * @throws IllegalArgumentException Исключение в случае, если верхняя граница меньше нижней
     */
    public static Patient[] getPatientsByRangeOfNumberOfCard(Patient[] patients, int min, int max)
            throws IllegalArgumentException{

        if (max < min)
            throw new IllegalArgumentException("Верхняя граница поиска должна быть больше нижней");

        ArrayList<Patient> list = new ArrayList<>();
        for (Patient p : patients)
            if (p.getNumberOfCard() >= min && p.getNumberOfCard() <= max)
                list.add(p);

        return list.toArray(new Patient[list.size()]);
    }

    /**
     * Составление строкового представления массива пациентов
     * @param patients Список пациентов
     * @return Строковое представление массива пациентов
     */
    public static String getString(Patient[] patients) {
        String result = "";
        for (Patient p : patients)
            if (p != null)
                result += p.toString() + "\n";
        return result;
    }
}
