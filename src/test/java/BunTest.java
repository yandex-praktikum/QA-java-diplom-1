import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    private final String errorName = "Ошибка! Выбрана несуществующая модель булочки";
    private final String errorPrice = "Ошибка! Указана неверная цена на выбранную модель булочки";
    private Bun bun;

    @Before
    public void setUp() {
        bun = new Bun("Марсианская булка M-234i", 86.50f);
    }

    @Test
    public void getNameReturnCorrectBunName() {
        Assert.assertEquals(errorName, "Марсианская булка M-234i", bun.getName());
    }

    @Test
    public void getPriceReturnCorrectBunPrice() {
        Assert.assertEquals(errorPrice, 86.50f, bun.getPrice(), 0);
    }
}





