package ua.foxminded.ilyapanteleychuk.task6.repository;

import ua.foxminded.ilyapanteleychuk.task6.exception.EmptyFileException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class ModelReaderImplementation implements ModelReader {

    @Override
    public List<String> readFile(String fileName) throws EmptyFileException {
        List<String> readInfo = readFileImplementation(getFileFromResourceAsStream(fileName));
        if(readInfo.isEmpty()){
            throw new EmptyFileException("Nothing to read. Empty file");
        }else {
            return readFileImplementation(getFileFromResourceAsStream(fileName));
        }
    }

    private List<String> readFileImplementation(InputStream inputStream){
        List<String> fileInfo = new ArrayList<>();
        try(InputStreamReader streamReader =
                    new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(streamReader)) {
            fileInfo = reader.lines().collect(Collectors.toList());
        }catch (IOException e) {
            e.printStackTrace();
        }
        return fileInfo;
    }

    private InputStream getFileFromResourceAsStream(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);
        if(inputStream == null){
            throw new IllegalArgumentException("file not found " + fileName);
        }else{
            return inputStream;
        }
    }
}
