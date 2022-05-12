package ua.foxminded.ilyapanteleychuk.task6.models;


import java.util.Objects;

public class Abbreviation {

    private final String abbreviation;
    private final String racerName;
    private final String racerCar;

    public Abbreviation(String abbreviation, String racerName, String racerCar) {
        this.abbreviation = abbreviation;
        this.racerName = racerName;
        this.racerCar = racerCar;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getRacerName() {
        return racerName;
    }

    public String getRacerCar() {
        return racerCar;
    }

    @Override
    public String toString() {
        return "Abbreviation{" +
                "abbreviation='" + abbreviation + '\'' +
                ", racerName='" + racerName + '\'' +
                ", racerCar='" + racerCar + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Abbreviation that = (Abbreviation) o;
        return Objects.equals(abbreviation, that.abbreviation)
                && Objects.equals(racerName, that.racerName)
                    && Objects.equals(racerCar, that.racerCar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(abbreviation, racerName, racerCar);
    }
}
