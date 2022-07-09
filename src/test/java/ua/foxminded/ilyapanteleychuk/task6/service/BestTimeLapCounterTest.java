package ua.foxminded.ilyapanteleychuk.task6.service;

import org.junit.jupiter.api.Test;
import ua.foxminded.ilyapanteleychuk.task6.models.EndLapTime;
import ua.foxminded.ilyapanteleychuk.task6.models.StartLapTime;
import ua.foxminded.ilyapanteleychuk.task6.util.DateUtil;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;


class BestTimeLapCounterTest {

    @Test
    void countBestLap_shouldCountBestLap_whenInputIsMapOfStartAndMapOfEnd() {
        BestTimeLapCounter lapCounter = new BestTimeLapCounter();
        Map<String, StartLapTime> startOfRace = new HashMap<>();
        startOfRace.put("SVF",
            new StartLapTime(DateUtil.timeFormatterByPattern("2018-05-24_12:02:58.917")));
        Map<String, EndLapTime> endOfRace = new HashMap<>();
        endOfRace.put("SVF",
            new EndLapTime(DateUtil.timeFormatterByPattern("2018-05-24_12:04:03.332")));
        LocalDateTime start = startOfRace.get("SVF").getStartOfRace();
        LocalDateTime end = endOfRace.get("SVF").getEndOfRace();
        Duration expected = Duration.between(start, end);
        Duration actual = lapCounter.countBestLap(startOfRace, endOfRace).get("SVF").getBestLapTime();
        assertEquals(expected, actual);
    }
}
