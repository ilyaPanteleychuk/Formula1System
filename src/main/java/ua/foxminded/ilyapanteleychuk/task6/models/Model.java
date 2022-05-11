package ua.foxminded.ilyapanteleychuk.task6.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Model {

    private final String abbreviation;
    private final LocalDateTime startOfRace;
    private final LocalDateTime endOfRace;
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS");

    public Model(String abbreviation, String startOfRace, String endOfRace) {
        this.abbreviation = abbreviation;
        this.startOfRace = LocalDateTime.parse(startOfRace, FORMATTER) ;
        this.endOfRace = LocalDateTime.parse(endOfRace, FORMATTER);
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public LocalDateTime getStartOfRace() {
        return startOfRace;
    }

    public LocalDateTime getEndOfRace() {
        return endOfRace;
    }

    @Override
    public String toString() {
        return "Model{" +
                "abbreviation='" + abbreviation + '\'' +
                ", startOfRace=" + startOfRace +
                ", endOfRace=" + endOfRace +
                '}';
    }
}
