package praktikum;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class BunTest {

    private final SoftAssertions softAssertions = new SoftAssertions();

    @Parameterized.Parameter
        public String nameBun;

    @Parameterized.Parameter(1)
        public float priceBun;

    @Parameterized.Parameter(2)
        public String expectedName;

    @Parameterized.Parameter(3)
        public float expectedPrice;

    @Parameterized.Parameters(name = "expected name = {2}, expected price = {3}")
    public static Object[][] dataBun() {
        return new Object[][]{
                {"Galaxy", 1000, "Galaxy", 1000},
                {"миндальная", 300.99f, "миндальная", 300.99f},
                };
    }

    @Test
    public void bunNameTest() {
        Bun bun = new Bun(nameBun, priceBun);
        softAssertions.assertThat(bun.getName()).isEqualTo(expectedName);
        softAssertions.assertThat(bun.getPrice()).isEqualTo(expectedPrice);
        softAssertions.assertAll();
    }

}
