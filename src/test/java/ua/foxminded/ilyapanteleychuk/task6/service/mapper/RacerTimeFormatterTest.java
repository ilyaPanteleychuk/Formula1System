package ua.foxminded.ilyapanteleychuk.task6.service.mapper;

import org.junit.jupiter.api.Test;
import ua.foxminded.ilyapanteleychuk.task6.models.EndLapTime;
import ua.foxminded.ilyapanteleychuk.task6.models.StartLapTime;
import ua.foxminded.ilyapanteleychuk.task6.util.DateUtil;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class RacerTimeFormatterTest {

    @Test
    void startMapFromList_shouldCreateMapWithRightStartObjects_whenInputIsStringArrayList() {
        String startOfRace = "SVF2018-05-24_12:02:58.917";
        List<String> startInfo = new ArrayList<>();
        startInfo.add(startOfRace);
        Map<String, StartLapTime> expectedRacer = new HashMap<>();
        expectedRacer.put("SVF",
            new StartLapTime(DateUtil.timeFormatterByPattern("2018-05-24_12:02:58.917")));
        TimeMapperImplementation timeMapper = new TimeMapperImplementation();
        assertEquals(expectedRacer, timeMapper.startMapFromString(startInfo));
    }

    @Test
    void endMapFromList_shouldCreateMapWithRightEndObjects_whenInputIsStringArrayList(){
        String endOfRace = "SVF2018-05-24_12:04:03.332";
        List<String> endInfo = new ArrayList<>();
        endInfo.add(endOfRace);
        Map<String, EndLapTime> expectedRacer = new HashMap<>();
        expectedRacer.put("SVF",
            new EndLapTime(DateUtil.timeFormatterByPattern("2018-05-24_12:04:03.332")));
        TimeMapperImplementation timeMapper = new TimeMapperImplementation();
        assertEquals(expectedRacer, timeMapper.endMapFromString(endInfo));
    }
}
