package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class BunTest extends BaseTest {

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
