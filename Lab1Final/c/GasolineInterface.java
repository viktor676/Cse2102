package c;

public interface GasolineInterface {
    /**
     * Set the cost of gasoline per gallon (USD).
     */
    void setCostPerGallon(double costPerGallon);

    /**
     * Get the cost of gasoline per gallon (USD).
     */
    double getCostPerGallon();

    /**
     * Compute miles per gallon given miles traveled and gallons used.
     */
    default double computeMPG(double miles, double gallons) {
        if (gallons <= 0) {
            throw new IllegalArgumentException("Gallons must be > 0 to compute MPG.");
        }
        return miles / gallons;
    }

    /**
     * Convenience: cost per mile for gasoline mode given mpg and cost per gallon.
     */
    default double costPerMileGasoline(double mpg) {
        if (mpg <= 0) {
            throw new IllegalArgumentException("MPG must be > 0 to compute cost per mile.");
        }
        return getCostPerGallon() / mpg;
    }
}
