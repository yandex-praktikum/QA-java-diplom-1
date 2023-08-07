import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientGetTypeTest {

	public IngredientGetTypeTest(IngredientType typeParameter) {
		this.typeParameter = typeParameter;
	}

	private final IngredientType typeParameter;


	@Parameterized.Parameters // добавили аннотацию
	public static Object[] getTypeData() {
		return new Object[] {
				SAUCE,
				FILLING,
		};
	}

	@Test
	public void getTypeTest() {
		Ingredient ingredient = new Ingredient(typeParameter, "Spicy", 200);
		IngredientType actual = ingredient.getType();
		assertEquals(typeParameter, actual);
	}
}
