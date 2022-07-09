package ua.foxminded.ilyapanteleychuk.task6.models;

import java.util.Objects;


public class Abbreviation {

    private final String racerName;
    private final String racerCar;

    public Abbreviation(String racerName, String racerCar) {
        this.racerName = racerName;
        this.racerCar = racerCar;
    }

    public String getRacerName() {
        return racerName;
    }

    public String getRacerCar() {
        return racerCar;
    }

    @Override
    public String toString() {
        return "Abbreviation2{" +
            "racerName='" + racerName + '\'' +
            ", racerCar='" + racerCar + '\'' +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Abbreviation that = (Abbreviation) o;
        return Objects.equals(racerName, that.racerName) && Objects.equals(racerCar, that.racerCar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(racerName, racerCar);
    }
}
