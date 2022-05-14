import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;


@RunWith(Parameterized.class)
public class IngredientGetPriceTest {


	private static final double TOLERANCE = 0.0000001;

	public IngredientGetPriceTest(float priceParameter) {
		this.priceParameter = priceParameter;
	}

	private final float priceParameter;


	@Parameterized.Parameters // добавили аннотацию
	public static Object[] getPriceData() {
		return new Object[]{
				100,
				0,
				-5,
				1234567890123456789024f,
		};
	}

	@Test
	public void ingredientPriceTest() {
		Ingredient ingredient = new Ingredient(SAUCE, "Spicy", priceParameter);
		float actual = ingredient.getPrice();
		assertEquals(priceParameter, actual, TOLERANCE);
	}
}
