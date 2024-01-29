package praktikum;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

	private final IngredientType ingredientType = IngredientType.SAUCE;
	private static String ingredientName = RandomStringUtils.randomAlphabetic(7);
	private static float ingredientPrice = Float.valueOf(RandomStringUtils.randomNumeric(3));
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