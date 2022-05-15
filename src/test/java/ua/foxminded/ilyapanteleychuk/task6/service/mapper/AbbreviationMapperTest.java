package ua.foxminded.ilyapanteleychuk.task6.service.mapper;

import org.junit.jupiter.api.Test;
import ua.foxminded.ilyapanteleychuk.task6.models.Abbreviation;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;


class AbbreviationMapperTest {

    @Test
    void format_shouldReturnRightAbbreviationListWithRightObjects_whenInputIsListOfString() {
        List<String> abbreviationInfo = new ArrayList<>();
        abbreviationInfo.add("DRR_Daniel Ricciardo_RED BULL RACING TAG HEUER");
        String abbreviation = "DRR";
        String nameOfRacer = "Daniel Ricciardo";
        String nameOfCar = "RED BULL RACING TAG HEUER";
        Abbreviation expected = new Abbreviation(abbreviation, nameOfRacer, nameOfCar);
        AbbreviationMapper formatter = new AbbreviationMapper();
        List<Abbreviation> abbreviationList = formatter.mapFromString(abbreviationInfo);
        Abbreviation actual = abbreviationList.get(0);
        boolean isEquals = expected.equals(actual);
        assertTrue(isEquals);
    }
}
