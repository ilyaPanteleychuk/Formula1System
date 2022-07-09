package ua.foxminded.ilyapanteleychuk.task6.service;

import ua.foxminded.ilyapanteleychuk.task6.models.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


public class BestTimeLapCounter {

    public Map<String, BestLapTime> countBestLap(Map<String, StartLapTime> startTime,
                                                 Map<String, EndLapTime> endTime) {
        Map<String, BestLapTime> bestRacerMap = new LinkedHashMap<>();
        Set<String> startTimeKeys = startTime.keySet();
        for(String key : startTimeKeys){
            if(endTime.containsKey(key)){
                LocalDateTime start = startTime.get(key).getStartOfRace();
                LocalDateTime end = endTime.get(key).getEndOfRace();
                Duration bestLap = Duration.between(start, end);
                bestRacerMap.put(key, new BestLapTime(bestLap));
            }
        }
        return bestRacerMap.entrySet().stream()
            .sorted(Map.Entry.comparingByValue(Comparator.comparing(BestLapTime :: getBestLapTime)))
            .collect(Collectors.toMap(Map.Entry :: getKey, Map.Entry :: getValue,
                (oldValue, newValue) -> oldValue, LinkedHashMap :: new));
    }
}
