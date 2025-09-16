import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PizzaFactoryTest {

    private PizzaFactory factory;
    private PizzaStore store;

    @Before
    public void setUp() {
        factory = new ConnecticutPizzaFactory();
        store = new PizzaStore(factory);
    }

    @Test
    public void testCreateAllPizzaTypes() {
        assertNotNull(factory.createPizza("cheese"));
        assertNotNull(factory.createPizza("greek"));
        assertNotNull(factory.createPizza("pepperoni"));
        assertNotNull(factory.createPizza("gluten-free"));
    }

    @Test
    public void testOrderCheesePizzaFlow() {
        Pizza p = store.orderPizza("cheese");
        assertEquals("Cheese Pizza", p.getName());
        String log = p.getLog();
        assertTrue(log.contains("Preparing"));
        assertTrue(log.contains("Baking"));
        assertTrue(log.contains("Cutting"));
        assertTrue(log.contains("Boxing"));
    }

    @Test
    public void testOrderGlutenFreePizzaCutBehavior() {
        Pizza p = store.orderPizza("gluten-free");
        assertEquals("Gluten-Free Pizza", p.getName());
        String log = p.getLog();
        // gluten-free pizza has special cut line
        assertTrue(log.contains("Carefully cutting"));
        assertTrue(log.contains("Boxing"));
    }

    @Test
    public void testLiskovSubstitutionPrinciple() {
        // LSP test: code that accepts base class Pizza must work with any subclass.
        Pizza generic = new CheesePizza();
        Pizza gf = new GlutenFreePizza();

        // both should work with store.finalCheckAndLabel which only uses Pizza contract
        String label1 = store.finalCheckAndLabel(generic);
        String label2 = store.finalCheckAndLabel(gf);
        assertEquals("Ready: Cheese Pizza", label1);
        assertEquals("Ready: Gluten-Free Pizza", label2);

        // No exceptions, logs updated
        assertTrue(generic.getLog().contains("Labeling"));
        assertTrue(gf.getLog().contains("Labeling"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUnknownPizzaThrows() {
        store.orderPizza("pineapple"); // factory doesn't know this -> should throw
    }
}
