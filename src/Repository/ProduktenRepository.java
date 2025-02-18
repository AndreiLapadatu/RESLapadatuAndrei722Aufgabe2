package Repository;


import Model.Produkten;

import java.util.ArrayList;
import java.util.List;

public class ProduktenRepository {
    private List<Produkten> produkten = new ArrayList<>();


    public void add(Produkten produkt) {
            produkten.add(produkt);
    }


    public void update(Produkten produkt) {
        for(int i = 0; i<produkten.size(); i++){
            if(produkten.get(i).getName().equals(produkt.getName())){
                produkten.set(i, produkt);
                return;
            }
        }
    }

    public void remove(String name){
        produkten.removeIf(produkt -> produkt.getName().equals(name));
    }

    public Produkten getProdukt(String name){
        return produkten.stream().filter(produkt -> produkt.getName().equals(name)).findFirst().orElse(null);
    }

    public List<Produkten>getAllProdukten(){return new ArrayList<>(produkten);}

}
