package praktikum;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
	@Mock
	Bun bun;
	@Mock
	Ingredient ingredient1;
	@Mock
	Ingredient ingredient2;
	private Burger burger;
	private static String bunName = RandomStringUtils.randomAlphabetic(7);

	private static String ingredientName = RandomStringUtils.randomAlphabetic(7);
	private static float ingredientPrice = Float.valueOf(RandomStringUtils.randomNumeric(3));

	@Before
	public void setUp() {
		burger = new Burger();
		bun = mock(Bun.class);
		ingredient1 = mock(Ingredient.class);
		ingredient2 = mock(Ingredient.class);
	}

	@Test
	public void setBunsTest() {
		burger.setBuns(bun);
		assertEquals(bun, burger.bun);
	}

	@Test
	public void getBurgerPriceTest() {
		burger.setBuns(bun);
		burger.addIngredient(ingredient1);
		burger.addIngredient(ingredient2);

		Mockito.when(bun.getPrice()).thenReturn(200.00F);
		Mockito.when(ingredient1.getPrice()).thenReturn(100.00F);
		Mockito.when(ingredient2.getPrice()).thenReturn(100.00F);

		float actualResult = burger.getPrice();
		assertEquals((200.0F * 2) + 100.0F + 100.0F, actualResult, 0);
	}

	@Test
	public void addIngredientTest() {
		burger.addIngredient(ingredient1);
		burger.addIngredient(ingredient2);
		assertEquals(Arrays.asList(ingredient1, ingredient2), burger.ingredients);
	}

	@Test
	public void removeIngredientTest() {
		burger.ingredients.addAll(Arrays.asList(ingredient1, ingredient2));
		burger.removeIngredient(1);
		assertEquals(Arrays.asList(ingredient1), burger.ingredients);
	}

	@Test
	public void moveIngredientTest() {
		burger.ingredients.addAll(Arrays.asList(ingredient1, ingredient2));
		burger.moveIngredient(0, 1);
		assertEquals(Arrays.asList(ingredient2, ingredient1), burger.ingredients);
	}

	@Test
	public void getBurgerReceiptTest() {
		Mockito.when(bun.getName()).thenReturn(ingredientName);
		Mockito.when(bun.getPrice()).thenReturn(ingredientPrice);
		Mockito.when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
		Mockito.when(ingredient1.getName()).thenReturn(ingredientName);
		Mockito.when(ingredient1.getPrice()).thenReturn(ingredientPrice);
		Mockito.when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
		Mockito.when(ingredient2.getName()).thenReturn(ingredientName);
		Mockito.when(ingredient2.getPrice()).thenReturn(ingredientPrice);
		String expectedPrice = String.format("%.6f", ingredientPrice * 4);
		burger.setBuns(bun);
		burger.ingredients.addAll(Arrays.asList(ingredient1, ingredient2));

		String expectedReceipt = "(==== " + ingredientName + " ====)\n" +
				"= sauce " + ingredientName + " =\n" +
				"= filling " + ingredientName + " =\n" +
				"(==== " + ingredientName + " ====)\n" +
				"\n" +
				"Price: " + expectedPrice + "\n";

		assertEquals(expectedReceipt, burger.getReceipt());
	}
}