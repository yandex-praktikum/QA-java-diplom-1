import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private String type;

    public IngredientTypeTest(String type) {
        this.type = type;
    }

    @Parameterized.Parameters(name = "Тип ингридиента. Тестовые данные: {0}")
    public static Object[][] getTestData() {
        return new Object[][] {
                {"SAUCE"},
                {"FILLING"},
        };
    }

    @Test
    public void  presenceIngredientTest(){
        assertThat(type.valueOf(type), is(notNullValue()));
    }

}
