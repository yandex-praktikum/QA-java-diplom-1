import org.junit.Test;
import praktikum.IngredientType;

public class IngredientTypeTest {

    @Test
    public void enumIncludes(){
        String firstType = "SAUCE";
        String secondType = "FILLING";
        IngredientType.valueOf(firstType);
        IngredientType.valueOf(secondType);

    }
}
