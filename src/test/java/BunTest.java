import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {

    private final String name;
    private final float price;

    public BunTest(String name, float price){
        this.name = name;
        this.price = price;
    }


    @Parameterized.Parameters
    public static Object[][] getBunDetails() {
        return new Object[][]{
                {"Флюоресцентная булка R2-D3", 988},
                {" ", 988},
                {null, 988},
                {"Краторная булка N-200i, покрытая фирменным соусом Space Sauce, и с начинкой из мяса бессмертных моллюском Protostomia", 988},
                {"J", 988},
                {"¯\\_(ツ)_/¯", 988},
                {"Флюоресцентная булка", -1},
                {"Флюоресцентная булка", 0},
                {"Флюоресцентная булка", 1},
                {"Флюоресцентная булка", 1200.05546F},
                {"Флюоресцентная булка", Float.MAX_VALUE},
                {"Флюоресцентная булка", Float.MIN_VALUE},

        };
    }

    @Test
    public void checkGetNameReturnsCorrectValue(){
        Bun bun = new Bun(name, price);
        Assert.assertEquals(name, bun.getName());
    }

    @Test
    public void checkGetPriceReturnsCorrectValue(){
        Bun bun = new Bun(name, price);
        Assert.assertEquals(price, bun.getPrice(), 0);
    }



}
