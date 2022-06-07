import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import praktikum.Bun;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTest {
    @Mock
    IngredientType type;
    private String name;
    private float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] setBun() {
        return new Object[][]{
                {"Tanya", 100},
                {null, 0},
                {"TestName", -1},
                {"", -0.1F}
        };
    }

    @Before
    public void setUp() {
        bun = new Bun(name, price);
    }
}
