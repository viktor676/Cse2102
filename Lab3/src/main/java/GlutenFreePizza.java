// Gluten-free pizza: still follows the Pizza contract.
// Demonstrates Liskov Substitution Principle: wherever Pizza is expected, a GlutenFreePizza works.
// It overrides cut() to use a safer cutter, but still fulfills the contract (no exceptions, same observable behavior).
public class GlutenFreePizza extends Pizza {
    public GlutenFreePizza() {
        super("Gluten-Free Pizza");
    }

    @Override
    public void prepare() {
        log.append("Preparing gluten-free dough, sauce, and toppings for " + name + ".\n");
    }

    @Override
    public void cut() {
        // Suppose gluten-free crust is fragile: cut into many small slices, but still a valid cut operation.
        log.append("Carefully cutting " + name + " into many small slices (gluten-free crust is fragile).\n");
    }
}
