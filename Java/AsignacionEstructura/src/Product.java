public class Product {
    private int id;
    private String name;
    private String provider;
    private String brand;

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

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Product(int id, String name, String provider, String brand) {

        this.id = id;
        this.name = name;
        this.provider = provider;
        this.brand = brand;
    }

    public Product() {

    }
}
