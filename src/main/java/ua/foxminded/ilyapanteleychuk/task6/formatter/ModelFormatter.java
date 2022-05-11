package ua.foxminded.ilyapanteleychuk.task6.formatter;

import ua.foxminded.ilyapanteleychuk.task6.models.Model;

import java.util.ArrayList;
import java.util.List;

public class ModelFormatter {

    public List<Model> format(List<String> startInfo, List<String> endInfo){
        List<Model> timeOfRacers = new ArrayList<>();
        for(int i = 0; i < startInfo.size(); i++){
            String startLine = startInfo.get(i);
            String abbreviation = startLine.substring(0,3);
            String startOfRace = startLine.substring(3);
            for(int k = 0; k < endInfo.size(); k++){
                String endLine = endInfo.get(k);
                if(abbreviation.equals(endLine.substring(0,3))){
                    String endOfRace = endLine.substring(3);
                    timeOfRacers.add(new Model(abbreviation, startOfRace, endOfRace));
                }
            }
        }
        return timeOfRacers;
    }
}
