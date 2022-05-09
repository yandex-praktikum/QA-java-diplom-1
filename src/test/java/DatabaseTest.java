import org.junit.Assert;
import org.junit.Test;
import praktikum.Database;

public class DatabaseTest {

    private Database db = new Database();

    @Test
    public void getAvailableBuns(){
        Assert.assertFalse("БД пустая", db.availableBuns().isEmpty());
    }

    @Test
    public void getAvailableIngredients(){
        Assert.assertFalse("БД пустая", db.availableIngredients().isEmpty());
    }
}
