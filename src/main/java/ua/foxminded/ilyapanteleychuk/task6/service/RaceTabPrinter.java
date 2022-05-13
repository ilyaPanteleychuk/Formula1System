package ua.foxminded.ilyapanteleychuk.task6.service;

import ua.foxminded.ilyapanteleychuk.task6.models.Abbreviation;
import ua.foxminded.ilyapanteleychuk.task6.models.BestRacer;
import java.time.Duration;
import java.util.List;


public class RaceTabPrinter {

    private static final String WHITE_SPACE = " ";
    private static final int LIMIT_OF_NAME = 25;
    private static final int LIMIT_OF_CAR = 35;

    public String printTab(List<BestRacer> bestRacers, List<Abbreviation> abbreviations) {
        StringBuilder output = new StringBuilder();
        abbreviationSorter(bestRacers, abbreviations);
        int lengthOfLine = 0;
        for(int i = 0; i < bestRacers.size(); i++){
            if(i == 1){
                lengthOfLine = output.length();
            }else if(i == 15){
                output.append("-".repeat(lengthOfLine)).append(System.lineSeparator());
            }
            int placeOfRacer = i + 1;
            String name = abbreviations.get(i).getRacerName();
            int lengthOfName = name.length();
            String car = abbreviations.get(i).getRacerCar();
            int lengthOfCar = car.length();
            String timeOfLap = timeFormatter(bestRacers.get(i).getBestLapTime());
            output.append(placeOfRacer).append('.')
                                       .append(name)
                                       .append(drawNameIntend(lengthOfName, i))
                                       .append('|')
                                       .append(car)
                                       .append(drawCarIntend(lengthOfCar))
                                       .append('|')
                                       .append(timeOfLap)
                                       .append(System.lineSeparator());
        }
        return output.toString();
    }

    private String drawNameIntend(int length, int index){
        String lengthOfPlace = String.valueOf(index + 1);
        if(lengthOfPlace.length() != 1){
            return WHITE_SPACE.repeat((LIMIT_OF_NAME - length) - 1);
        }else {
            return WHITE_SPACE.repeat((LIMIT_OF_NAME - length));
        }
    }

    private String drawCarIntend(int length){
        return WHITE_SPACE.repeat((LIMIT_OF_CAR - length));
    }

    private String timeFormatter(Duration duration){
        String differenceAsString = String.valueOf(duration);
        differenceAsString = differenceAsString.replaceAll("[^\\d.]", "");
        StringBuilder buffer = new StringBuilder(differenceAsString);
        buffer.insert(1, ':');
        return buffer.toString();
    }

    private void abbreviationSorter(List<BestRacer> bestRacers,
                                                List<Abbreviation> abbreviations){
        for(int i = 0; i < bestRacers.size(); i++){
            String abbreviation = bestRacers.get(i).getAbbreviation();
            for(int k = 0; k != abbreviations.size(); k++){
                if(abbreviation.equals(abbreviations.get(k).getAbbreviation())){
                    Abbreviation abbreviationToReplace = abbreviations.get(k);
                    abbreviations.remove(abbreviationToReplace);
                    abbreviations.add(i, abbreviationToReplace);
                }
            }
        }
    }
}
