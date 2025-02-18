package Repository;

import Model.Charakteren;

import java.util.ArrayList;
import java.util.List;

public class CharakterenRepository {

    List<Charakteren> charakteren = new ArrayList<>();

    public void add(Charakteren charakteren) {
        this.charakteren.add(charakteren);
    }

    public void update(Charakteren charakter) {
        for(int i = 0; i < charakteren.size(); i++) {
            if(charakteren.get(i).getId() == charakter.getId()) {
                charakteren.set(i, charakter);
                return;
            }
        }
    }

    public void remove(Integer id){
        charakteren.removeIf(charakter -> charakter.getId() == id);
    }

    public Charakteren getCharakter(int id) {
        return charakteren.stream().filter(charakter -> charakter.getId() == id).findFirst().orElse(null);
    }

    public List<Charakteren> getAllCharakteren() {
        return new ArrayList<>(charakteren);
    }
}
