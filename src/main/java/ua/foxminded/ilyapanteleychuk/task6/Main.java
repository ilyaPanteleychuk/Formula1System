package ua.foxminded.ilyapanteleychuk.task6;

import ua.foxminded.ilyapanteleychuk.task6.service.RacerService;


public class Main {

    public static void main(String[] args) {
        final String START_FILE_NAME = "start.log";
        final String END_FILE_NAME = "end.log";
        final String ABBREVIATION_FILE_NAME = "abbreviations.txt";
        RacerService service = new RacerService();
        service.printTab(START_FILE_NAME, END_FILE_NAME, ABBREVIATION_FILE_NAME);
    }
}
