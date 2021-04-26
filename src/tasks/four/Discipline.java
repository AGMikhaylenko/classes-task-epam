package tasks.four;

public enum Discipline {
    MATH("Математика"),
    LITERATURE("Литература"),
    INFO("Информатика"),
    CHEMISTRY("Химия"),
    PHYSICS("Физика"),
    ENGLISH("Английский язык");

    private String fullName;

    Discipline(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return fullName;
    }
}
