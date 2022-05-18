package ua.foxminded.ilyapanteleychuk.task6.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ua.foxminded.ilyapanteleychuk.task6.exception.EmptyFileException;
import ua.foxminded.ilyapanteleychuk.task6.repository.ModelReaderImplementation;
import ua.foxminded.ilyapanteleychuk.task6.service.mapper.AbbreviationMapper;
import ua.foxminded.ilyapanteleychuk.task6.service.mapper.TimeMapperImplementation;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;


class RacerServiceTest {

    private final ModelReaderImplementation mockReader = Mockito.mock(ModelReaderImplementation.class);
    private final AbbreviationMapper mockAbbreviationMapper = Mockito.mock(AbbreviationMapper.class);
    private final TimeMapperImplementation mockTimeMapper = Mockito.mock(TimeMapperImplementation.class);
    private final BestTimeLapCounter mockLapCounter = Mockito.mock(BestTimeLapCounter.class);
    private final RaceTabPrinter mockPrinter = Mockito.mock(RaceTabPrinter.class);
    private final RacerService service = new RacerService(mockReader, mockAbbreviationMapper,
        mockTimeMapper, mockLapCounter, mockPrinter);


    @Test
    void printTab_shouldCallMethodReadFile3Times_whenParametersAre3Files() throws EmptyFileException {
        service.printTab("file1", "file2", "file3");
        verify(mockReader, times(1)).readFile("file1");
        verify(mockReader, times(1)).readFile("file2");
        verify(mockReader, times(1)).readFile("file3");
    }

    @Test
    void printTab_shouldThrowEmptyFileException_whenOneOfFilesIsEmpty() throws EmptyFileException {
        when(mockReader.readFile("file")).thenThrow(new EmptyFileException("message"));
        assertThrows(EmptyFileException.class,
            () -> service.printTab("file", "file1", "file2"));
    }

    @Test
    void printTab_shouldThrowIllegalArgumentException_whenFileDoesNotExist() throws EmptyFileException {
        when(mockReader.readFile("non-existingFile")).thenThrow(new IllegalArgumentException());
        assertThrows(IllegalArgumentException.class,
            () -> service.printTab("non-existingFile", "end", "abbreviation"));
    }

    @Test
    void printTab_shouldCallTimeMapper2Time_whenInputIsCorrect() throws EmptyFileException {
        service.printTab("file1", "file2", "file3");
        verify(mockTimeMapper, times(1)).startMapFromString(new ArrayList<>());
        verify(mockTimeMapper, times(1)).endMapFromString(new ArrayList<>());
    }

    @Test
    void printTab_shouldThrowDateTimeParseException_whenDatePatternDoesNotFit() {
        when(mockTimeMapper.startMapFromString(new ArrayList<>()))
            .thenThrow(new DateTimeParseException("text", "text", 0));
        assertThrows(DateTimeParseException.class, () ->
            service.printTab("file", "file2", "file3"));
    }

    @Test
    void printTab_shouldCallAbbreviationMapper1Time_whenInputIsCorrect() throws EmptyFileException {
        service.printTab("file1", "file2", "file3");
        verify(mockAbbreviationMapper, times(1)).mapFromString(new ArrayList<>());
    }

    @Test
    void printTab_shouldThrowStringIndexOutOfBoundsException_whenAbbreviationPatternDoesNotFit() {
        when(mockAbbreviationMapper.mapFromString(new ArrayList<>()))
            .thenThrow(new StringIndexOutOfBoundsException());
        assertThrows(StringIndexOutOfBoundsException.class,
            () -> service.printTab("file", "file2", "file3"));
    }

    @Test
    void printTab_shouldCallBestTimeLapCounter1Time_whenInputIsCorrect() throws EmptyFileException {
        service.printTab("file1", "file2", "file3");
        verify(mockLapCounter, times(1))
            .countBestLap(new HashMap<>(), new HashMap<>());
    }

    @Test
    void printTab_shouldCallRaceTabPrinterOneTime_whenInputIsCorrect() throws EmptyFileException {
        service.printTab("file1", "file2", "file3");
        verify(mockPrinter, times(1))
            .printTab(new HashMap<>(), new HashMap<>());
    }
}
