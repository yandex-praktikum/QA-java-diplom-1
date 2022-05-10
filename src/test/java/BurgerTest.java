import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

	@Mock
	Bun bun;
	@Mock
	Ingredient ingredient;

	Burger burger = new Burger();
	private static double tolerance =  0.0000001;

	@Before
	public void setIngredientsData() {
		burger.addIngredient(ingredient);
		burger.addIngredient(ingredient);
		burger.addIngredient(ingredient);
		burger.addIngredient(ingredient);
		burger.setBuns(bun);
		burger.setBuns(bun);
	}

	@Test
	public void addIngredientTest() {
		int startSize = burger.ingredients.size();
		burger.addIngredient(ingredient);
		int actualSize = burger.ingredients.size();
		assertEquals(actualSize - 1, startSize);
	}

	@Test
	public void removeIngredientTest() {
		int startSize = burger.ingredients.size();
		burger.removeIngredient(2);
		int actualSize = burger.ingredients.size();
		assertEquals(actualSize + 1, startSize);
	}

	@Test
	public void moveIngredientTest() {
		 Ingredient ingredient = Mockito.mock(Ingredient.class);//new Ingredient(IngredientType.SAUCE, "hot", 1000);
		 burger.addIngredient(ingredient);
		 int indexNewIngredient = burger.ingredients.size() - 1;
		 burger.moveIngredient(indexNewIngredient, 3);
		 assertEquals(burger.ingredients.get(3), ingredient);
	}

	@Test
	public void getPriceTest() {
		when(ingredient.getPrice()).thenReturn(100f);
		when(bun.getPrice()).thenReturn(50f);
		float priceActual = burger.getPrice();
		float priceExpected = burger.ingredients.size()*100+bun.getPrice()*2; //стоимость всех выбранных ингредиентов и двух булок
		assertEquals(priceExpected , priceActual,tolerance);
	}

	@Test
	public void getReceiptTest() {
		String expected = "(==== mini ====)\n"
						+"= sauce cheese =\n"
						+"= sauce cheese =\n"
						+"= sauce cheese =\n"
						+"= sauce cheese =\n"
						+"(==== mini ====)\n"
						+"\n"
						+"Price: 500,000000\n";
		when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
		when(ingredient.getName()).thenReturn("cheese");
		when(ingredient.getPrice()).thenReturn(100f);
		when(bun.getPrice()).thenReturn(50f);
		when(bun.getName()).thenReturn("mini");
		String actual = burger.getReceipt();
		assertEquals("Method print check", expected, actual);

	}

	@After
	public void tearDown() {
		for (int i = 0; i < burger.ingredients.size(); i++) {
			burger.removeIngredient(i);
		}
	}
}
