package praktikum;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BunTest {


	String bunName = RandomStringUtils.randomAlphabetic(7);
	float bunPrice = Float.valueOf(RandomStringUtils.randomNumeric(3));

	@Test
	public void bunConstructorTest() {
		Bun bun = new Bun(bunName, bunPrice);
		assertEquals(bunName, bun.getName());
		assertEquals(bunPrice, bun.getPrice(), 0);
	}

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
