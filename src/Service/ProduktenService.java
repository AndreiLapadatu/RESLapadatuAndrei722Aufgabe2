package Service;

import Model.Produkten;
import Repository.ProduktenRepository;

import java.util.List;

public class ProduktenService {

    private ProduktenRepository produktenRepository;


    public ProduktenService(ProduktenRepository produktenRepository) {
        this.produktenRepository = produktenRepository;
    }


    public void addProdukt(Produkten produkt) {
        produktenRepository.add(produkt);
    }

    public void updateProdukt(Produkten produkt) {
        produktenRepository.update(produkt);
    }

    public void removeProdukt(String name) {
        produktenRepository.remove(name);
    }

    public Produkten getProdukt(String name) {
        return produktenRepository.getProdukt(name);
    }

    public List<Produkten> getAllProdukten() {
        return produktenRepository.getAllProdukten();
    }
}
