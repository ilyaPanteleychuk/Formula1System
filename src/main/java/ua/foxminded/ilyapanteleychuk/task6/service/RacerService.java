package ua.foxminded.ilyapanteleychuk.task6.service;

import ua.foxminded.ilyapanteleychuk.task6.exception.EmptyFileException;
import ua.foxminded.ilyapanteleychuk.task6.models.Abbreviation;
import ua.foxminded.ilyapanteleychuk.task6.models.BestLapTime;
import ua.foxminded.ilyapanteleychuk.task6.models.EndLapTime;
import ua.foxminded.ilyapanteleychuk.task6.models.StartLapTime;
import ua.foxminded.ilyapanteleychuk.task6.repository.ModelReaderImplementation;
import ua.foxminded.ilyapanteleychuk.task6.service.mapper.AbbreviationMapper;
import ua.foxminded.ilyapanteleychuk.task6.service.mapper.TimeMapperImplementation;
import java.util.List;
import java.util.Map;


public class RacerService {

    public String printTab(String startFile, String endFile, String abbreviationsFile) {
        String output = null;
        try {
            ModelReaderImplementation reader = new ModelReaderImplementation();
            List<String> startInfo = reader.readFile(startFile);
            List<String> endInfo = reader.readFile(endFile);
            List<String> abbreviationInfo = reader.readFile(abbreviationsFile);
            AbbreviationMapper abbreviationMapper = new AbbreviationMapper();
            Map<String, Abbreviation> abbreviations =
                abbreviationMapper.mapFromString(abbreviationInfo);
            TimeMapperImplementation timeMapper = new TimeMapperImplementation();
            Map<String, StartLapTime> startOfRace = timeMapper.startMapFromString(startInfo);
            Map<String, EndLapTime> endOfRace = timeMapper.endMapFromString(endInfo);
            BestTimeLapCounter lapCounter = new BestTimeLapCounter();
            Map<String, BestLapTime> bestLapTimes =
                lapCounter.countBestLap(startOfRace, endOfRace);
            RaceTabPrinter tabPrinter = new RaceTabPrinter();
            output = tabPrinter.printTab(abbreviations, bestLapTimes);
        }catch (EmptyFileException e) {
            e.printStackTrace();
        }
        return output;
    }
}
