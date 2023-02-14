package praktikum.bun_tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import praktikum.Bun;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * В основном негативные или специфические тесты с рекомендациями по улучшению
 */
public class BunTest {
    private Bun bun;

    @Test(expected = OutOfMemoryError.class)
    public void getNameMaxLengthReturnOutOfMemoryError() {
        //Следует добавить ограничение на максимально возможную строку в имени булочки
        int textLength = Integer.MAX_VALUE;
        String nameExpected = RandomStringUtils.randomAlphabetic(textLength);
        bun = new Bun(nameExpected, 100F);
    }

    @Test
    public void getNameLengthIsMoreThan40000LettersReturnBunName() {
        //Следует добавить ограничение на максимально возможную строку в имени булочки
        int textLength = (int) Math.sqrt(Integer.MAX_VALUE);
        String nameExpected = RandomStringUtils.randomAlphabetic(textLength);
        bun = new Bun(nameExpected, 100F);
        String nameActual = bun.getName();
        assertEquals("Должен видеть имя из 46340 букв", nameExpected, nameActual);

    }

    @Test
    public void getNameSpecificSymbolsReturnBunName() {
        //Следует добавить ограничение на допустимые символы в имени булочки
        String nameExpected = RandomStringUtils.randomAscii(5);
        bun = new Bun(nameExpected, 100F);
        String nameActual = bun.getName();
        assertEquals("Должен видеть имя со спецсимволами", nameExpected, nameActual);

    }

    @Test
    public void getNameNullValueReturnBunName() {
        //следует ограничить возможность создания объекта Bun, если имя булочки null
        bun = new Bun(null, 100.F);
        String nameActual = bun.getName();
        assertThat("Должен видеть имя с null", nameActual, is(nullValue()));

    }

    @Test
    public void getNameEmptyValueReturnBunName() {
        //следует ограничить возможность создания объекта Bun, если имя булочки пустое
        String nameExpected = "";
        bun = new Bun(nameExpected, 100.F);
        String nameActual = bun.getName();
        assertEquals("Должен видеть пустое имя", nameExpected, nameActual);

    }

    @Test
    public void getNameGapsOnlyValueReturnBunName() {
        //следует ограничить возможность создания объекта Bun, если имя булочки содержит только пробелы
        String nameExpected = "     ";
        bun = new Bun(nameExpected, 100.F);
        String nameActual = bun.getName();
        assertEquals("Должен видеть имя состоящее из пробелов", nameExpected, nameActual);

    }

    @Test
    public void getNameMoreThanOneGapInAMiddleReturnBunName() {
        //следует ограничить возможность создания объекта Bun, если имя булочки содерижт более 1 пробела между словами
        String nameExpected = "black  bun";
        bun = new Bun(nameExpected, 100.F);
        String nameActual = bun.getName();
        assertEquals("Должен видеть имя c более 1 пробелом в середине", nameExpected, nameActual);

    }

    @Test
    public void getNameStartsWithGapReturnBunName() {
        //следует ограничить возможность создания объекта Bun, если имя булочки начинается с пробела
        String nameExpected = " black bun";
        bun = new Bun(nameExpected, 100.F);
        String nameActual = bun.getName();
        assertEquals("Должен видеть имя, которое начинается с пробела", nameExpected, nameActual);

    }

    @Test
    public void getEndsWithGapReturnBunName() {
        //следует ограничить возможность создания объекта Bun, если имя булочки заканчивается пробелом
        String nameExpected = "black bun ";
        bun = new Bun(nameExpected, 100.F);
        String nameActual = bun.getName();
        assertEquals("Должен видеть имя, которое заканчивается пробелом", nameExpected, nameActual);

    }

    @Test
    public void getPriceNegativeNumberReturnBunNegativePrice() {
        //следует ограничить возможность создания объекта Bun с отрицательной ценой
        float negativePrice = -0.01F;
        bun = new Bun("black bun", negativePrice);
        assertThat("Должен видеть отрицательную цену", bun.getPrice(), is(negativePrice));
    }

    @Test
    public void getPriceMaxFloatNumberReturnBunPrice() {
        //следует ограничить возможность создания объекта Bun с макс ценой ценой
        float expectedMaxFloatNumber = Float.MAX_VALUE;
        bun = new Bun("black bun", expectedMaxFloatNumber);
        float actualPrice = bun.getPrice();
        assertEquals("Должен видеть максимальное число типа float", actualPrice, expectedMaxFloatNumber, 0);
    }


}