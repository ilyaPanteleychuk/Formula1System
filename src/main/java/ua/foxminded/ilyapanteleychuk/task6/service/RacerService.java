package ua.foxminded.ilyapanteleychuk.task6.service;

import ua.foxminded.ilyapanteleychuk.task6.exception.EmptyFileException;
import ua.foxminded.ilyapanteleychuk.task6.models.Abbreviation;
import ua.foxminded.ilyapanteleychuk.task6.models.BestRacer;
import ua.foxminded.ilyapanteleychuk.task6.models.RacerTime;
import ua.foxminded.ilyapanteleychuk.task6.repository.ModelReaderImplementation;
import ua.foxminded.ilyapanteleychuk.task6.service.mapper.AbbreviationMapper;
import ua.foxminded.ilyapanteleychuk.task6.service.mapper.RacerTimeMapper;

import java.util.List;

public class RacerService {

    public String printTab(String startFile, String endFile, String abbreviationsFile){
        String output = null;
        try {
            ModelReaderImplementation reader = new ModelReaderImplementation();
            List<String> startInfo = reader.readFile(startFile);
            List<String> endInfo = reader.readFile(endFile);
            List<String> abbreviationInfo = reader.readFile(abbreviationsFile);
            RacerTimeMapper racerTimeMapper = new RacerTimeMapper();
            List<RacerTime> racerTimes = racerTimeMapper.mapFromString(startInfo, endInfo);
            BestTimeLapCounter lapCounter = new BestTimeLapCounter();
            List<BestRacer> bestRacers = lapCounter.countBestLap(racerTimes);
            AbbreviationMapper abbreviationMapper = new AbbreviationMapper();
            List<Abbreviation> abbreviations = abbreviationMapper.mapFromString(abbreviationInfo);
            RaceTabPrinter printer = new RaceTabPrinter();
            output = printer.printTab(bestRacers, abbreviations);
        }catch (EmptyFileException e){
            e.printStackTrace();
        }
        return output;
    }
}
