import java.util.ArrayList;
import java.util.List;

public class Products {

    private static List<Product> list;
    private static Products products;

    private Products(){
        list = new ArrayList<>();
        list.add(new Product("Laptop", "Laptop for business", 50));
        list.add(new Product("Notebook", "Notebook for gamers", 60));
        list.add(new Product("Personal Computer", "Personal Computer for companies", 40));
        list.add(new Product("Apple IPhone", "Mobile phone", 600));
    }

    public static Products getInstance() {
        if(products == null) {
            products = new Products();
        }

        return products;
    }

    public static List<Product> getList() {
        return list;
    }

    public static void addProduct(Product product){
        list.add(product);
    }

    public static void remove(int id){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getId() == id){
                list.remove(i);
                return;
            }
        }
    }

    public static Product find(int id){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getId() == id){
                return list.get(i);
            }
        }
        return null;
    }
}
