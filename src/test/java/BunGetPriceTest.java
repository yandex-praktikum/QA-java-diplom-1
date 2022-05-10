import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunGetPriceTest {
	private static final double tolerance = 0.0000001;

	public BunGetPriceTest(float priceParameter) {
		this.priceParameter = priceParameter;
	}

	private final float priceParameter;


	@Parameterized.Parameters // добавили аннотацию
	public static Object[] getPriceData() {
		return new Object[] {
				100,
				0,
				-5,
				1234567890123456789024f,
		};
	}

	@Test
	public void getNameTest() {
		Bun bun = new Bun("Минибулка", priceParameter);
		float actual = bun.getPrice();
		assertEquals(priceParameter, actual, tolerance);
	}
}
