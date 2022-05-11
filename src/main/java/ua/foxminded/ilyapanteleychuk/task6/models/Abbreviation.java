package ua.foxminded.ilyapanteleychuk.task6.models;


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
}
