package ua.foxminded.ilyapanteleychuk.task6.service.mapper;

import ua.foxminded.ilyapanteleychuk.task6.models.RacerTime;
import ua.foxminded.ilyapanteleychuk.task6.util.DateUtil;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class RacerTimeMapper {

    public List<RacerTime> mapFromString(List<String> startRaceInfo, List<String> endRaceInfo){
        return formatRealization(startRaceInfo, endRaceInfo);
    }

    private List<RacerTime> formatRealization(List<String> startRaceInfo, List<String> endRaceInfo){
        List<RacerTime> timeOfRace = new ArrayList<>();
        for(String startLine : startRaceInfo) {
            String abbreviation = startLine.substring(0, 3);
            LocalDateTime startOfRace = DateUtil.timeFormatterByPattern(startLine.substring(3));
            for(String endLine : endRaceInfo) {
                if(abbreviation.equals(endLine.substring(0, 3))) {
                    LocalDateTime endOfRace = DateUtil.timeFormatterByPattern(endLine.substring(3));
                    timeOfRace.add(new RacerTime(abbreviation, startOfRace, endOfRace));
                }
            }
        }
        return timeOfRace;
    }
}
