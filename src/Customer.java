public class Customer {
    // ATTRIBUTI
    private long id;
    private String name;
    private int tier;

    // COSTRUTTORE
    public Customer(long id, String name, int tier) {
        this.id = id;
        this.name = name;
        this.tier = tier;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tier=" + tier +
                '}';
    }
}
