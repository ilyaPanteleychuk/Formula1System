package ua.foxminded.ilyapanteleychuk.task6.service;

import org.junit.jupiter.api.Test;
import ua.foxminded.ilyapanteleychuk.task6.exception.EmptyFileException;
import static java.lang.System.lineSeparator;
import static org.junit.jupiter.api.Assertions.assertEquals;


class RacerServiceTest {


    @Test
    void printTab_shouldReturnRightOutput_whenAllFilesExist() throws EmptyFileException {
        String startFile = "startTest.log";
        String endFIle = "endTest.log";
        String abbreviationFile = "abbreviationsTest.txt";
        RacerService service = new RacerService();
        String expected = "1.Sebastian Vettel         |FERRARI                            |1:4.415" + lineSeparator() +
                          "2.Nico Hulkenberg          |RENAULT                            |1:13.065" + lineSeparator();

        assertEquals(expected, service.printTab(startFile,endFIle,abbreviationFile));
    }
}
