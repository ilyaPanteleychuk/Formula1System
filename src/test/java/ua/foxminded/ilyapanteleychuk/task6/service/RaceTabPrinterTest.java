package ua.foxminded.ilyapanteleychuk.task6.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.foxminded.ilyapanteleychuk.task6.models.Abbreviation;
import ua.foxminded.ilyapanteleychuk.task6.models.BestRacer;
import ua.foxminded.ilyapanteleychuk.task6.models.RacerTime;
import ua.foxminded.ilyapanteleychuk.task6.util.DateUtil;
import java.util.ArrayList;
import java.util.List;
import static java.lang.System.lineSeparator;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RaceTabPrinterTest {

    private List<RacerTime> racerTimes;
    private BestTimeLapCounter lapCounter;
    private List<Abbreviation> abbreviations;
    private RaceTabPrinter printer;

    @BeforeEach
    void init(){
        racerTimes = new ArrayList<>();
        lapCounter = new BestTimeLapCounter();
        abbreviations = new ArrayList<>();
        printer = new RaceTabPrinter();
    }
    @Test
    void printTab_shouldPrintRightTabWithSeparator_whenListSizeMoreThan15() {
        RacerTime racerTime1 = new RacerTime("SVF",
                DateUtil.timeFormatterByPattern("2018-05-24_12:02:58.917"),
                        DateUtil.timeFormatterByPattern("2018-05-24_12:04:03.332"));
        RacerTime racerTime2 = new RacerTime("NHR",
                DateUtil.timeFormatterByPattern("2018-05-24_12:02:49.914"),
                        DateUtil.timeFormatterByPattern("2018-05-24_12:04:02.979"));
        RacerTime racerTime3 = new RacerTime("FAM",
                DateUtil.timeFormatterByPattern("2018-05-24_12:13:04.512"),
                        DateUtil.timeFormatterByPattern("2018-05-24_12:14:17.169"));
        RacerTime racerTime4 = new RacerTime("KRF",
                DateUtil.timeFormatterByPattern("2018-05-24_12:03:01.250"),
                        DateUtil.timeFormatterByPattern("2018-05-24_12:04:13.889"));
        RacerTime racerTime5 = new RacerTime("SVM",
                DateUtil.timeFormatterByPattern("2018-05-24_12:18:37.735"),
                        DateUtil.timeFormatterByPattern("2018-05-24_12:19:50.198"));
        RacerTime racerTime6 = new RacerTime("MES",
                DateUtil.timeFormatterByPattern("2018-05-24_12:04:45.513"),
                        DateUtil.timeFormatterByPattern("2018-05-24_12:05:58.778"));
        RacerTime racerTime7 = new RacerTime("LSW",
                DateUtil.timeFormatterByPattern("2018-05-24_12:06:13.511"),
                        DateUtil.timeFormatterByPattern("2018-05-24_12:07:26.834"));
        RacerTime racerTime8 = new RacerTime("BHS",
                DateUtil.timeFormatterByPattern("2018-05-24_12:14:51.985"),
                        DateUtil.timeFormatterByPattern("2018-05-24_12:16:05.164"));
        RacerTime racerTime9 = new RacerTime("EOF",
                DateUtil.timeFormatterByPattern("2018-05-24_12:17:58.810"),
                        DateUtil.timeFormatterByPattern("2018-05-24_12:19:11.838"));
        RacerTime racerTime10 = new RacerTime("RGH",
                DateUtil.timeFormatterByPattern("2018-05-24_12:05:14.511"),
                        DateUtil.timeFormatterByPattern("2018-05-24_12:06:27.441"));
        RacerTime racerTime11 = new RacerTime("SSW",
                DateUtil.timeFormatterByPattern("2018-05-24_12:16:11.648"),
                        DateUtil.timeFormatterByPattern("2018-05-24_12:17:24.354"));
        RacerTime racerTime12 = new RacerTime("KMH",
                DateUtil.timeFormatterByPattern("2018-05-24_12:02:51.003"),
                        DateUtil.timeFormatterByPattern("2018-05-24_12:04:04.396"));
        RacerTime racerTime13 = new RacerTime("PGS",
                DateUtil.timeFormatterByPattern("2018-05-24_12:07:23.645"),
                        DateUtil.timeFormatterByPattern("2018-05-24_12:08:36.586"));
        RacerTime racerTime14 = new RacerTime("CSR",
                DateUtil.timeFormatterByPattern("2018-05-24_12:03:15.145"),
                        DateUtil.timeFormatterByPattern("2018-05-24_12:04:28.095"));
        RacerTime racerTime15 = new RacerTime("SPF",
                DateUtil.timeFormatterByPattern("2018-05-24_12:12:01.035"),
                        DateUtil.timeFormatterByPattern("2018-05-24_12:13:13.883"));
        RacerTime racerTime16 = new RacerTime("DRR",
                DateUtil.timeFormatterByPattern("2018-05-24_12:14:12.054"),
                DateUtil.timeFormatterByPattern("2018-05-24_12:15:24.067"));
        racerTimes.add(racerTime1);
        racerTimes.add(racerTime2);
        racerTimes.add(racerTime3);
        racerTimes.add(racerTime4);
        racerTimes.add(racerTime5);
        racerTimes.add(racerTime6);
        racerTimes.add(racerTime7);
        racerTimes.add(racerTime8);
        racerTimes.add(racerTime9);
        racerTimes.add(racerTime10);
        racerTimes.add(racerTime11);
        racerTimes.add(racerTime12);
        racerTimes.add(racerTime13);
        racerTimes.add(racerTime14);
        racerTimes.add(racerTime15);
        racerTimes.add(racerTime16);
        List<BestRacer> bestRacers = lapCounter.countBestLap(racerTimes);
        Abbreviation abbreviation1 = new Abbreviation("DRR",
                "Daniel Riccardo","RED BULL RACING TAG HEUER");
        Abbreviation abbreviation2 = new Abbreviation("SVF",
                "Sebastian Vettel","FERRARI");
        Abbreviation abbreviation3 = new Abbreviation("LHM",
                "Lewis Hamilton","MERCEDES");
        Abbreviation abbreviation4 = new Abbreviation("KRF",
                "Kimi Raikkonen","FERRARI");
        Abbreviation abbreviation5 = new Abbreviation("VBM",
                "Valtteri Bottas","MERCEDES");
        Abbreviation abbreviation6 = new Abbreviation("EOF",
                "Esteban Ocon","FORCE INDIA MERCEDES");
        Abbreviation abbreviation7 = new Abbreviation("FAM",
                "Fernando Alonso","MCLAREN RENAULT");
        Abbreviation abbreviation8 = new Abbreviation("CSR",
                "Carlos Sainz","RENAULT");
        Abbreviation abbreviation9 = new Abbreviation("SPF",
                "Sergio Perez","FORCE INDIA MERCEDES");
        Abbreviation abbreviation10 = new Abbreviation("PGS",
                "Pierre Gasly","SCUDERIA TORO ROSSO HONDA");
        Abbreviation abbreviation11 = new Abbreviation("NHR",
                "Nico Hulkenberg","RENAULT");
        Abbreviation abbreviation12 = new Abbreviation("SVM",
                "Stoffel Vandoorne","MCLAREN RENAULT");
        Abbreviation abbreviation13 = new Abbreviation("SSW",
                "Sergey Sirotkin","WILLIAMS MERCEDES");
        Abbreviation abbreviation14 = new Abbreviation("CLS",
                "Daniel Riccardo","RED BULL RACING TAG HEUER");
        Abbreviation abbreviation15 = new Abbreviation("DRR",
                "Charles Leclerc","SAUBER FERRARI");
        Abbreviation abbreviation16 = new Abbreviation("RGH",
                "Romain Grosjean","HAAS FERRARI");
        abbreviations.add(abbreviation1);
        abbreviations.add(abbreviation2);
        abbreviations.add(abbreviation3);
        abbreviations.add(abbreviation4);
        abbreviations.add(abbreviation5);
        abbreviations.add(abbreviation6);
        abbreviations.add(abbreviation7);
        abbreviations.add(abbreviation8);
        abbreviations.add(abbreviation9);
        abbreviations.add(abbreviation10);
        abbreviations.add(abbreviation11);
        abbreviations.add(abbreviation12);
        abbreviations.add(abbreviation13);
        abbreviations.add(abbreviation14);
        abbreviations.add(abbreviation15);
        abbreviations.add(abbreviation16);
        String expected =
                "1.Sebastian Vettel         |FERRARI                            |1:4.415" + lineSeparator() +
                "2.Charles Leclerc          |SAUBER FERRARI                     |1:12.013" + lineSeparator() +
                "3.Stoffel Vandoorne        |MCLAREN RENAULT                    |1:12.463" + lineSeparator() +
                "4.Kimi Raikkonen           |FERRARI                            |1:12.639" + lineSeparator() +
                "5.Fernando Alonso          |MCLAREN RENAULT                    |1:12.657" + lineSeparator() +
                "6.Sergey Sirotkin          |WILLIAMS MERCEDES                  |1:12.706" + lineSeparator() +
                "7.Sergio Perez             |FORCE INDIA MERCEDES               |1:12.848" + lineSeparator() +
                "8.Romain Grosjean          |HAAS FERRARI                       |1:12.93" + lineSeparator() +
                "9.Pierre Gasly             |SCUDERIA TORO ROSSO HONDA          |1:12.941" + lineSeparator() +
                "10.Carlos Sainz            |RENAULT                            |1:12.95" + lineSeparator() +
                "11.Esteban Ocon            |FORCE INDIA MERCEDES               |1:13.028" + lineSeparator() +
                "12.Nico Hulkenberg         |RENAULT                            |1:13.065" + lineSeparator() +
                "13.Daniel Riccardo         |RED BULL RACING TAG HEUER          |1:13.179" + lineSeparator() +
                "14.Lewis Hamilton          |MERCEDES                           |1:13.265" + lineSeparator() +
                "15.Valtteri Bottas         |MERCEDES                           |1:13.323" + lineSeparator() +
                "-------------------------------------------------------------------------" + lineSeparator() +
                "16.Daniel Riccardo         |RED BULL RACING TAG HEUER          |1:13.393" + lineSeparator();
        assertEquals(expected, printer.printTab(bestRacers, abbreviations));
    }

    @Test
    void printTab_shouldPrintRightTabWithoutSeparator_whenListSizeIsLessThan15(){
        RacerTime racerTime1 = new RacerTime("SVF",
                DateUtil.timeFormatterByPattern("2018-05-24_12:02:58.917"),
                        DateUtil.timeFormatterByPattern("2018-05-24_12:04:03.332"));
        RacerTime racerTime2 = new RacerTime("NHR",
                DateUtil.timeFormatterByPattern("2018-05-24_12:02:49.914"),
                        DateUtil.timeFormatterByPattern("2018-05-24_12:04:02.979"));
        RacerTime racerTime3 = new RacerTime("FAM",
                DateUtil.timeFormatterByPattern("2018-05-24_12:13:04.512"),
                        DateUtil.timeFormatterByPattern("2018-05-24_12:14:17.169"));
        RacerTime racerTime4 = new RacerTime("KRF",
                DateUtil.timeFormatterByPattern("2018-05-24_12:03:01.250"),
                        DateUtil.timeFormatterByPattern("2018-05-24_12:04:13.889"));
        racerTimes.add(racerTime1);
        racerTimes.add(racerTime2);
        racerTimes.add(racerTime3);
        racerTimes.add(racerTime4);
        List<BestRacer> bestRacers = lapCounter.countBestLap(racerTimes);
        Abbreviation abbreviation1 = new Abbreviation("SVF",
                "Sebastian Vettel","FERRARI");
        Abbreviation abbreviation2 = new Abbreviation("NHR",
                "Nico Hulkenberg","RENAULT");
        Abbreviation abbreviation3 = new Abbreviation("FAM",
                "Fernando Alonso","MCLAREN RENAULT");
        Abbreviation abbreviation4 = new Abbreviation("KRF",
                "Kimi Raikkonen","FERRARI");
        abbreviations.add(abbreviation1);
        abbreviations.add(abbreviation2);
        abbreviations.add(abbreviation3);
        abbreviations.add(abbreviation4);
        String expected =
                "1.Sebastian Vettel         |FERRARI                            |1:4.415" + lineSeparator() +
                "2.Kimi Raikkonen           |FERRARI                            |1:12.639" + lineSeparator() +
                "3.Fernando Alonso          |MCLAREN RENAULT                    |1:12.657" + lineSeparator() +
                "4.Nico Hulkenberg          |RENAULT                            |1:13.065" + lineSeparator();
        assertEquals(expected, printer.printTab(bestRacers, abbreviations));
    }
}
