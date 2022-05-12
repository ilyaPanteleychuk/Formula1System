package ua.foxminded.ilyapanteleychuk.task6.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;



class ModelReaderImplementationTest {

    private static final String START_LOG_FILE = "start.log";
    private static final String END_LOG_FILE = "end.log";
    private static final String ABBREVIATION_FILE = "abbreviations.txt";
    private ModelReaderImplementation reader;
    private List<String> content;
    private ClassLoader classLoader;

    @BeforeEach
    void init(){
        content = new ArrayList<>();
        reader = new ModelReaderImplementation();
        classLoader = getClass().getClassLoader();
    }

    @Test
    void readFile_shouldReturnRightArrayList_whenInputIsStartLogFile() throws IOException {
        InputStream inputStream = classLoader.getResourceAsStream(START_LOG_FILE);
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader buffer = new BufferedReader(streamReader);
        String line;
        while((line = buffer.readLine()) != null){
            content.add(line);
        }
        assertEquals(reader.readFile("start.log"), content);
    }

    @Test
    void readFile_shouldReturnRightArrayList_whenInputIsEndLogFile() throws IOException{
        InputStream inputStream = classLoader.getResourceAsStream(END_LOG_FILE);
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader buffer = new BufferedReader(streamReader);
        String line;
        while((line = buffer.readLine()) != null){
            content.add(line);
        }
        assertEquals(reader.readFile("end.log"), content);
    }

    @Test
    void readFile_shouldReturnRightArrayList_whenInputIsAbbreviationTxtFile() throws IOException{
        InputStream inputStream = classLoader.getResourceAsStream(ABBREVIATION_FILE);
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader buffer = new BufferedReader(streamReader);
        String line;
        while((line = buffer.readLine()) != null){
            content.add(line);
        }
        assertEquals(reader.readFile("abbreviations.txt"), content);
    }
}