package u;

import c.HybridVehicle;
import c.GasolineInterface;
import c.ElectricInterface;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HybridVehicleTest {

    private static final double DELTA = 1e-6;

    private HybridVehicle hvDefault;
    private HybridVehicle hvBoth;

    @Before
    public void setUp() {
        hvDefault = new HybridVehicle();
        hvBoth = new HybridVehicle(3.50, 0.24);
    }

    @Test
    public void testCostSetGet() {
        hvDefault.setCostPerGallon(3.50);
        hvDefault.setCostPerKwh(0.24);

        assertEquals(3.50, hvDefault.getCostPerGallon(), DELTA);
        assertEquals(0.24, hvDefault.getCostPerKwh(), DELTA);
    }

    @Test
    public void testComputeMPG() {
        double mpg = ((GasolineInterface) hvDefault).computeMPG(300.0, 10.0);
        assertEquals(30.0, mpg, DELTA);
    }

    @Test
    public void testComputeMPGe_example() {
        double mpge = ((ElectricInterface) hvDefault).computeMPGe(300.0, 70.0);
        double expected = (300.0 / 70.0) * 33.7;
        assertEquals(expected, mpge, DELTA);
    }

    @Test
    public void testComputeAverageMPG() {
        double mpg = ((GasolineInterface) hvDefault).computeMPG(300.0, 10.0);
        double mpge = ((ElectricInterface) hvDefault).computeMPGe(300.0, 70.0);

        double avg = hvDefault.computeAverageMPG(mpg, mpge);
        assertEquals((mpg + mpge) / 2.0, avg, DELTA);
    }

    @Test
    public void testCostPerMileCalculations() {
        double mpg = ((GasolineInterface) hvBoth).computeMPG(300.0, 10.0);
        double gasCostPerMile = ((GasolineInterface) hvBoth).costPerMileGasoline(mpg);
        assertEquals(3.50 / 30.0, gasCostPerMile, DELTA);

        double kwhPerMile = hvBoth.kwhPerMile(300.0, 70.0);
        double electricCostPerMile = hvBoth.getCostPerKwh() * kwhPerMile;
        assertEquals(0.24 * (70.0 / 300.0), electricCostPerMile, DELTA);
    }
}
