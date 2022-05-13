package ua.foxminded.ilyapanteleychuk.task6.service.formatter;

import org.junit.jupiter.api.Test;
import ua.foxminded.ilyapanteleychuk.task6.models.Model;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;


class ModelFormatterTest {

    @Test
    void format_shouldCreateArrayListWithRightModelObjects_whenInputIsStringArrayList() {
        String startOfRace = "SVF2018-05-24_12:02:58.917";
        List<String> startInfo = new ArrayList<>();
        startInfo.add(startOfRace);
        String endOfRace = "SVF2018-05-24_12:04:03.332";
        List<String> endInfo = new ArrayList<>();
        endInfo.add(endOfRace);
        Model expectedRacer = new Model("SVF",
                "2018-05-24_12:02:58.917", "2018-05-24_12:04:03.332");
        ModelFormatter formatter = new ModelFormatter();
        List<Model> models = formatter.format(startInfo, endInfo);
        Model actualRacer = models.get(0);
        boolean isEquals = expectedRacer.equals(actualRacer);
        assertTrue(isEquals);
    }
}