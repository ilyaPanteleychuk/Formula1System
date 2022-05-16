package ua.foxminded.ilyapanteleychuk.task6.service;

import org.junit.jupiter.api.Test;
import ua.foxminded.ilyapanteleychuk.task6.models.BestRacer;
import ua.foxminded.ilyapanteleychuk.task6.models.RacerTime;
import ua.foxminded.ilyapanteleychuk.task6.util.DateUtil;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;


class BestTimeLapCounterTest {

    @Test
    void countBestLap_shouldCountBestLap_whenInputIsListOfModels() {
        RacerTime racer = new RacerTime("SVF",
                DateUtil.timeFormatterByPattern("2018-05-24_12:02:58.917"),
                DateUtil.timeFormatterByPattern("2018-05-24_12:04:03.332"));
        LocalDateTime startOfRace = racer.getStartOfRace();
        LocalDateTime endOfRace = racer.getEndOfRace();
        List<RacerTime> racerTimeList = new ArrayList<>();
        racerTimeList.add(racer);
        BestTimeLapCounter bestTimeLapCounter = new BestTimeLapCounter();
        List<BestRacer> bestRacers = bestTimeLapCounter.countBestLap(racerTimeList);
        Duration expected = Duration.between(startOfRace, endOfRace);
        Duration actual = bestRacers.get(0).getBestLapTime();
        assertEquals(expected, actual);
    }
}
