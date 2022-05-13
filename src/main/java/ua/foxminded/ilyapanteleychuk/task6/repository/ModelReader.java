package ua.foxminded.ilyapanteleychuk.task6.repository;

import ua.foxminded.ilyapanteleychuk.task6.exception.EmptyFileException;
import java.util.List;


public interface ModelReader {

    List<String> readFile(String fileName) throws EmptyFileException;
}
