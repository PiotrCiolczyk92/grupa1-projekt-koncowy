package pl.sdacademy.entities;

public enum Country {
    POLAND("Polska"),
    ENGLAND("Anglia"),
    GERMANY("Niemcy"),
    FRANCE("Francja"),
    SPAIN("Hiszpania"),
    ITALY("Wlochy");

    private final String displayValue;

    private Country(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
