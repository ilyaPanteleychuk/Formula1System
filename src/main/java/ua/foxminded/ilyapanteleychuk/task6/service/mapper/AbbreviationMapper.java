package ua.foxminded.ilyapanteleychuk.task6.service.mapper;

import ua.foxminded.ilyapanteleychuk.task6.models.Abbreviation;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class AbbreviationMapper {

    public Map<String, Abbreviation> mapFromString(List<String> abbreviationInfo) {
        return abbreviationInfo.stream()
            .collect(Collectors.toMap(el -> el.substring(0, 3),
                el -> new Abbreviation(el.substring(4, el.lastIndexOf("_")),
                    el.substring(el.lastIndexOf("_") + 1))));
    }
}
