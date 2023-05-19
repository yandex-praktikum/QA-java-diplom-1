import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import java.util.Collections;

@RunWith(Parameterized.class)
public class BunParameterizedUnitTests {
    private final String name;
    private final float price;

    public BunParameterizedUnitTests(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}, {1}")
    public static Object[][] getData() {
        return new Object[][]{
                {"Флюоресцентная булка R2-D3", 988.025f},
                {"Краторная булка N-200i", 1255},
                //Проверка для названия булки, которое содержит только пробельные символы
                {"     ", 988.025f},
                //Проверка для названия булки со значением null
                {null, 988.025f},
                //Проверка для цены, которая равна отрицательному значению
                {"Флюоресцентная булка R2-D3", -988.025f},
                //Проверка для цены, которая равна нулю
                {"Краторная булка N-200i", 0},
                //Проверка для цены, которая равна максимально возможному значению
                {"Флюоресцентная булка R2-D3", Float.MAX_VALUE},
                //Проверка для цены, которая равна минимально возможному значению
                {"Краторная булка N-200i", Float.MIN_VALUE},
                //Проверка для цены, которая содержит нечисловое значение
                {"Флюоресцентная булка R2-D3", Float.NaN},
                //Проверка для цены, которая содержит значение с плавающей точкой близкое к минимально возможному значению
                {"Краторная булка N-200i", 1.4E-45f},
                //Проверка для цены, которая содержит значение с плавающей точкой близкое к максимально возможному значению
                {"Флюоресцентная булка R2-D3", 3.40282347E38f},
                //Проверка очень длинной строки
                {"Краторная булка N-200i " + String.join("", Collections.nCopies(100, "очень длинное название булки ")), 100f},
                //Проверка специальных символов в строке
                {"@&%$*()", 0}
        };
    }

    @Test
    public void getNameBunParameterizedTest() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals(name, bun.getName());
    }

    @Test
    public void getPriceBunParameterizedTest() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals(price, bun.getPrice(), 0);
    }
}
