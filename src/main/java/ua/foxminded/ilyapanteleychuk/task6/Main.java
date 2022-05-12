package ua.foxminded.ilyapanteleychuk.task6;

import ua.foxminded.ilyapanteleychuk.task6.service.AbbreviationFormatter;
import ua.foxminded.ilyapanteleychuk.task6.service.ModelFormatter;
import ua.foxminded.ilyapanteleychuk.task6.models.Abbreviation;
import ua.foxminded.ilyapanteleychuk.task6.models.BestRacer;
import ua.foxminded.ilyapanteleychuk.task6.models.Model;
import ua.foxminded.ilyapanteleychuk.task6.repository.ModelReaderImplementation;
import ua.foxminded.ilyapanteleychuk.task6.service.BestTimeLapCounter;
import ua.foxminded.ilyapanteleychuk.task6.service.RaceTabPrint;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        ModelReaderImplementation startReader = new ModelReaderImplementation();
        List<String> startInfo = startReader.readFile("start.log");
        List<String> endInfo = startReader.readFile("end.log");
        List<String> abbreviationInfo = startReader.readFile("abbreviations.txt");
        ModelFormatter formatter = new ModelFormatter();
        List<Model> models = formatter.format(startInfo, endInfo);
        BestTimeLapCounter lapCounter = new BestTimeLapCounter();
        List<BestRacer> bestRacers = lapCounter.countBestLap(models);
        AbbreviationFormatter abbreviationFormatter = new AbbreviationFormatter();
        List<Abbreviation> abbreviations = abbreviationFormatter.format(abbreviationInfo);
        RaceTabPrint printer = new RaceTabPrint();
        String output = printer.printTab(bestRacers, abbreviations);
        System.out.println(output);
    }
}
