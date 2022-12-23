import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTest {

	private Ingredient ingredient;
	private String ingredientType;
	String name;
	float price;

	public IngredientTest(String ingredientType, String name, float price) {
		this.ingredientType = ingredientType;
		this.name = name;
		this.price = price;
	}

	@Parameterized.Parameters(name = "Ingredient Type = {0}, Name = {1}, Price = {2}")
	public static Object[][] getData() {
		return new Object[][]{
				{"SAUCE", "Круассан", 66.66f},
				{"FILLING", "Рогалик", 71.71f},
		};
	}

	@Before
	public void setUp() {
		ingredient = new Ingredient(IngredientType.valueOf(ingredientType), name, price);
	}

	@Test
	public void getPriceTest() {
		Assert.assertEquals(price, ingredient.getPrice(), 10);
	}

	@Test
	public void getNameTest() {
		Assert.assertEquals(name, ingredient.getName());
	}

	@Test
	public void getTypeTest() {
		Assert.assertEquals(IngredientType.valueOf(ingredientType), ingredient.getType());
	}
}
