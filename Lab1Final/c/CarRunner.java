package c;

public class CarRunner {
    public static void main(String[] args) {
        // Create hybrid vehicle and set costs
        HybridVehicle hv = new HybridVehicle();
        hv.setCostPerGallon(3.50); // $3.50 per gallon (given)
        hv.setCostPerKwh(0.24);    // $0.24 per kWh (given)

        // Example inputs:
        double gasMiles = 300.0;
        double gallonsUsed = 10.0; // => MPG = 30.0

        double electricMiles = 300.0;
        double kwhUsed = 70.0;     // given example: 300 miles using 70 kWh

        // Compute MPG in fully gas mode (uses default method from GasolineInterface)
        double mpg = hv.computeMPG(gasMiles, gallonsUsed);

        // Compute MPGe in fully electric mode (uses default method from ElectricInterface)
        double mpge = hv.computeMPGe(electricMiles, kwhUsed);

        // Compute average MPG for half gas / half electric
        double aveMpg = hv.computeAverageMPG(mpg, mpge);

        // Print results
        System.out.printf("Gasoline mode: %.2f miles / %.2f gallons = MPG: %.2f%n",
                gasMiles, gallonsUsed, mpg);
        System.out.printf("Electric mode: %.2f miles / %.2f kWh => MPGe: %.2f%n",
                electricMiles, kwhUsed, mpge);
        System.out.printf("Half-gas/half-electric average MPG: (%.2f + %.2f)/2 = %.2f%n",
                mpg, mpge, aveMpg);

        // Cost per mile examples (fixed method names)
        double gasCostPerMile = hv.costPerMileGasoline(mpg);
        double kwhPerMile = hv.kwhPerMile(electricMiles, kwhUsed);
        double electricCostPerMile = hv.getCostPerKwh() * kwhPerMile;

        System.out.printf("Gas cost per mile: $%.4f (at $%.2f/gal and %.2f MPG)%n",
                gasCostPerMile, hv.getCostPerGallon(), mpg);
        System.out.printf("Electric cost per mile: $%.4f (at $%.2f/kWh and %.6f kWh/mile)%n",
                electricCostPerMile, hv.getCostPerKwh(), kwhPerMile);
    }
}
