import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;


import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientGetNameTest {


	public IngredientGetNameTest(String nameParameter) {
		this.nameParameter = nameParameter;
	}

	private final String nameParameter;


	@Parameterized.Parameters // добавили аннотацию
	public static Object[] getNameData() {
		return new Object[] {
				"HotSauce",
				"Сырный",
				"котлетка",
				"1122",
				"№%:,",
				"",
				"   ",
		};
	}


	@Test
	public void getNameTest() {
		Ingredient ingredient = new Ingredient(SAUCE, nameParameter, 100);
		String actual = ingredient.getName();
		assertEquals(nameParameter, actual);
	}
}
