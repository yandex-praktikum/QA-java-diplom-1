import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunGetNameTest {
	@Mock
	float price = 300;

	public BunGetNameTest(String name, String expected) {
		this.name = name;
		this.expected = expected;
	}

	private final String name;
	private final String expected;
	
	@Parameterized.Parameters // добавили аннотацию
	public static Object[][] getNameData() {
		return new Object[][] {
				{ "МегаБургер", "МегаБургер"},
				{ "bigBurger", "bigBurger"},
				{ "мегабургер", "мегабургер"},
				{ "1122", "1122"},
				{ "№%:,", "№%:,"},
				{ "", ""},
				{ "   ", "   "},
		};
	}

	@Test
	public void getNameTest() {
		Bun bun = new Bun(name, price);
		String actual = bun.getName();
		assertEquals(expected, actual);
	}
}
