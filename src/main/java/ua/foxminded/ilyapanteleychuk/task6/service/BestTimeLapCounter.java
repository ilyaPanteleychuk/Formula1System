package ua.foxminded.ilyapanteleychuk.task6.service;

import ua.foxminded.ilyapanteleychuk.task6.models.BestRacer;
import ua.foxminded.ilyapanteleychuk.task6.models.Model;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class BestTimeLapCounter {

    public List<BestRacer> countBestLap(List<Model> racersInfo){
        return sortByTime(countBestLapRealization(racersInfo));
    }

    private List<BestRacer> sortByTime(List<BestRacer> bestRacers){
        return bestRacers.stream()
                .sorted(Comparator.comparing(BestRacer :: getBestLapTime))
                .collect(Collectors.toList());
    }

    private List<BestRacer> countBestLapRealization(List<Model> racersInfo){
        List<BestRacer> bestRacers = new ArrayList<>();
        for(int i = 0; i < racersInfo.size(); i++){
            Model racer = racersInfo.get(i);
            String abbreviation = racer.getAbbreviation();
            LocalDateTime startOfRace = racer.getStartOfRace();
            LocalDateTime endOfRace = racer.getEndOfRace();
            Duration bestLap = Duration.between(startOfRace, endOfRace);
            bestRacers.add(new BestRacer(abbreviation, bestLap));
        }
        return bestRacers;
    }
}
