import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType typeInput;
    private final String nameInput;
    private final float priceInput;

    private Ingredient ingredient;

    public IngredientTest(IngredientType typeInput, String nameInput, float priceInput) {
        this.typeInput = typeInput;
        this.nameInput = nameInput;
        this.priceInput = priceInput;
    }


    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {TestData.INGREDIENT_TYPE, TestData.INGREDIENT_NAME, TestData.INGREDIENT_PRICE},
                {TestData.INGREDIENT_TYPE2, TestData.INGREDIENT_NAME2, TestData.INGREDIENT_PRICE2}
        };
    }

    @Before
    public void prepareData() {
        ingredient = new Ingredient(typeInput, nameInput, priceInput);
    }

    @Test
    public void testGetIngredientType() {
        assertThat("Тип для Ingredient неверен.", ingredient.getType(), equalTo(typeInput));
    }

    @Test
    public void testGetIngredientName() {
        assertThat("Имя для Ingredient неверное.", ingredient.getName(), equalTo(nameInput));
    }

    @Test
    public void testGetIngredientPrice() {
        assertThat("Цена для Ingredient неверная.", ingredient.getPrice(), equalTo(priceInput));
    }
}
