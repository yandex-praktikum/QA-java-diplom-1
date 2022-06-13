import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;

public class DatabaseTest {
    Bun bun;
    Ingredient ingredient;

    @Test
    public void getAvailableBuns() {

        Database database = new Database();
        database.availableBuns().add(bun);
        Assert.assertTrue(database.availableBuns().contains(bun));
    }
    @Test
    public void getAvailableIngredients(){
        Database database = new Database();
        database.availableIngredients().add(ingredient);
        Assert.assertTrue(database.availableIngredients().contains(ingredient));
    }
}
