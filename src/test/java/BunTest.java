import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

	private Bun bun;

	@Before
	public void setUp(){
		bun = new Bun("Круассан", 11.5f);
	}

	@Test
	public void getNameTest(){
		Assert.assertEquals("Круассан", bun.getName());
	}

	@Test
	public void getPriceTest(){
		Assert.assertEquals(11.5f, bun.getPrice(), 0);
	}
}
