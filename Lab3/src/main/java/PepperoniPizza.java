public class PepperoniPizza extends Pizza {
    public PepperoniPizza() {
        super("Pepperoni Pizza");
    }

    @Override
    public void prepare() {
        log.append("Preparing dough, tomato sauce, mozzarella, and pepperoni for " + name + ".\n");
    }
}
