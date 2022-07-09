package ua.foxminded.ilyapanteleychuk.task6.service.mapper;

import org.junit.jupiter.api.Test;
import ua.foxminded.ilyapanteleychuk.task6.models.Abbreviation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;


class AbbreviationMapperTest {

    @Test
    void format_shouldReturnRightAbbreviationMapWithRightObjects_whenInputIsListOfString() {
        List<String> abbreviationInfo = new ArrayList<>();
        abbreviationInfo.add("DRR_Daniel Ricciardo_RED BULL RACING TAG HEUER");
        String abbreviation = "DRR";
        String nameOfRacer = "Daniel Ricciardo";
        String nameOfCar = "RED BULL RACING TAG HEUER";
        Map<String, Abbreviation> expected = new HashMap<>();
        expected.put(abbreviation, new Abbreviation(nameOfRacer, nameOfCar));
        AbbreviationMapper abbreviationMapper = new AbbreviationMapper();
        assertEquals(expected, abbreviationMapper.mapFromString(abbreviationInfo));
    }
}
