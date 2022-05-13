package ua.foxminded.ilyapanteleychuk.task6.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.foxminded.ilyapanteleychuk.task6.models.Abbreviation;
import ua.foxminded.ilyapanteleychuk.task6.models.BestRacer;
import ua.foxminded.ilyapanteleychuk.task6.models.Model;
import java.util.ArrayList;
import java.util.List;
import static java.lang.System.lineSeparator;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RaceTabPrinterTest {

    private List<Model> models;
    private BestTimeLapCounter lapCounter;
    private List<Abbreviation> abbreviations;
    private RaceTabPrinter printer;

    @BeforeEach
    void init(){
        models = new ArrayList<>();
        lapCounter = new BestTimeLapCounter();
        abbreviations = new ArrayList<>();
        printer = new RaceTabPrinter();
    }
    @Test
    void printTab_shouldPrintRightTabWithSeparator_whenListSizeMoreThan15() {
        Model model1 = new Model("SVF",
                "2018-05-24_12:02:58.917", "2018-05-24_12:04:03.332");
        Model model2 = new Model("NHR",
                "2018-05-24_12:02:49.914", "2018-05-24_12:04:02.979");
        Model model3 = new Model("FAM",
                "2018-05-24_12:13:04.512", "2018-05-24_12:14:17.169");
        Model model4 = new Model("KRF",
                "2018-05-24_12:03:01.250", "2018-05-24_12:04:13.889");
        Model model5 = new Model("SVM",
                "2018-05-24_12:18:37.735", "2018-05-24_12:19:50.198");
        Model model6 = new Model("MES",
                "2018-05-24_12:04:45.513", "2018-05-24_12:05:58.778");
        Model model7 = new Model("LSW",
                "2018-05-24_12:06:13.511", "2018-05-24_12:07:26.834");
        Model model8 = new Model("BHS",
                "2018-05-24_12:14:51.985", "2018-05-24_12:16:05.164");
        Model model9 = new Model("EOF",
                "2018-05-24_12:17:58.810", "2018-05-24_12:19:11.838");
        Model model10 = new Model("RGH",
                "2018-05-24_12:05:14.511", "2018-05-24_12:06:27.441");
        Model model11 = new Model("SSW",
                "2018-05-24_12:16:11.648", "2018-05-24_12:17:24.354");
        Model model12 = new Model("KMH",
                "2018-05-24_12:02:51.003", "2018-05-24_12:04:04.396");
        Model model13 = new Model("PGS",
                "2018-05-24_12:07:23.645", "2018-05-24_12:08:36.586");
        Model model14 = new Model("CSR",
                "2018-05-24_12:03:15.145", "2018-05-24_12:04:28.095");
        Model model15 = new Model("SPF",
                "2018-05-24_12:12:01.035", "2018-05-24_12:13:13.883");
        Model model16 = new Model("DRR",
                "2018-05-24_12:14:12.054", "2018-05-24_12:15:24.067");
        models.add(model1);
        models.add(model2);
        models.add(model3);
        models.add(model4);
        models.add(model5);
        models.add(model6);
        models.add(model7);
        models.add(model8);
        models.add(model9);
        models.add(model10);
        models.add(model11);
        models.add(model12);
        models.add(model13);
        models.add(model14);
        models.add(model15);
        models.add(model16);
        List<BestRacer> bestRacers = lapCounter.countBestLap(models);
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
        Model model1 = new Model("SVF",
                "2018-05-24_12:02:58.917", "2018-05-24_12:04:03.332");
        Model model2 = new Model("NHR",
                "2018-05-24_12:02:49.914", "2018-05-24_12:04:02.979");
        Model model3 = new Model("FAM",
                "2018-05-24_12:13:04.512", "2018-05-24_12:14:17.169");
        Model model4 = new Model("KRF",
                "2018-05-24_12:03:01.250", "2018-05-24_12:04:13.889");
        models.add(model1);
        models.add(model2);
        models.add(model3);
        models.add(model4);
        List<BestRacer> bestRacers = lapCounter.countBestLap(models);
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