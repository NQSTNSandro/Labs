package moduls;

public enum Genders {
    Male("Male"),
    FeMale("Female");
    private String value;
    Genders(String human) {
        this.value=human;
    }
    @Override
    public String toString(){
        return String.valueOf(value);
    }
    public String getValue() {
        return value;
    }
    public static Genders fromValue(String value) {
        for (Genders b : Genders.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}
