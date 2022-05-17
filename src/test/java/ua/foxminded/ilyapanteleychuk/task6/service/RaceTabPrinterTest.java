package ua.foxminded.ilyapanteleychuk.task6.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.foxminded.ilyapanteleychuk.task6.models.Abbreviation;
import ua.foxminded.ilyapanteleychuk.task6.models.BestLapTime;
import ua.foxminded.ilyapanteleychuk.task6.util.DateUtil;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import static java.lang.System.lineSeparator;
import static org.junit.jupiter.api.Assertions.assertEquals;


class RaceTabPrinterTest {

    private Map<String, BestLapTime> bestRacerTimes;
    private Map<String, Abbreviation> abbreviations;
    private RaceTabPrinter printer;

    @BeforeEach
    void init(){
        bestRacerTimes = new HashMap<>();
        abbreviations = new HashMap<>();
        printer = new RaceTabPrinter();
    }
    @Test
    void printTab_shouldPrintRightTabWithSeparator_whenListSizeMoreThan15() {
        BestLapTime racerTime1 = new BestLapTime(Duration.between(
                DateUtil.timeFormatterByPattern("2018-05-24_12:02:58.917"),
                        DateUtil.timeFormatterByPattern("2018-05-24_12:04:03.332")));
        BestLapTime racerTime2 = new BestLapTime(Duration.between(
                DateUtil.timeFormatterByPattern("2018-05-24_12:02:49.914"),
                        DateUtil.timeFormatterByPattern("2018-05-24_12:04:02.979")));
        BestLapTime racerTime3 = new BestLapTime(Duration.between(
                DateUtil.timeFormatterByPattern("2018-05-24_12:13:04.512"),
                        DateUtil.timeFormatterByPattern("2018-05-24_12:14:17.169")));
        BestLapTime racerTime4 = new BestLapTime(Duration.between(
                DateUtil.timeFormatterByPattern("2018-05-24_12:03:01.250"),
                        DateUtil.timeFormatterByPattern("2018-05-24_12:04:13.889")));
        BestLapTime racerTime5 = new BestLapTime(Duration.between(
                DateUtil.timeFormatterByPattern("2018-05-24_12:18:37.735"),
                        DateUtil.timeFormatterByPattern("2018-05-24_12:19:50.198")));
        BestLapTime racerTime6 = new BestLapTime(Duration.between(
                DateUtil.timeFormatterByPattern("2018-05-24_12:04:45.513"),
                        DateUtil.timeFormatterByPattern("2018-05-24_12:05:58.778")));
        BestLapTime racerTime7 = new BestLapTime(Duration.between(
                DateUtil.timeFormatterByPattern("2018-05-24_12:06:13.511"),
                        DateUtil.timeFormatterByPattern("2018-05-24_12:07:26.834")));
        BestLapTime racerTime8 = new BestLapTime(Duration.between(
                DateUtil.timeFormatterByPattern("2018-05-24_12:14:51.985"),
                        DateUtil.timeFormatterByPattern("2018-05-24_12:16:05.164")));
        BestLapTime racerTime9 = new BestLapTime(Duration.between(
                DateUtil.timeFormatterByPattern("2018-05-24_12:17:58.810"),
                        DateUtil.timeFormatterByPattern("2018-05-24_12:19:11.838")));
        BestLapTime racerTime10 = new BestLapTime(Duration.between(
                DateUtil.timeFormatterByPattern("2018-05-24_12:05:14.511"),
                        DateUtil.timeFormatterByPattern("2018-05-24_12:06:27.441")));
        BestLapTime racerTime11 = new BestLapTime(Duration.between(
                DateUtil.timeFormatterByPattern("2018-05-24_12:16:11.648"),
                        DateUtil.timeFormatterByPattern("2018-05-24_12:17:24.354")));
        BestLapTime racerTime12 = new BestLapTime(Duration.between(
                DateUtil.timeFormatterByPattern("2018-05-24_12:02:51.003"),
                        DateUtil.timeFormatterByPattern("2018-05-24_12:04:04.396")));
        BestLapTime racerTime13 = new BestLapTime(Duration.between(
                DateUtil.timeFormatterByPattern("2018-05-24_12:07:23.645"),
                        DateUtil.timeFormatterByPattern("2018-05-24_12:08:36.586")));
        BestLapTime racerTime14 = new BestLapTime(Duration.between(
                DateUtil.timeFormatterByPattern("2018-05-24_12:03:15.145"),
                        DateUtil.timeFormatterByPattern("2018-05-24_12:04:28.095")));
        BestLapTime racerTime15 = new BestLapTime(Duration.between(
                DateUtil.timeFormatterByPattern("2018-05-24_12:12:01.035"),
                        DateUtil.timeFormatterByPattern("2018-05-24_12:13:13.883")));
        BestLapTime racerTime16 = new BestLapTime(Duration.between(
                DateUtil.timeFormatterByPattern("2018-05-24_12:14:12.054"),
                DateUtil.timeFormatterByPattern("2018-05-24_12:15:24.067")));
        bestRacerTimes.put("SVF", racerTime1);
        bestRacerTimes.put("NHR", racerTime2);
        bestRacerTimes.put("FAM", racerTime3);
        bestRacerTimes.put("KRF", racerTime4);
        bestRacerTimes.put("SVM", racerTime5);
        bestRacerTimes.put("MES", racerTime6);
        bestRacerTimes.put("LSW", racerTime7);
        bestRacerTimes.put("BHS", racerTime8);
        bestRacerTimes.put("EOF", racerTime9);
        bestRacerTimes.put("RGH", racerTime10);
        bestRacerTimes.put("SSW", racerTime11);
        bestRacerTimes.put("KMH", racerTime12);
        bestRacerTimes.put("PGS", racerTime13);
        bestRacerTimes.put("CSR", racerTime14);
        bestRacerTimes.put("SPF", racerTime15);
        bestRacerTimes.put("DRR", racerTime16);
        Abbreviation abbreviation1 = new Abbreviation(
                "Daniel Riccardo","RED BULL RACING TAG HEUER");
        Abbreviation abbreviation2 = new Abbreviation(
                "Sebastian Vettel","FERRARI");
        Abbreviation abbreviation3 = new Abbreviation(
                "Lewis Hamilton","MERCEDES");
        Abbreviation abbreviation4 = new Abbreviation(
                "Kimi Raikkonen","FERRARI");
        Abbreviation abbreviation5 = new Abbreviation(
                "Valtteri Bottas","MERCEDES");
        Abbreviation abbreviation6 = new Abbreviation(
                "Esteban Ocon","FORCE INDIA MERCEDES");
        Abbreviation abbreviation7 = new Abbreviation(
                "Fernando Alonso","MCLAREN RENAULT");
        Abbreviation abbreviation8 = new Abbreviation(
                "Carlos Sainz","RENAULT");
        Abbreviation abbreviation9 = new Abbreviation(
                "Sergio Perez","FORCE INDIA MERCEDES");
        Abbreviation abbreviation10 = new Abbreviation(
                "Pierre Gasly","SCUDERIA TORO ROSSO HONDA");
        Abbreviation abbreviation11 = new Abbreviation(
                "Nico Hulkenberg","RENAULT");
        Abbreviation abbreviation12 = new Abbreviation(
                "Stoffel Vandoorne","MCLAREN RENAULT");
        Abbreviation abbreviation13 = new Abbreviation(
                "Sergey Sirotkin","WILLIAMS MERCEDES");
        Abbreviation abbreviation14 = new Abbreviation(
                "Kevin Magnussen","HAAS FERRARI");
        Abbreviation abbreviation15 = new Abbreviation(
                "Charles Leclerc","SAUBER FERRARI");
        Abbreviation abbreviation16 = new Abbreviation(
                "Romain Grosjean","HAAS FERRARI");
        abbreviations.put("DRR", abbreviation1);
        abbreviations.put("SVF", abbreviation2);
        abbreviations.put("LHM", abbreviation3);
        abbreviations.put("KRF", abbreviation4);
        abbreviations.put("VBM", abbreviation5);
        abbreviations.put("EOF", abbreviation6);
        abbreviations.put("FAM", abbreviation7);
        abbreviations.put("CSR", abbreviation8);
        abbreviations.put("SPF", abbreviation9);
        abbreviations.put("PGS", abbreviation10);
        abbreviations.put("NHR", abbreviation11);
        abbreviations.put("SVM", abbreviation12);
        abbreviations.put("SSW", abbreviation13);
        abbreviations.put("KMH", abbreviation14);
        abbreviations.put("CLS", abbreviation15);
        abbreviations.put("RGH", abbreviation16);
        String expected =
            "1.Sebastian Vettel         |FERRARI                            |1:4.415" + lineSeparator() +
            "2.Carlos Sainz             |RENAULT                            |1:12.95" + lineSeparator() +
            "3.Daniel Riccardo          |RED BULL RACING TAG HEUER          |1:12.013" + lineSeparator() +
            "4.Kevin Magnussen          |HAAS FERRARI                       |1:13.393" + lineSeparator() +
            "5.Sergio Perez             |FORCE INDIA MERCEDES               |1:12.848" + lineSeparator() +
            "6.Stoffel Vandoorne        |MCLAREN RENAULT                    |1:12.463" + lineSeparator() +
            "9.Romain Grosjean          |HAAS FERRARI                       |1:12.93" + lineSeparator() +
            "10.Fernando Alonso         |MCLAREN RENAULT                    |1:12.657" + lineSeparator() +
            "11.Sergey Sirotkin         |WILLIAMS MERCEDES                  |1:12.706" + lineSeparator() +
            "12.Nico Hulkenberg         |RENAULT                            |1:13.065" + lineSeparator() +
            "14.Esteban Ocon            |FORCE INDIA MERCEDES               |1:13.028" + lineSeparator() +
            "15.Pierre Gasly            |SCUDERIA TORO ROSSO HONDA          |1:12.941" + lineSeparator() +
            "-------------------------------------------------------------------------" + lineSeparator() +
            "16.Kimi Raikkonen          |FERRARI                            |1:12.639" + lineSeparator();
        assertEquals(expected, printer.printTab(abbreviations, bestRacerTimes));
    }

