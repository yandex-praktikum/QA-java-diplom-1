import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {
    private final String EXPECTED_NAME = "sauce";
    private final float EXPECTED_PRICE = 888.0F;
    private Ingredient ingredient;

    public IngredientTest() {
    }

    @Before
    public void setUp() {
        this.ingredient = new Ingredient(IngredientType.SAUCE, "sauce", 888.0F);
    }

    @Test
    public void getPriceTest() {
        Assert.assertEquals("Не верная цена ингридиента", 888.0F, this.ingredient.getPrice(), 0.0F);
    }

    @Test
    public void getNameTest() {
        Assert.assertEquals("Название ингридиента не совпадает", "sauce", this.ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        Assert.assertEquals("Название ингридиента не совпадает", IngredientType.SAUCE, this.ingredient.getType());
    }
}
