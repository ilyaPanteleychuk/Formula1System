package ua.foxminded.ilyapanteleychuk.task6.service;

import ua.foxminded.ilyapanteleychuk.task6.models.Abbreviation;

import java.util.ArrayList;
import java.util.List;


public class AbbreviationFormatter {

    public List<Abbreviation> format(List<String> abbreviationInfo){
        return formatRealization(abbreviationInfo);
    }

    private List<Abbreviation> formatRealization(List<String> abbreviationInfo){
        List<Abbreviation> racersAbbreviations = new ArrayList<>();
        for(int i = 0; i < abbreviationInfo.size(); i++){
            String line = abbreviationInfo.get(i);
            String abbreviation = line.substring(0, 3);
            String nameOfRacer = line.substring(4, line.lastIndexOf("_"));
            String carOfRacer = line.substring(line.lastIndexOf("_") + 1);
            racersAbbreviations.add(new Abbreviation(abbreviation, nameOfRacer, carOfRacer));
        }
        return racersAbbreviations;
    }
}