    @Test
    void printTab_shouldPrintRightTabWithoutSeparator_whenListSizeIsLessThan15(){
        BestLapTime racerTime1 = new BestLapTime(Duration.between(
                DateUtil.timeFormatterByPattern("2018-05-24_12:02:58.917"),
                        DateUtil.timeFormatterByPattern("2018-05-24_12:04:03.332")));
        BestLapTime racerTime2 = new BestLapTime(Duration.between(
                DateUtil.timeFormatterByPattern("2018-05-24_12:02:49.914"),
                        DateUtil.timeFormatterByPattern("2018-05-24_12:04:02.979")));
        BestLapTime racerTime3 = new BestLapTime(Duration.between(
                DateUtil.timeFormatterByPattern("2018-05-24_12:13:04.512"),
                        DateUtil.timeFormatterByPattern("2018-05-24_12:14:17.169")));
        BestLapTime racerTime4 = new BestLapTime(Duration.between(
                DateUtil.timeFormatterByPattern("2018-05-24_12:03:01.250"),
                        DateUtil.timeFormatterByPattern("2018-05-24_12:04:13.889")));
        bestRacerTimes.put("SVF", racerTime1);
        bestRacerTimes.put("NHR", racerTime2);
        bestRacerTimes.put("FAM", racerTime3);
        bestRacerTimes.put("KRF", racerTime4);
        Abbreviation abbreviation1 = new Abbreviation(
                "Sebastian Vettel","FERRARI");
        Abbreviation abbreviation2 = new Abbreviation(
                "Nico Hulkenberg","RENAULT");
        Abbreviation abbreviation3 = new Abbreviation(
                "Fernando Alonso","MCLAREN RENAULT");
        Abbreviation abbreviation4 = new Abbreviation(
                "Kimi Raikkonen","FERRARI");
        abbreviations.put("SVF", abbreviation1);
        abbreviations.put("NHR", abbreviation2);
        abbreviations.put("FAM", abbreviation3);
        abbreviations.put("KRF", abbreviation4);
        String expected =
            "1.Sebastian Vettel         |FERRARI                            |1:4.415" + lineSeparator() +
            "2.Fernando Alonso          |MCLAREN RENAULT                    |1:12.657" + lineSeparator() +
            "3.Nico Hulkenberg          |RENAULT                            |1:13.065" + lineSeparator() +
            "4.Kimi Raikkonen           |FERRARI                            |1:12.639" + lineSeparator();
        assertEquals(expected, printer.printTab(abbreviations, bestRacerTimes));
    }
}
