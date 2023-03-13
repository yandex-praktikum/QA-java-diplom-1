import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;


import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)
public class ParameterizedBunTest {

    private final String name;
    private final float price;

    public ParameterizedBunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }


    @Parameterized.Parameters
    public static Object[][] bunsIn(){
        return new Object[][]{
                {"Страшная",500},
                {"Новая",500},
                {null,500F},
        };
    }

    @Test
    public void checkResultChoose() {
        Bun bun = new Bun(name,price);
        assertEquals(bun.getName(),name);
        assertEquals(bun.getPrice(),price,0);
    }

}
