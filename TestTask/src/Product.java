public class Product {

    private static int counter = 0;
    private int id;
    private String name;
    private String description;
    private int price;
    private String picture;

    public Product() {
    }

    public Product(String name, String description, int price, String picture) {
        this.id = ++counter;
        this.name = name;
        this.description = description;
        this.price = price;
        this.picture = picture;
    }

    public Product(String name, String description, int price) {
        this.id = ++counter;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public String getPicture() {
        return picture;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
