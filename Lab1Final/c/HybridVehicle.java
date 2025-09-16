package c;

public class HybridVehicle implements GasolineInterface, ElectricInterface {
    private double costPerGallon;
    private double costPerKwh;

    public HybridVehicle() {
        // default constructor
    }

    public HybridVehicle(double costPerGallon, double costPerKwh) {
        this.costPerGallon = costPerGallon;
        this.costPerKwh = costPerKwh;
    }

    // GasolineInterface implementations
    @Override
    public void setCostPerGallon(double costPerGallon) {
        if (costPerGallon < 0) throw new IllegalArgumentException("Cost per gallon cannot be negative.");
        this.costPerGallon = costPerGallon;
    }

    @Override
    public double getCostPerGallon() {
        return costPerGallon;
    }

    // ElectricInterface implementations
    @Override
    public void setCostPerKwh(double costPerKwh) {
        if (costPerKwh < 0) throw new IllegalArgumentException("Cost per kWh cannot be negative.");
        this.costPerKwh = costPerKwh;
    }

    @Override
    public double getCostPerKwh() {
        return costPerKwh;
    }

    /**
     * Compute the average MPG for a "half-gas/half-electric" mode.
     * The problem statement defines it simply as (MPG + MPGe) / 2.
     */
    public double computeAverageMPG(double mpg, double mpge) {
        return (mpg + mpge) / 2.0;
    }

    /**
     * Helper: compute kWh per mile from miles and kWh used.
     */
    public double kwhPerMile(double miles, double kwhUsed) {
        if (miles <= 0) {
            throw new IllegalArgumentException("Miles must be > 0 to compute kWh per mile.");
        }
        return kwhUsed / miles;
    }
}
