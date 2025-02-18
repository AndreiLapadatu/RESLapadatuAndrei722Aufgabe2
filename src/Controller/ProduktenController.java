package Controller;

import Model.Produkten;
import Service.ProduktenService;

import java.util.List;

public class ProduktenController {

    private ProduktenService produktenService;

    public ProduktenController(ProduktenService produktenService) {
        this.produktenService = produktenService;
    }


    public void addProdukt(String name, double price, String region) {
        Produkten produkt = new Produkten(name, price, region);
        produktenService.addProdukt(produkt);
    }

    public void updateProdukt(String name, double price, String region) {
        Produkten produkt = new Produkten(name, price, region);
        produktenService.updateProdukt(produkt);
    }

    public void deleteProdukt(String name) {
        produktenService.removeProdukt(name);
    }

    public Produkten getProdukt(String name) {
        return produktenService.getProdukt(name);
    }

    public List<Produkten> getAllProdukten() {
        return produktenService.getAllProdukten();
    }
}
