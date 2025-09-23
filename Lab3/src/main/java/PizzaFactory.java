// Factory interface. The factory produces Pizza instances based on a type string or enum.
public interface PizzaFactory {
    Pizza createPizza(String type);
}
