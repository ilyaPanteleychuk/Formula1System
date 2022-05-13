package ua.foxminded.ilyapanteleychuk.task6;

import ua.foxminded.ilyapanteleychuk.task6.exception.EmptyFileException;
import ua.foxminded.ilyapanteleychuk.task6.service.formatter.AbbreviationFormatter;
import ua.foxminded.ilyapanteleychuk.task6.service.formatter.ModelFormatter;
import ua.foxminded.ilyapanteleychuk.task6.models.Abbreviation;
import ua.foxminded.ilyapanteleychuk.task6.models.BestRacer;
import ua.foxminded.ilyapanteleychuk.task6.models.Model;
import ua.foxminded.ilyapanteleychuk.task6.repository.ModelReaderImplementation;
import ua.foxminded.ilyapanteleychuk.task6.service.BestTimeLapCounter;
import ua.foxminded.ilyapanteleychuk.task6.service.RaceTabPrinter;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        try {
            ModelReaderImplementation reader = new ModelReaderImplementation();
            List<String> startInfo = reader.readFile("start.log");
            List<String> endInfo = reader.readFile("end.log");
            List<String> abbreviationInfo = reader.readFile("abbreviations.txt");
            ModelFormatter modelFormatter = new ModelFormatter();
            List<Model> models = modelFormatter.format(startInfo, endInfo);
            BestTimeLapCounter lapCounter = new BestTimeLapCounter();
            List<BestRacer> bestRacers = lapCounter.countBestLap(models);
            AbbreviationFormatter abbreviationFormatter = new AbbreviationFormatter();
            List<Abbreviation> abbreviations = abbreviationFormatter.format(abbreviationInfo);
            RaceTabPrinter printer = new RaceTabPrinter();
            String output = printer.printTab(bestRacers, abbreviations);
            System.out.println(output);
        }catch (EmptyFileException e){
            e.printStackTrace();
        }
    }
}
