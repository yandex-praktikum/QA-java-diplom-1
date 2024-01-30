package praktikum;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static praktikum.RandomStringUtilsArgs.ALPHABETIC_LENGTH;
import static praktikum.RandomStringUtilsArgs.NUMERIC_LENGTH;

public class IngredientTest {

	private static String ingredientName = RandomStringUtils.randomAlphabetic(ALPHABETIC_LENGTH);
	private static float ingredientPrice = Float.valueOf(RandomStringUtils.randomNumeric(NUMERIC_LENGTH));
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