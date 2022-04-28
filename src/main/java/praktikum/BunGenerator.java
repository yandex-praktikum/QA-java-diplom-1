package praktikum;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;



public class BunGenerator {

        public static String bunName;
        public static float bunPrice;

        @Step("Generating random bun with Name and Price")
        public static Bun getRandomLoginPriceForBun() {
            bunName = RandomStringUtils.randomAlphabetic(9);
            bunPrice = 109;

            return new Bun(bunName, bunPrice);
        }

}
