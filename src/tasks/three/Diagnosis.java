package tasks.three;

public enum Diagnosis {
    NONE("Диагноз не поставлен"),
    DIABETES ("Сахарный диабет"),
    FLU("Грипп");

    private String fullName;

    Diagnosis(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

}
