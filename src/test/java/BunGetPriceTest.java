import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunGetPriceTest {
	@Mock
	String name = "Минибулка";

	public BunGetPriceTest(float price, float expected) {
		this.price = price;
		this.expected = expected;
	}

	private final float price;
	private final float expected;

	@Parameterized.Parameters // добавили аннотацию
	public static Object[][] getPriceData() {
		return new Object[][] {
				{100, 100},
				{0, 0},
				{-5, -5},
				{1234567890123456789024f, 1234567890123456789024f},
		};
	}

	@Test
	public void getNameTest() {
		Bun bun = new Bun(name, price);
		float actual = bun.getPrice();
		assertEquals(expected, actual, 0.0000001);
	}
}
