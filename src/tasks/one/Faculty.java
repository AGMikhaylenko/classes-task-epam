package tasks.one;

public enum Faculty {
    FIT("Факультет информационных технологий"),
    ISF("Инженерно-строительный факультет"),
    HTF("Химико-технологический университет"),
    FUSK("Факультет управления и социальных коммуникаций"),
    FPIE("Факультет природопользования и инженерной экологии");

    String fullName;

    Faculty(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return fullName;
    }
}
