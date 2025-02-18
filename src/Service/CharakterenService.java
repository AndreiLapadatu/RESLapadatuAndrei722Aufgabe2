package Service;

import Model.Charakteren;
import Model.Produkten;
import Repository.CharakterenRepository;

import java.util.List;
import java.util.stream.Collectors;

public class CharakterenService {

    private CharakterenRepository charakterenRepository;


    public CharakterenService(CharakterenRepository charakterenRepository) {
        this.charakterenRepository = charakterenRepository;
    }

    public void addCharakter(Charakteren charakter) {
        charakterenRepository.add(charakter);
    }

    public void updateCharakter(Charakteren charakter) {
        charakterenRepository.update(charakter);
    }

    public void removeCharakter(Integer id) {
        charakterenRepository.remove(id);
    }

    public Charakteren getCharakter(Integer id) {
        return charakterenRepository.getCharakter(id);
    }

    public List<Charakteren> getAllCharakteren() {
        return charakterenRepository.getAllCharakteren();
    }

    public List<Charakteren>filterCharaktereNachDorf(String dorf) {
        return getAllCharakteren().stream().filter(charakter -> charakter.getDorf().equalsIgnoreCase(dorf)).collect(Collectors.toList());
    }

    public List<Charakteren> filterCharakterbyProdukt(Integer id,String dorf) {
        return getAllCharakteren().stream().filter(charakter -> charakter.getProduktenList().stream().anyMatch(k ->k.getRegion().equalsIgnoreCase(dorf)))
                .collect(Collectors.toList());
    }

//    public List<Produkten>sortProduktPreis(Integer id, boolean ascending){
//        Charakteren charakteren = charakterenRepository.getCharakter(id);
//        if(charakteren == null)
//            return List.of();
//
//        return charakteren.getProduktenList().stream().sorted((p1,p2)->ascending ?
//                p1.getPrice().compareTo(p2.getPrice()) :
//                p2.getPrice().compareTo(p1.getPrice())).collect(Collectors.toList());
//    }

}
