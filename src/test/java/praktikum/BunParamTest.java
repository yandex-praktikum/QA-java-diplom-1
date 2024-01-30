package praktikum;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static praktikum.RandomStringUtilsArgs.ALPHABETIC_LENGTH;
import static praktikum.RandomStringUtilsArgs.NUMERIC_LENGTH;

@RunWith(Parameterized.class)
public class BunParamTest {

	private static String bunName = RandomStringUtils.randomAlphabetic(ALPHABETIC_LENGTH);
	private static float bunPrice = Float.valueOf(RandomStringUtils.randomNumeric(NUMERIC_LENGTH));

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
