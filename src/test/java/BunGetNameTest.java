import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunGetNameTest {


	public BunGetNameTest(String nameParameter) {
		this.nameParameter = nameParameter;
	}

	private final String nameParameter;

	@Parameterized.Parameters // добавили аннотацию
	public static Object[] getNameData() {
		return new Object[]{
				"МегаБургер",
				"bigBurger",
				"мегабургер",
				"1122",
				"№%:,",
				"",
				"   ",
		};
	}

	@Test
	public void getNameTest() {
		Bun bun = new Bun(nameParameter, 300);
		String actual = bun.getName();
		assertEquals(nameParameter, actual);
	}
}
