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
}
