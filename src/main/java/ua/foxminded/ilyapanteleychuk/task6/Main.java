package ua.foxminded.ilyapanteleychuk.task6;

import ua.foxminded.ilyapanteleychuk.task6.service.RacerService;


public class Main {

    private static final String START_FILE_NAME = "start.log";
    private static final String END_FILE_NAME = "end.log";
    private static final String ABBREVIATION_FILE_NAME = "abbreviations.txt";

    public static void main(String[] args) {
        RacerService racerService = new RacerService();
        String output =
            racerService.printTab(START_FILE_NAME, END_FILE_NAME, ABBREVIATION_FILE_NAME);
        System.out.println(output);
    }
}
