package ua.foxminded.ilyapanteleychuk.task6.repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


public class ModelReaderImplementation implements ModelReader {

    @Override
    public List<String> readFile(String fileName) {
        return readInputStream(getFileFromResourceAsStream(fileName));
    }

    private static List<String> readInputStream(InputStream inputStream){
        List<String> lines = new ArrayList<>();
        try(InputStreamReader streamReader =
                    new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(streamReader)) {
            String line;
            while((line = reader.readLine()) != null){
                lines.add(line);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
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
