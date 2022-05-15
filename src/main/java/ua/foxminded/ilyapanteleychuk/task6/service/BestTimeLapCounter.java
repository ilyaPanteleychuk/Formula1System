package ua.foxminded.ilyapanteleychuk.task6.service;

import ua.foxminded.ilyapanteleychuk.task6.models.BestRacer;
import ua.foxminded.ilyapanteleychuk.task6.models.RacerTime;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class BestTimeLapCounter {

    public List<BestRacer> countBestLap(List<RacerTime> racersInfo){
        return countBestLapRealization(racersInfo);
    }

    private List<BestRacer> countBestLapRealization(List<RacerTime> racersInfo){
        List<BestRacer> bestRacers = new ArrayList<>();
        for(RacerTime racer : racersInfo) {
            String abbreviation = racer.getAbbreviation();
            LocalDateTime startOfRace = racer.getStartOfRace();
            LocalDateTime endOfRace = racer.getEndOfRace();
            Duration bestLap = Duration.between(startOfRace, endOfRace);
            bestRacers.add(new BestRacer(abbreviation, bestLap));
        }
        return bestRacers.stream()
                .sorted(Comparator.comparing(BestRacer :: getBestLapTime))
                .collect(Collectors.toList());
    }
}
