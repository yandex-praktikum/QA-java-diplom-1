package praktikum.bun_tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

/**
 * Демонстрация параметризации теста на валидных данных для имени
 */

@RunWith(Parameterized.class)
public class BunNameTestParam {

    @Parameterized.Parameter(0)
    public String comment;
    @Parameterized.Parameter(1)
    public String nameExpected;
    @Parameterized.Parameter(2)
    public float defaultPrice;
    public String nameActual;

    @Parameterized.Parameters(name = "comment : {0}, nameExpected : {1}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Ожидается имя на English", "black bun", 100.0F},
                {"Ожидается имя на Кириллице", "черная булочка", 100.0F},
                {"Ожидается имя из более 3 слов с пробелами внутри", "черная булочка c маком", 100.0F},
                {"Ожидается имя без пробелов", "blackbun", 100.0F},
                {"Ожидается имя в верхнем регистр", "BLACKBUN", 100.0F},
                {"Ожидается имя из 1 буквы", "B", 100.0F}
        };
    }

    @Test
    public void getNameValidValueReturnValidBunName() {
        Bun bun = new Bun(nameExpected, defaultPrice);
        nameActual = bun.getName();

        assertEquals(comment,nameExpected, nameActual);

    }


}
