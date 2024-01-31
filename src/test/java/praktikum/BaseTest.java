package praktikum;

import org.apache.commons.lang3.RandomStringUtils;

import static praktikum.RandomStringUtilsArgs.ALPHABETIC_LENGTH;
import static praktikum.RandomStringUtilsArgs.NUMERIC_LENGTH;

public class BaseTest {
	protected static String bunName = RandomStringUtils.randomAlphabetic(ALPHABETIC_LENGTH);
	protected static float bunPrice = Float.valueOf(RandomStringUtils.randomNumeric(NUMERIC_LENGTH));
	protected static String ingredientName = RandomStringUtils.randomAlphabetic(ALPHABETIC_LENGTH);
	protected static float ingredientPrice = Float.valueOf(RandomStringUtils.randomNumeric(NUMERIC_LENGTH));
}
