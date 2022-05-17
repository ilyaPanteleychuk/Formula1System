package ua.foxminded.ilyapanteleychuk.task6.service.mapper;

import ua.foxminded.ilyapanteleychuk.task6.models.EndLapTime;
import ua.foxminded.ilyapanteleychuk.task6.models.StartLapTime;
import ua.foxminded.ilyapanteleychuk.task6.util.DateUtil;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class TimeMapperImplementation implements TimeMapper {

    @Override
    public Map<String, StartLapTime> startMapFromString(List<String> startRaceInfo) {
        return startRaceInfo.stream()
            .collect(Collectors.toMap(el -> el.substring(0, 3),
                el -> new StartLapTime(DateUtil.timeFormatterByPattern(el.substring(3)))));
    }

    @Override
    public Map<String, EndLapTime> endMapFromString(List<String> endRaceInfo) {
        return endRaceInfo.stream()
            .collect(Collectors.toMap(el -> el.substring(0, 3),
                el -> new EndLapTime(DateUtil.timeFormatterByPattern(el.substring(3)))));
    }
}
