package ua.foxminded.ilyapanteleychuk.task6.models;

import java.time.Duration;


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
}
