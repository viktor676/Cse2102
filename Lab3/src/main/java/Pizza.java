// Abstract base class for all pizzas.
// All concrete pizzas must implement prepare(), bake(), cut(), box().
// This base class provides common fields and a small default implementation for logging.
public abstract class Pizza {
    protected String name;
    protected StringBuilder log = new StringBuilder();

    public Pizza(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Implementations should append meaningful messages to log and/or return something if desired.
    public abstract void prepare();
    public void bake() {
        log.append("Baking " + name + " for 15 minutes.\n");
    }
    // default cut; subclasses may override as long as they preserve contract (no exceptions, compatible behavior).
    public void cut() {
        log.append("Cutting " + name + " into diagonal slices.\n");
    }
    public void box() {
        log.append("Boxing " + name + ".\n");
    }

    // Helpers for tests / display
    public String getLog() {
        return log.toString();
    }

    @Override
    public String toString() {
        return "Pizza{name='" + name + "'}";
    }
}
