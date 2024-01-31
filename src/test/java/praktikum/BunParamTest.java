package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunParamTest extends BaseTest {


	public BunParamTest(String bunName, float bunPrice) {
		this.bunName = bunName;
		this.bunPrice = bunPrice;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{
				{"", bunPrice},
				{"test very long string for this parameter", bunPrice},
				{"±!@#$%^&*()_+~|?.", bunPrice},
				{null, bunPrice},
				{bunName, -100.00F},
				{bunName, 0.00F},
				{bunName, Float.MIN_VALUE},
				{bunName, Float.MAX_VALUE}
		});
	}

	@Test
	public void bunConstructorTest() {
		Bun bun = new Bun(bunName, bunPrice);
		assertEquals(bunName, bun.getName());
		assertEquals(bunPrice, bun.getPrice(), 0);
	}

}
