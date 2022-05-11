package ua.foxminded.ilyapanteleychuk.task6.formatter;

import org.junit.jupiter.api.Test;
import ua.foxminded.ilyapanteleychuk.task6.models.Model;
import ua.foxminded.ilyapanteleychuk.task6.repository.StartReaderImplementation;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


class ModelFormatterTest {

    StartReaderImplementation reader;

    @Test
    void format() {
        List<String> endList = reader.readFile("end.log");
        List<String> startList = reader.readFile("start.log");
        ModelFormatter formatter = new ModelFormatter();

        Model model = new Model(startList.get(0).)
    }
}