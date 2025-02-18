import Controller.CharakterenController;
import Controller.ProduktenController;
import Model.Charakteren;
import Model.Produkten;
import Repository.CharakterenRepository;
import Repository.ProduktenRepository;
import Service.CharakterenService;
import Service.ProduktenService;
import View.ConsoleView;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CharakterenRepository charakterenRepository = new CharakterenRepository();
        ProduktenRepository produktenRepository = new ProduktenRepository();

        CharakterenService charakterenService = new CharakterenService(charakterenRepository);
        ProduktenService produktenService = new ProduktenService(produktenRepository);


        CharakterenController charakterenController = new CharakterenController(charakterenService);
        ProduktenController produktenController = new ProduktenController(produktenService);

        ConsoleView consoleView = new ConsoleView(charakterenController,produktenController);


        // Initialisierung der Produkte
        List<Produkten> produkte = new ArrayList<>();
        produkte.add(new Produkten("Kunai", 50.0, "Konoha"));
        produkte.add(new Produkten("Shuriken", 30.0, "Konoha"));
        produkte.add(new Produkten("Schwert", 200.0, "Kirigakure"));
        produkte.add(new Produkten("Heiltrank", 100.0, "Sunagakure"));
        produkte.add(new Produkten("Sprengsiegel", 75.0, "Iwagakure"));
        produkte.add(new Produkten("Riesenfächer", 300.0, "Sunagakure"));
        produkte.add(new Produkten("Giftklinge", 150.0, "Kirigakure"));
        produkte.add(new Produkten("Explosionskugel", 250.0, "Iwagakure"));
        produkte.add(new Produkten("Schattendolch", 180.0, "Konoha"));
        produkte.add(new Produkten("Wasserperle", 90.0, "Kirigakure"));
// Initialisierung der Charaktere
        List<Charakteren> charaktere = new ArrayList<>();
        Charakteren c1 = new Charakteren(1, "Naruto Uzumaki", "Konoha");
        c1.addProdukt(produkte.get(0)); // Kunai
        c1.addProdukt(produkte.get(3)); // Heiltrank
        c1.addProdukt(produkte.get(8)); // Schattendolch
        c1.addProdukt(produkte.get(5)); // Riesenfächer
        Charakteren c2 = new Charakteren(2, "Gaara", "Sunagakure");
        c2.addProdukt(produkte.get(2)); // Schwert
        c2.addProdukt(produkte.get(4)); // Sprengsiegel
        c2.addProdukt(produkte.get(6)); // Giftklinge
        c2.addProdukt(produkte.get(1)); // Shuriken
        Charakteren c3 = new Charakteren(3, "Kisame Hoshigaki", "Kirigakure");
        c3.addProdukt(produkte.get(1)); // Shuriken
        c3.addProdukt(produkte.get(2)); // Schwert
        c3.addProdukt(produkte.get(3)); // Heiltrank
        c3.addProdukt(produkte.get(7)); // Explosionskugel
        c3.addProdukt(produkte.get(9)); // Wasserperle
        Charakteren c4 = new Charakteren(4, "Deidara", "Iwagakure");
        c4.addProdukt(produkte.get(0)); // Kunai
        c4.addProdukt(produkte.get(4)); // Sprengsiegel
        c4.addProdukt(produkte.get(7)); // Explosionskugel
        c4.addProdukt(produkte.get(9)); // Wasserperle
        Charakteren c5 = new Charakteren(5, "Itachi Uchiha", "Konoha");
        c5.addProdukt(produkte.get(8)); // Schattendolch

    }
}