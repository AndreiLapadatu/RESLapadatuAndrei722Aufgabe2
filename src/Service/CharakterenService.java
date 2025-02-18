package Service;

import Model.Charakteren;
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

}
