package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTest extends BaseTest {

	private final IngredientType ingredientType = IngredientType.SAUCE;
	Ingredient ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);

	@Test
	public void getIngredientPriceTest() {
		float actualResult = ingredient.getPrice();
		assertEquals(ingredientPrice, actualResult, 0);
	}

	@Test
	public void getIngredientNameTest() {
		String actualResult = ingredient.getName();
		assertEquals(ingredientName, actualResult);
	}

	@Test
	public void getIngredientTypeTest() {
		IngredientType actualResult = ingredient.getType();
		assertEquals(ingredientType, actualResult);
	}
}