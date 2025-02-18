package Model;

import java.util.ArrayList;
import java.util.List;

public class Charakteren {

    private int id;
    private String name;
    private String dorf;
    private List<Produkten> produktenList;

    public Charakteren(int id, String name, String dorf) {
        this.id = id;
        this.name = name;
        this.dorf = dorf;
        this.produktenList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDorf() {
        return dorf;
    }

    public void setDorf(String dorf) {
        this.dorf = dorf;
    }

    public List<Produkten> getProduktenList() {
        return produktenList;
    }

    public void setProduktenList(List<Produkten> produktenList) {
        this.produktenList = produktenList;
    }

    public void addProdukt(Produkten produkt) {
        this.produktenList.add(produkt);
    }

    @Override
    public String toString() {
        return "Charakteren{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dorf='" + dorf + '\'' +
                ", produktenList=" + produktenList +
                '}';
    }
}
