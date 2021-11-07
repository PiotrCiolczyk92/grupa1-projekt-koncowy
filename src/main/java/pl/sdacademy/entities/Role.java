package pl.sdacademy.entities;

public enum Role {
    USER("USER"), ADMIN("ADMIN");

    public String displayValue;

    Role(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
