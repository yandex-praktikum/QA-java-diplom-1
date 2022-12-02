import org.junit.Test;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;

public class BunTest extends DataTest {

    private final String bunCorrectName = "Флюоресцентная булка R2-D3";
    private final String bunEmptyName = "";
    private final String bunVeryLongName = "ifjirjtirwnvini камощшкцомшкцм шгрeruihfiure 8592из тпе9м шакцм шоещшкош ишео4ш щшао цушео шеаошщкц ешощцоиме 4егое   ге 4е 4ре 9гпкц";
    private final String bunIncorrectSymbolsName = "~`!@#$%^&*()_+=-";
    private final String bunNullName = null;

    private final float bunCorrectPrice = 12345;
    private final float bunFractionPrice = 10.0001F;
    private final float bunMinusPrice = -1;
    private final float bunNullPrice = 0;
    private final float bunBigPrice = 99999999;


    @Test
    public void getBunCorrectName() {
        bun = new Bun(bunCorrectName, bunCorrectPrice);
        assertEquals(bunCorrectName, bun.getName());
    }
    @Test
    public void getBunEmptyName() {
        bun = new Bun(bunEmptyName, bunCorrectPrice);
        assertEquals(bunEmptyName, bun.getName());
    }
    @Test
    public void getBunVeryLongName() {
        bun = new Bun(bunVeryLongName, bunCorrectPrice);
        assertEquals(bunVeryLongName, bun.getName());
    }
    @Test
    public void getBunIncorrectSymbolsName() {
        bun = new Bun(bunIncorrectSymbolsName, bunCorrectPrice);
        assertEquals(bunIncorrectSymbolsName, bun.getName());
    }
    @Test
    public void getBunNullName() {
        bun = new Bun(bunNullName, bunCorrectPrice);
        assertEquals(bunNullName, bun.getName());
    }


    @Test
    public void getBunCorrectPrice() {
        bun = new Bun(bunCorrectName, bunCorrectPrice);
        assertEquals(bunCorrectPrice, bun.getPrice(), 0);
    }
    @Test
    public void getBunFractionPrice() {
        bun = new Bun(bunCorrectName, bunFractionPrice);
        assertEquals(bunFractionPrice, bun.getPrice(), 0);
    }
    @Test
    public void getBunMinusPrice() {
        bun = new Bun(bunCorrectName, bunMinusPrice);
        assertEquals(bunMinusPrice, bun.getPrice(), 0);
    }
    @Test
    public void getBunNullPrice() {
        bun = new Bun(bunCorrectName, bunNullPrice);
        assertEquals(bunNullPrice, bun.getPrice(), 0);
    }
    @Test
    public void getBunVeryBigPrice() {
        bun = new Bun(bunCorrectName, bunBigPrice);
        assertEquals(bunBigPrice, bun.getPrice(), 0);
    }
}