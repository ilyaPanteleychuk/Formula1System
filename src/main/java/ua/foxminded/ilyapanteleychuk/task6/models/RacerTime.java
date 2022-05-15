package ua.foxminded.ilyapanteleychuk.task6.models;

import java.time.LocalDateTime;
import java.util.Objects;


public class RacerTime {

    private final String abbreviation;
    private final LocalDateTime startOfRace;
    private final LocalDateTime endOfRace;

    public RacerTime(String abbreviation, LocalDateTime startOfRace, LocalDateTime endOfRace) {
        this.abbreviation = abbreviation;
        this.startOfRace = startOfRace;
        this.endOfRace = endOfRace;
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

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        RacerTime racerTime = (RacerTime) o;
        return Objects.equals(abbreviation, racerTime.abbreviation)
                && Objects.equals(startOfRace, racerTime.startOfRace)
                 && Objects.equals(endOfRace, racerTime.endOfRace);
    }

    @Override
    public int hashCode() {
        return Objects.hash(abbreviation, startOfRace, endOfRace);
    }
}
