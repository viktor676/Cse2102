public class GreekPizza extends Pizza {
    public GreekPizza() {
        super("Greek Pizza");
    }

    @Override
    public void prepare() {
        log.append("Preparing dough, feta, olives, onions, and tomato for " + name + ".\n");
    }
}
