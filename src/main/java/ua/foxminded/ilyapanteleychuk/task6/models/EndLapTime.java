package ua.foxminded.ilyapanteleychuk.task6.models;

import java.time.LocalDateTime;
import java.util.Objects;


public class EndLapTime {

    private final LocalDateTime endOfRace;

    public EndLapTime(LocalDateTime endOfRace) {
        this.endOfRace = endOfRace;
    }

    @Override
    public String toString() {
        return "RacerEndTime{" +
            "endOfRace=" + endOfRace +
            '}';
    }

    public LocalDateTime getEndOfRace() {
        return endOfRace;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        EndLapTime that = (EndLapTime) o;
        return Objects.equals(endOfRace, that.endOfRace);
    }

    @Override
    public int hashCode() {
        return Objects.hash(endOfRace);
    }
}
