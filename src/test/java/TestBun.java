import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class TestBun {

    private String name;
    private float price;
    private Bun bun;

    public TestBun(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Проверка возвращаемого значения названия и цены")
    public static Object[][] bunParameters() {
        return new Object[][]{
                {"Булка", 0},               //Цена - 0
                {"Булка", 0.46f},           //Цена - 0 + десятичные знаки
                {"Булка", 1000},            //Цена - целое число
                {"Б", 1000},                //Название - одна буква
                {"Булкааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааа", 1000},
                                            //Название - много букв
                {"Булка-сосиска", 1000},                //Название - с тире
        };
    }

    @Test
    public void checkReturnParams() {
        bun = new Bun(name, price);
        Assert.assertEquals(name, bun.getName());
        Assert.assertEquals(price, bun.getPrice(),0);
    }
}
