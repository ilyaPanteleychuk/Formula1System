package ua.foxminded.ilyapanteleychuk.task6.service;

import ua.foxminded.ilyapanteleychuk.task6.models.Abbreviation;
import ua.foxminded.ilyapanteleychuk.task6.models.BestLapTime;
import java.time.Duration;
import java.util.Map;
import java.util.Set;


public class RaceTabPrinter {

    private static final String WHITE_SPACE = " ";
    private static final int LIMIT_OF_NAME = 25;
    private static final int LIMIT_OF_CAR = 35;


    public String printTab(Map<String, Abbreviation> racerInfo,
                           Map<String, BestLapTime> timeOfLap) {
        StringBuilder output = new StringBuilder();
        Set<String> keySet = timeOfLap.keySet();
        int counter = 0;
        int lengthOfLine = 0;
        for(String key : keySet) {
            if(racerInfo.containsKey(key)) {
                String racerName = racerInfo.get(key).getRacerName();
                String racerCar = racerInfo.get(key).getRacerCar();
                int nameLength = racerName.length();
                int carLength = racerCar.length();
                String bestLap = timeFormatter(timeOfLap.get(key).getBestLapTime());
                output.append(counter + 1).append('.')
                    .append(racerInfo.get(key).getRacerName())
                    .append(drawNameIntend(nameLength, counter))
                    .append('|')
                    .append(racerCar)
                    .append(drawCarIntend(carLength))
                    .append('|')
                    .append(bestLap)
                    .append(System.lineSeparator());
            }
            counter++;
            if(counter == 1) {
                lengthOfLine = output.length();
            }else if(counter == 15) {
                output.append("-".repeat(lengthOfLine)).append(System.lineSeparator());
            }
        }
        return output.toString();
    }

    private String drawNameIntend(int length, int index) {
        String lengthOfPlace = String.valueOf(index + 1);
        if(lengthOfPlace.length() != 1) {
            return WHITE_SPACE.repeat((LIMIT_OF_NAME - length) - 1);
        }else {
            return WHITE_SPACE.repeat((LIMIT_OF_NAME - length));
        }
    }

    private String drawCarIntend(int length) {
        return WHITE_SPACE.repeat((LIMIT_OF_CAR - length));
    }

    private String timeFormatter(Duration duration) {
        String differenceAsString = String.valueOf(duration);
        differenceAsString = differenceAsString.replaceAll("[^\\d.]", "");
        StringBuilder buffer = new StringBuilder(differenceAsString);
        buffer.insert(1, ':');
        return buffer.toString();
    }
}
