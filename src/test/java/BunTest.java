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
        bun = new Bun("Флюоресцентная булка R2-D3", 988f);
    }

    @Test
    public void getNameReturnCorrectBunName() {
        Assert.assertEquals(errorName, "Флюоресцентная булка R2-D3", bun.getName());
    }
}





