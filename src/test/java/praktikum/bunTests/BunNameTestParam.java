package praktikum.bunTests;

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
    public String nameProvided;
    @Parameterized.Parameter(2)
    public String nameActual;

    @Parameterized.Parameters(name = "comment : {0}, nameProvided : {1}, nameActual : {2}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {"English", "black bun", "black bun"},
                {"Кириллица", "черная булочка", "черная булочка"},
                {"Более 3 слов с пробелами внутри", "черная булочка c маком", "черная булочка c маком"},
                {"Без пробелов", "blackbun", "blackbun"},
                {"Верхний регистр", "BLACKBUN", "BLACKBUN"},
                {"1 буквы", "B", "B"}
        };
    }

    @Test
    public void getNameValidValueReturnValidBunName() {
        Bun bun = new Bun(nameProvided, 100F);
        nameActual = bun.getName();
        assertEquals(nameActual, nameProvided);

    }


}
