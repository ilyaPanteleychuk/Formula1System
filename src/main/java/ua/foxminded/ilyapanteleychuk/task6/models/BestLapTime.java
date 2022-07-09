package ua.foxminded.ilyapanteleychuk.task6.models;

import java.time.Duration;
import java.util.Objects;


public class BestLapTime {

    private final Duration bestLapTime;

    public BestLapTime(Duration bestLapTime) {
        this.bestLapTime = bestLapTime;
    }


    public Duration getBestLapTime() {
        return bestLapTime;
    }

    @Override
    public String toString() {
        return "BestRacer2{" +
            "bestLapTime=" + bestLapTime +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        BestLapTime that = (BestLapTime) o;
        return Objects.equals(bestLapTime, that.bestLapTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bestLapTime);
    }
}
