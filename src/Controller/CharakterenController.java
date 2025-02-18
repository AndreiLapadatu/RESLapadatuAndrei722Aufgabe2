package Controller;

import Model.Charakteren;
import Model.Produkten;
import Service.CharakterenService;

import java.util.List;

public class CharakterenController {


    CharakterenService charakterenService;

    public CharakterenController(CharakterenService charakterenService) {
        this.charakterenService = charakterenService;
    }

    public void addCharakter(int id, String name, String dorf) {
        Charakteren charakter = new Charakteren(id, name, dorf);
        charakterenService.addCharakter(charakter);
    }



    public void updateCharakter(int id, String name, String dorf) {
        Charakteren charakter = new Charakteren(id, name, dorf);
        charakterenService.updateCharakter(charakter);
    }

    public void deleteCharakter(int id) {
        charakterenService.removeCharakter(id);
    }

    public Charakteren getCharakter(int id) {
        return charakterenService.getCharakter(id);
    }

    public List<Charakteren> getAllCharakteren() {
        return charakterenService.getAllCharakteren();
    }

    public void addProduktToCharakter(int id, Produkten produkt) {
        Charakteren charakteren = charakterenService.getCharakter(id);
        if (charakteren != null) {
            charakteren.addProdukt(produkt);
            charakterenService.updateCharakter(charakteren);
        }
    }

    public List<Charakteren>filterCharakterNachDorf(String dorf) {
        return charakterenService.filterCharaktereNachDorf(dorf);
    }

    public List<Charakteren> filterCharakterbyDorf(Integer id, String dorf){
        return charakterenService.filterCharakterbyProdukt(id,dorf);
    }
}
