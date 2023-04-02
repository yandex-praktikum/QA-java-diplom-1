import org.junit.Assert;
import org.junit.Test;
import praktikum.Database;

public class DatabaseTest {
    Database db = new Database();
    @Test
    public void availableBunsTest() {
        Assert.assertEquals(3, db.availableBuns().size());
    }
    @Test
    public void availableIngredientsTest() {
        Assert.assertEquals(6, db.availableIngredients().size());
    }
}
