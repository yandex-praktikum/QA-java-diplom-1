package praktikum;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientParamTest {

	private final IngredientType type;
	private static String ingredientName = RandomStringUtils.randomAlphabetic(7);
	private static float ingredientPrice = Float.valueOf(RandomStringUtils.randomNumeric(3));

	public IngredientParamTest(IngredientType type, String ingredientName, float ingredientPrice) {
		this.type = type;
		this.ingredientName = ingredientName;
		this.ingredientPrice = ingredientPrice;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{
				{SAUCE, ingredientName, ingredientPrice},
				{FILLING, ingredientName, ingredientPrice}
		});
	}

	@Test
	public void ingredientConstructorTest() {
		Ingredient ingredient = new Ingredient(type, ingredientName, ingredientPrice);
		assertEquals(ingredientName, ingredient.getName());
		assertEquals(type, ingredient.getType());
		assertEquals(ingredientPrice, ingredient.getPrice(), 0);
	}
}
