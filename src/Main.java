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
            for (int i = 0; i < random.nextInt(1, 20); i++) {
                productList.add(productSupplier.get());
            }
            return productList;
        };

        List<Customer> listaClienti = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
        Customer cliente1 =  new Customer(random.nextLong(1, 5000), "cliente" + (i + 1 ), random.nextInt(1, 5));
        listaClienti.add(cliente1);
            System.out.println(cliente1);
        }

        LocalDate data = LocalDate.of(2021,2,20);
        LocalDate dataSpedizione = LocalDate.of(2021,2,24);


        Supplier<Order> ordine1 = () -> {
            Random randomI = new Random();
            Customer lunghezzaCasuale = listaClienti.get(randomI.nextInt(listaClienti.size()));
            Order ordine = new Order(random.nextInt(), "in consegna", data, dataSpedizione, randomList.get(), lunghezzaCasuale );
            return ordine;
        };

        System.out.println(ordine1);
        List<Product> products = randomList.get();

        System.out.println("----------------- ESERCIZIO 1 ----------------------");
       List<Product> prodottiBooks = products.stream().filter(category -> category.getCategory().equals("Books")  && category.getPrice() > 100).toList();
        System.out.println(prodottiBooks);


        System.out.println("----------------- ESERCIZIO 3 ----------------------");
        List<Product> prodottiBoys1 = products.stream().filter(category -> category.getCategory().equals("Boys")  ).toList();
        System.out.println(prodottiBoys1);
        List<Double> prodottiScontati = products.stream().filter(category -> category.getCategory().equals("Boys")).map(price -> price.getPrice() * 10 / 100).toList();
        System.out.println(prodottiScontati);
      }


}