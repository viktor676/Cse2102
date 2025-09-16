public class Main {
    public static void main(String[] args) {
        PizzaFactory factory = new ConnecticutPizzaFactory();
        PizzaStore store = new PizzaStore(factory);

        // Run an interesting scenario: a small party that orders a mix.
        String[] orderList = {"cheese", "greek", "pepperoni", "gluten-free"};
        for (String type : orderList) {
            Pizza p = store.orderPizza(type);
            store.finalCheckAndLabel(p);
            System.out.println("----- " + p.getName() + " -----");
            System.out.print(p.getLog());
        }
    }
}
