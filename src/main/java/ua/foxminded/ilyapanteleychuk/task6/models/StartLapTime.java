package ua.foxminded.ilyapanteleychuk.task6.models;

import java.time.LocalDateTime;
import java.util.Objects;


public class StartLapTime {

    private final LocalDateTime startOfRace;

    public StartLapTime(LocalDateTime startOfRace) {
        this.startOfRace = startOfRace;
    }

    @Override
    public String toString() {
        return "RacerStartTime{" +
            "startOfRace=" + startOfRace +
            '}';
    }

    public LocalDateTime getStartOfRace() {
        return startOfRace;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        StartLapTime that = (StartLapTime) o;
        return Objects.equals(startOfRace, that.startOfRace);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startOfRace);
    }
}
