import org.junit.Assert;
import org.junit.Test;
import praktikum.Database;

public class DataBaseTest {
    private Database database = new Database();

    @Test
    public void getAvailableBuns(){
        Assert.assertFalse("DataBase is empty", database.availableBuns().isEmpty());
    }
    @Test
    public void getAvailableIngredients(){
        Assert.assertFalse("DataBase is empty", database.availableIngredients().isEmpty());
    }
}
