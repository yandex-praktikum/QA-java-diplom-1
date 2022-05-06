import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientGetPriceTest {
	@Mock
	String name = "Spicy";
	@Mock
	IngredientType type = SAUCE;

	public IngredientGetPriceTest(float price, float expected) {
		this.price = price;
		this.expected = expected;
	}

	private final float price;
	private final float expected;

	@Parameterized.Parameters // добавили аннотацию
	public static Object[][] getPriceData() {
		return new Object[][] {
				{100, 100},
				{0, 0},
				{-5, -5},
				{1234567890123456789024f, 1234567890123456789024f},
		};
	}

	@Test
	public void ingredientPriceTest() {
		Ingredient ingredient = new Ingredient(type, name, price);
		float actual = ingredient.getPrice();
		assertEquals(expected, actual, 0.0000001);
	}
}
