package tasks.five;

public enum Binding {
    SOLID("Твердый переплет"),
    SOFT("Мягкий переплет"),
    DIGITAL("Цифровая версия");

    private String name;

    Binding(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
