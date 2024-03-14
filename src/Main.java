import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();
        // Genero una lista con 3 categorie
        Supplier<String> categorie = () -> {
            Random randomCategory = new Random();
            List<String> lista = new ArrayList<>();
            lista.add("Books");
            lista.add("Baby");
            lista.add("Boys");
            return lista.get(randomCategory.nextInt(lista.size()));
        };

        // nuovo prodotto
        Supplier<Product> productSupplier = () -> new Product(random.nextLong(1, 5000), "prodotto" + random.nextInt() , categorie.get(), random.nextDouble(1, 300) );

        // Genero lista di prodotti
        Supplier<List<Product>> randomList = () -> {
            List<Product> productList = new ArrayList<>();
            for (int i = 0; i < random.nextInt(1, 90); i++) {
                productList.add(productSupplier.get());
            }
            return productList;
        };

        // Genero lista clienti
        List<Customer> listaClienti = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
        Customer cliente1 =  new Customer(random.nextLong(1, 5000), "cliente" + (i + 1 ), random.nextInt(1, 5));
        listaClienti.add(cliente1);
//            System.out.println(cliente1);
        }
        // DATE
        LocalDate data = LocalDate.of(2021,2,20);
        LocalDate dataSpedizione = LocalDate.of(2021,2,24);
        System.out.println(data);
        // GENERO ORDINE

        List<Order> listaOrdini = new ArrayList<>();
            Supplier<Order> ordine1 = () -> {
                Random randomI = new Random();
                Customer lunghezzaCasuale = listaClienti.get(randomI.nextInt(listaClienti.size()));
                Order ordine = new Order(random.nextInt(), "in consegna", data, dataSpedizione, randomList.get(), lunghezzaCasuale );
                return ordine;
            };
        for (int i = 0; i < 5; i++) {
            listaOrdini.add(ordine1.get());
        }
        System.out.println(listaOrdini);



        // LISTA PRODOTTI
        List<Product> products = randomList.get();
        System.out.println(products);

        System.out.println("----------------- ESERCIZIO 1 ----------------------");
       List<Product> prodottiBooks = products.stream().filter(category -> category.getCategory().equals("Books")  && category.getPrice() > 100).toList();
        System.out.println(prodottiBooks);

        System.out.println("----------------- ESERCIZIO 2 ----------------------");
        List<Order> prodottiBaby = listaOrdini.stream().filter(product -> product.getProducts().stream().anyMatch(category -> category.getCategory().equals("Baby"))).toList();
        System.out.println(prodottiBaby);
        System.out.println("----------------- ESERCIZIO 3 ----------------------");
        List<Product> prodottiBoys1 = products.stream().filter(category -> category.getCategory().equals("Boys")  ).toList();
        System.out.println(prodottiBoys1);
        List<Double> prodottiScontati = products.stream().filter(category -> category.getCategory().equals("Boys")).map(price -> price.getPrice() - price.getPrice() * 10 / 100 ).toList();
        System.out.println(prodottiScontati);
        System.out.println("----------------- ESERCIZIO 4 ----------------------");
        List<Product> prodottiClienti = listaOrdini.stream().filter(product -> product.getCustomer().getTier() == 2 && product.getOrderDate().isAfter(LocalDate.parse("2021-02-01")) && product.getOrderDate().isBefore(LocalDate.parse("2021-03-01"))).map(order -> order.getProducts()).flatMap(p -> p.stream()).toList();
        System.out.println(prodottiClienti);
    }


}