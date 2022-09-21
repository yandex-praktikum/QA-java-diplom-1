import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterizedBunNameTest {
    private final String burgerName;
    private final float burgerPrice;

    public ParameterizedBunNameTest(String burgerName, float burgerPrice) {
        this.burgerName = burgerName;
        this.burgerPrice = burgerPrice;
    }
    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"superburger", 0},
                {"SUPERBURGER", 0},
                {"бургер", 0},
                {"БУРГЕР", 0},
                {"12345 67890", 0},
                {"Qas10!@#$%^&*()/*-+Абв", 0},
                {null, 0},
                {"", 0},
                {" ", 0},
                { "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a,", 0},
        };
    }

    @Test
    public void getNameReturnsName() {
        Bun bun = new Bun(burgerName, burgerPrice);

        String actual = bun.getName();

        assertEquals("Returns incorrect burger name", burgerName, actual);
    }
}
