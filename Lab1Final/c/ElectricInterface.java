package c;

public interface ElectricInterface {
    /**
     * Set the cost of electricity per kWh (USD).
     */
    void setCostPerKwh(double costPerKwh);

    /**
     * Get the cost of electricity per kWh (USD).
     */
    double getCostPerKwh();

    /**
     * Compute MPGe (miles per gallon equivalent) using:
     * MPGe = (miles / kWhUsed) * 33.7
     */
    default double computeMPGe(double miles, double kwhUsed) {
        if (kwhUsed <= 0) {
            throw new IllegalArgumentException("kWh used must be > 0 to compute MPGe.");
        }
        final double KWH_PER_GALLON_EQUIV = 33.7;
        return (miles / kwhUsed) * KWH_PER_GALLON_EQUIV;
    }

    /**
     * Convenience: cost per mile in electric mode given kWh per mile.
     */
    default double costPerMileElectric(double kwhPerMile) {
        if (kwhPerMile <= 0) {
            throw new IllegalArgumentException("kWh per mile must be > 0 to compute cost per mile.");
        }
        return getCostPerKwh() * kwhPerMile;
    }
}
