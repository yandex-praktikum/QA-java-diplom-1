import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {

	private Ingredient ingredient;

	@Before
	public void setUp(){
		ingredient = new Ingredient(IngredientType.SAUCE, "Рогалик", 66.66f);
	}

	@Test
	public void getPriceTest(){
		Assert.assertEquals(66.66f, ingredient.getPrice(), 0);
	}

	@Test
	public void getNameTest(){
		Assert.assertEquals("Рогалик", ingredient.getName());
	}

	@Test
	public void getTypeTest(){
		Assert.assertEquals(IngredientType.SAUCE, ingredient.getType());
	}
}
