import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientGetTypeTest {
	@Mock
	float price = 100;
	@Mock
	String name = "Spicy";
	public IngredientGetTypeTest(IngredientType type, IngredientType expected) {
		this.type = type;
		this.expected = expected;
	}

	private final IngredientType type;
	private final IngredientType expected;

	@Parameterized.Parameters // добавили аннотацию
	public static Object[][] getTypeData() {
		return new Object[][] {
				{ SAUCE, SAUCE},
				{ FILLING, FILLING},
		};
	}

	@Test
	public void getTypeTest() {
		Ingredient ingredient = new Ingredient(type, name, price);
		IngredientType actual = ingredient.getType();
		assertEquals(expected, actual);
	}
}
