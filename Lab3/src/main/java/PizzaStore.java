// The PizzaStore uses a PizzaFactory to obtain pizzas and runs the standard process.
// This centralizes ordering logic so callers just "order" by type.
public class PizzaStore {
    private final PizzaFactory factory;

    public PizzaStore(PizzaFactory factory) {
        this.factory = factory;
    }

    // Orders and fully processes a pizza, returning the prepared Pizza instance for inspection/testing.
    public Pizza orderPizza(String type) {
        Pizza pizza = factory.createPizza(type);
        if (pizza == null) {
            throw new IllegalArgumentException("Unknown pizza type: " + type);
        }
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    // Example of a method that accepts any Pizza (LSP demonstration: this code works with any subclass).
    // It performs a final check that is valid for all pizzas.
    public String finalCheckAndLabel(Pizza pizza) {
        // LSP — we treat pizza as Pizza, not as a concrete subtype. We rely only on the Pizza contract.
        String label = "Ready: " + pizza.getName();
        pizza.log.append("Labeling: " + label + "\n");
        return label;
    }
}
