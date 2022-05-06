import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientGetNameTest {
	@Mock
	float price = 100;
	@Mock
	IngredientType type = SAUCE;

	public IngredientGetNameTest(String name, String expected) {
		this.name = name;
		this.expected = expected;
	}

	private final String name;
	private final String expected;

	@Parameterized.Parameters // добавили аннотацию
	public static Object[][] getNameData() {
		return new Object[][] {
				{ "HotSauce", "HotSauce"},
				{ "Сырный", "Сырный"},
				{ "котлетка", "котлетка"},
				{ "1122", "1122"},
				{ "№%:,", "№%:,"},
				{ "", ""},
				{ "   ", "   "},
		};
	}


	@Test
	public void getNameTest() {
		Ingredient ingredient = new Ingredient(type, name, price);
		String actual = ingredient.getName();
		assertEquals(expected, actual);
	}
}
