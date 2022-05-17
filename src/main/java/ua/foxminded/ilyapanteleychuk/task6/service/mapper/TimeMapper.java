package ua.foxminded.ilyapanteleychuk.task6.service.mapper;

import ua.foxminded.ilyapanteleychuk.task6.models.EndLapTime;
import ua.foxminded.ilyapanteleychuk.task6.models.StartLapTime;
import java.util.List;
import java.util.Map;


public interface TimeMapper {

    Map<String, StartLapTime> startMapFromString(List<String> startRaceInfo);

    Map<String, EndLapTime> endMapFromString(List<String> endRaceInfo);
}
