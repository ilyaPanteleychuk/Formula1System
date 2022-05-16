package ua.foxminded.ilyapanteleychuk.task6.service.mapper;

import ua.foxminded.ilyapanteleychuk.task6.models.Abbreviation;
import java.util.ArrayList;
import java.util.List;


public class AbbreviationMapper {

    public List<Abbreviation> mapFromString(List<String> abbreviationInfo){
        List<Abbreviation> racersAbbreviations = new ArrayList<>();
        for(String line : abbreviationInfo) {
            String abbreviation = line.substring(0, 3);
            String nameOfRacer = line.substring(4, line.lastIndexOf("_"));
            String carOfRacer = line.substring(line.lastIndexOf("_") + 1);
            racersAbbreviations.add(new Abbreviation(abbreviation, nameOfRacer, carOfRacer));
        }
        return racersAbbreviations;
    }
}
