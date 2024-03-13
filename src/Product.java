import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class Product {
    // ATTRIBUTI
    private long id;
    private String name;
    private String category;
    private double price;

    // COSTRUTTORE
    public Product(long id, String name, String category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }
    //    Random random = new Random();
//
//    Supplier<String> categorie = () -> {
//        Random random = new Random();
//        List<String> lista = new ArrayList<>();
//        lista.add("Books");
//        lista.add("Baby");
//        lista.add("Boys");
//        return lista.get(random.nextInt(lista.size()));
//    };
//
//    Supplier<Product> productSupplier = () -> new Product(random.nextLong(1, 5000), "prodotto" + random.nextInt() , categorie.get(), random.nextDouble(1, 300) );
//    Supplier<List<Product>> randomList = () -> {
//        List<Product> productList = new ArrayList<>();
//        for (int i = 0; i < random.nextInt(1, 20); i++) {
//            productList.add(productSupplier.get());
//        }
//        return productList;
//    };



}
