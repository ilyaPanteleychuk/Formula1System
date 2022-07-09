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

    private final ModelReaderImplementation reader;
    private final AbbreviationMapper abbreviationMapper;
    private final TimeMapperImplementation timeMapper;
    private final BestTimeLapCounter lapCounter;
    private final RaceTabPrinter tabPrinter;

    public RacerService(ModelReaderImplementation reader, AbbreviationMapper abbreviationMapper,
                        TimeMapperImplementation timeMapper, BestTimeLapCounter lapCounter,
                        RaceTabPrinter tabPrinter) {
        this.reader = reader;
        this.abbreviationMapper = abbreviationMapper;
        this.timeMapper = timeMapper;
        this.lapCounter = lapCounter;
        this.tabPrinter = tabPrinter;
    }

    public String printTab(String startFile, String endFile, String abbreviationsFile) throws EmptyFileException {
        List<String> startInfo = reader.readFile(startFile);
        List<String> endInfo = reader.readFile(endFile);
        List<String> abbreviationInfo = reader.readFile(abbreviationsFile);
        Map<String, Abbreviation> abbreviations =
                abbreviationMapper.mapFromString(abbreviationInfo);
        Map<String, StartLapTime> startOfRace = timeMapper.startMapFromString(startInfo);
        Map<String, EndLapTime> endOfRace = timeMapper.endMapFromString(endInfo);
        Map<String, BestLapTime> bestLapTimes =
                lapCounter.countBestLap(startOfRace, endOfRace);
        return tabPrinter.printTab(abbreviations, bestLapTimes);
    }
}
