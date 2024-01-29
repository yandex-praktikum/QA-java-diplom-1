package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {

	private final IngredientType type;
	private final String name;
	private final float price;

	public IngredientTest(IngredientType type, String name, float price) {
		this.type = type;
		this.name = name;
		this.price = price;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{
				{SAUCE, "Name", 0.00F},
				{FILLING, "otherName", 100.99F}
		});
	}

	@Test
	public void ingredientConstructorTest() {
		Ingredient ingredient = new Ingredient(type, name, price);
		assertEquals(name, ingredient.getName());
		assertEquals(type, ingredient.getType());
		assertEquals(price, ingredient.getPrice(), 0.001);
	}
}
