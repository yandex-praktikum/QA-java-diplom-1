import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import praktikum.*;

import static org.junit.Assert.assertEquals;


public class BurgerTest {

	Burger burger = new Burger();

	@Before
	public void setIngredientsData() {
		burger.addIngredient(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
		burger.addIngredient(new Ingredient(IngredientType.SAUCE, "cheese", 300));
		burger.addIngredient(new Ingredient(IngredientType.FILLING, "BBQ", 500));
		burger.addIngredient(new Ingredient(IngredientType.FILLING, "cheddar", 600));
		burger.setBuns(new Bun("black bun", 100));
	}

	@Test
	public void addIngredientTest() {
		int startSize = burger.ingredients.size();
		burger.addIngredient(new Ingredient(IngredientType.SAUCE, "light", 800));
		int expectedSize = burger.ingredients.size();
		assertEquals(expectedSize - 1, startSize);
	}

	@Test
	public void removeIngredientTest() {
		int startSize = burger.ingredients.size();
		burger.removeIngredient(2);
		int expectedSize = burger.ingredients.size();
		assertEquals(expectedSize + 1, startSize);
	}

	@Test
	public void moveIngredientTest() {
		Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot", 1000);
		 burger.addIngredient(ingredient);
		 int indexNewIngredient = burger.ingredients.size() - 1;
		 burger.moveIngredient(indexNewIngredient, 3);
		 assertEquals(burger.ingredients.get(3), ingredient);
	}

	@Test
	public void getPriceTest() {
		float priceActual = burger.getPrice();
		float priceExpected = 1700; //стоимость всех выбранных ингредиентов и двух булок
		assertEquals(priceExpected, priceActual, 0.0000001);
	}

	@Test
	public void getReceiptTest() {
		String expected = "(==== black bun ====)\n"
						+"= sauce hot sauce =\n"
						+"= sauce cheese =\n"
						+"= filling BBQ =\n"
						+"= filling cheddar =\n"
						+"(==== black bun ====)\n"
						+"\n"
						+"Price: 1700,000000\n";
		String actual = burger.getReceipt();
		assertEquals("Method print check", expected, actual);

	}

	@After
	public void tearDown() {
		for (int i = 0; i < (burger.ingredients.size() - 1); i++) {
			burger.removeIngredient(i);
		}
	}
}
