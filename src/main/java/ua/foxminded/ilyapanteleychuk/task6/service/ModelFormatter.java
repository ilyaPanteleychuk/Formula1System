package ua.foxminded.ilyapanteleychuk.task6.service;

import ua.foxminded.ilyapanteleychuk.task6.models.Model;
import java.util.ArrayList;
import java.util.List;

public class ModelFormatter {

    public List<Model> format(List<String> startRaceInfo, List<String> endRaceInfo){
        return formatRealization(startRaceInfo, endRaceInfo);
    }

    private List<Model> formatRealization(List<String> startRaceInfo, List<String> endRaceInfo){
        List<Model> timeOfRace = new ArrayList<>();
        for(int i = 0; i < startRaceInfo.size(); i++){
            String startLine = startRaceInfo.get(i);
            String abbreviation = startLine.substring(0,3);
            String startOfRace = startLine.substring(3);
            for(int k = 0; k < endRaceInfo.size(); k++){
                String endLine = endRaceInfo.get(k);
                if(abbreviation.equals(endLine.substring(0,3))){
                    String endOfRace = endLine.substring(3);
                    timeOfRace.add(new Model(abbreviation, startOfRace, endOfRace));
                }
            }
        }
        return timeOfRace;
    }
}
