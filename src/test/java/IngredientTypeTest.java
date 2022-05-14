import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {
	@Test
	public void isSaucePresent() {
		IngredientType actual = IngredientType.valueOf("SAUCE");
		IngredientType expected = IngredientType.SAUCE;
		assertEquals(expected, actual);
	}

	@Test
	public void isFillingPresent() {
		IngredientType actual = IngredientType.valueOf("FILLING");
		IngredientType expected = IngredientType.FILLING;
		assertEquals(expected, actual);
	}
}
