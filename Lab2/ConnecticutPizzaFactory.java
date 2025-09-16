// A concrete factory for our Connecticut pizza store.
public class ConnecticutPizzaFactory implements PizzaFactory {

    @Override
    public Pizza createPizza(String type) {
        if (type == null) return null;
        switch (type.toLowerCase()) {
            case "cheese":
                return new CheesePizza();
            case "greek":
                return new GreekPizza();
            case "pepperoni":
            case "peperoni": // handle common misspelling
                return new PepperoniPizza();
            case "glutenfree":
            case "gluten-free":
                return new GlutenFreePizza();
            default:
                return null;
        }
    }
}
