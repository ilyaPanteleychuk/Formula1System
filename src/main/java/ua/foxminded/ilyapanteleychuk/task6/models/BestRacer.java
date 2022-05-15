package ua.foxminded.ilyapanteleychuk.task6.models;

import java.time.Duration;
import java.util.Objects;


public class BestRacer {

    private final String abbreviation;
    private final Duration bestLapTime;

    public BestRacer(String abbreviation, Duration bestLapTime) {
        this.abbreviation = abbreviation;
        this.bestLapTime = bestLapTime;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public Duration getBestLapTime() {
        return bestLapTime;
    }

    @Override
    public String toString() {
        return "BestRacer{" +
                "abbreviation='" + abbreviation + '\'' +
                ", bestLapTime=" + bestLapTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        BestRacer bestRacer = (BestRacer) o;
        return Objects.equals(abbreviation, bestRacer.abbreviation)
                && Objects.equals(bestLapTime, bestRacer.bestLapTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(abbreviation, bestLapTime);
    }
}
