package ua.foxminded.ilyapanteleychuk.task6.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.foxminded.ilyapanteleychuk.task6.exception.EmptyFileException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class RacerTimeReaderImplementationTest {

    private ModelReaderImplementation reader;
    private List<String> content;

    @BeforeEach
    void init(){
        content = new ArrayList<>();
        reader = new ModelReaderImplementation();
    }

    @Test
    void readFile_shouldReadFileCorrectly_whenFileHasContentButNotSingleLine() throws EmptyFileException {
        String firstLine = "SVF2018-05-24_12:02:58.917";
        String secondLine = "NHR2018-05-24_12:02:49.914";
        String thirdLine = "FAM2018-05-24_12:13:04.512";
        content.add(firstLine);
        content.add(secondLine);
        content.add(thirdLine);
        assertEquals(content, reader.readFile("severalLineFileTest.log"));
    }

    @Test
    void readFile_shouldReadFileCorrectly_whenInputIsEndLogFile() throws EmptyFileException {
        String singleLine = "MES2018-05-24_12:05:58.778";
        content.add(singleLine);
        assertEquals(content, reader.readFile("singleLineTestFile.log"));
    }

    @Test
    void readFile_sholdTrowsIllegalArgumentException_whenFileDoesNotExist(){
        assertThrows(IllegalArgumentException.class, () -> reader.readFile("non-existing file"));
    }

    @Test
    void readFile_shouldThrowIllegalArgumentException_whenFileIsEmpty(){
        assertThrows(EmptyFileException.class, () -> reader.readFile("emptyFile.txt"));
    }
}
