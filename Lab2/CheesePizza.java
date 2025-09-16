public class CheesePizza extends Pizza {
    public CheesePizza() {
        super("Cheese Pizza");
    }

    @Override
    public void prepare() {
        log.append("Preparing dough, tomato sauce, and lots of cheese for " + name + ".\n");
    }
}
