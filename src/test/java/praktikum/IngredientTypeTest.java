package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

	@Test
	public void enumOrderTest() {
		IngredientType[] values = IngredientType.values();
		assertEquals(2, values.length);
		assertEquals(IngredientType.SAUCE, values[0]);
		assertEquals(IngredientType.FILLING, values[1]);
	}

	@Test
	public void enumValuesTest() {
		assertEquals("SAUCE", IngredientType.SAUCE.toString());
		assertEquals("FILLING", IngredientType.FILLING.toString());
	}
}
