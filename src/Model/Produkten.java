package Model;

public class Produkten {

    private int name;
    private int price;
    private String region;

    public Produkten(int name, int price, String region) {
        this.name = name;
        this.price = price;
        this.region = region;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "Produkten{" +
                "name=" + name +
                ", price=" + price +
                ", region='" + region + '\'' +
                '}';
    }
}
