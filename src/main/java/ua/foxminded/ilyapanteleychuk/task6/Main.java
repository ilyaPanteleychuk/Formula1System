package ua.foxminded.ilyapanteleychuk.task6;

import ua.foxminded.ilyapanteleychuk.task6.exception.EmptyFileException;
import ua.foxminded.ilyapanteleychuk.task6.repository.ModelReaderImplementation;
import ua.foxminded.ilyapanteleychuk.task6.service.BestTimeLapCounter;
import ua.foxminded.ilyapanteleychuk.task6.service.RaceTabPrinter;
import ua.foxminded.ilyapanteleychuk.task6.service.RacerService;
import ua.foxminded.ilyapanteleychuk.task6.service.mapper.AbbreviationMapper;
import ua.foxminded.ilyapanteleychuk.task6.service.mapper.TimeMapperImplementation;


public class Main {

    private static final String START_FILE_NAME = "start.log";
    private static final String END_FILE_NAME = "end.log";
    private static final String ABBREVIATION_FILE_NAME = "abbreviations.txt";

    public static void main(String[] args) throws EmptyFileException {
        RacerService racerService =
            new RacerService(new ModelReaderImplementation(), new AbbreviationMapper(),
                new TimeMapperImplementation(), new BestTimeLapCounter(),
                new RaceTabPrinter());
        String output = racerService.printTab(START_FILE_NAME,
            END_FILE_NAME, ABBREVIATION_FILE_NAME);
        System.out.println(output);
    }
}
