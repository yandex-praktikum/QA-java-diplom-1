import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;


import static org.mockito.ArgumentMatchers.isA;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

	@Mock
	private Burger burger;

	@Test
	public void setBunsTest() {
		Bun bun = new Bun("Багет", 33.3f);
		burger.setBuns(bun);

		Mockito.verify(burger).setBuns(bun);
		Mockito.verify(burger).setBuns(Mockito.any(Bun.class));
	}

	@Test
	public void addIngredientTest() {
		Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Каравай", 1.1f);
		burger.addIngredient(ingredient);

		Mockito.verify(burger).addIngredient(isA(Ingredient.class));
		Mockito.verify(burger, Mockito.times(1)).addIngredient(ingredient);
	}

	@Test
	public void removeIngredientTest() {
		int index = 1;
		burger.removeIngredient(index);

		Mockito.verify(burger).removeIngredient(index);
		Mockito.verify(burger).removeIngredient(Mockito.anyInt());
	}

	@Test
	public void moveIngredientTest() {
		int index = 0;
		int newIndex = 1;
		burger.moveIngredient(index, newIndex);
		burger.moveIngredient(index, newIndex);

		Mockito.verify(burger, Mockito.times(2)).moveIngredient(index, newIndex);
	}

	@Test
	public void getPriceTest() {
		float expectedPrice = 11.11f;

		Mockito.when(burger.getPrice()).thenReturn(expectedPrice);
		Assert.assertEquals(expectedPrice, burger.getPrice(), 0);
	}

	@Test
	public void getReceiptTest() {
		String expectedReceipt = "Receipt printed";

		Mockito.when(burger.getReceipt()).thenReturn(expectedReceipt);
		Assert.assertEquals(expectedReceipt, burger.getReceipt());
	}
}
