import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.*;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final String typeName;

    public IngredientTypeTest (String typeName) {
        this.typeName = typeName;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}")
    public static Object[][] getIngredientData(){
        return new Object[][]{
                {"SAUCE"},
                {"FILLING"},
        };
    }

    @Test
    public void checkIngredientTypeContainsCorrectEnumValues(){
        assertNotNull(IngredientType.valueOf(typeName));
    }

}