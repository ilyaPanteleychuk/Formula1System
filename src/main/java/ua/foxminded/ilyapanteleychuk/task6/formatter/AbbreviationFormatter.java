package ua.foxminded.ilyapanteleychuk.task6.formatter;

import ua.foxminded.ilyapanteleychuk.task6.models.Abbreviation;

import java.util.ArrayList;
import java.util.List;


public class AbbreviationFormatter {

    public List<Abbreviation> format(List<String> abbreviationInfo){
        List<Abbreviation> abbreviations = new ArrayList<>();
        for(int i = 0; i < abbreviationInfo.size(); i++){
            String line = abbreviationInfo.get(i);
            String abbreviation = line.substring(0, 3);
            String nameOfRacer = line.substring(4, line.lastIndexOf("_"));
            String carOfRacer = line.substring(line.lastIndexOf("_") + 1);
            abbreviations.add(new Abbreviation(abbreviation, nameOfRacer, carOfRacer));
        }
        return abbreviations;
    }
}
