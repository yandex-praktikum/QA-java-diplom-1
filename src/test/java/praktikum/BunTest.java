package praktikum;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;

import static praktikum.RandomStringUtilsArgs.ALPHABETIC_LENGTH;
import static praktikum.RandomStringUtilsArgs.NUMERIC_LENGTH;

public class BunTest {

	String bunName = RandomStringUtils.randomAlphabetic(ALPHABETIC_LENGTH);
	float bunPrice = Float.valueOf(RandomStringUtils.randomNumeric(NUMERIC_LENGTH));

	@Test
	public void getBunNameTest() {
		Bun bun = new Bun(bunName, bunPrice);
		Assert.assertEquals(bunName, bun.getName());
	}

	@Test
	public void getBunPriceTest() {
		Bun bun = new Bun(bunName, bunPrice);
		Assert.assertEquals(bunPrice, bun.getPrice(), 0);
	}
}
