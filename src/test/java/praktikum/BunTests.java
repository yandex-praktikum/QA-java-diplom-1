package praktikum;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BunTests {
    Bun bun;

    @Test
    public void getNameEnglishLettersShowName() {
        String nameExpected = "black bun";
        bun = new Bun(nameExpected, 100F);
        String nameActual = bun.getName();
        assertEquals("Должен видеть имя английскими буквами", nameExpected, nameActual);

    }

    @Test
    public void getNameCyrillicLettersShowName() {
        String nameExpected = "черная булочка";
        bun = new Bun(nameExpected, 100F);
        String nameActual = bun.getName();
        assertEquals("Должен видеть имя на кириллице", nameExpected, nameActual);

    }

    @Test
    public void getNameMoreThanTwoWordsShowName() {
        String nameExpected = "черная булочка c маком";
        bun = new Bun(nameExpected, 100F);
        String nameActual = bun.getName();
        assertEquals("Должен видеть имя из 3 букв и более с пробелами между словами", nameExpected, nameActual);

    }

    @Test
    public void getNameNoGapsShowName() {
        String nameExpected = "blackbun";
        bun = new Bun(nameExpected, 100F);
        String nameActual = bun.getName();
        assertEquals("Должен видеть имя без пробелов", nameExpected, nameActual);

    }

    @Test
    public void getNameUpperCaseShowName() {
        float priceExpected = 100F;
        String nameExpected = "BLACKBUN";
        bun = new Bun(nameExpected, priceExpected);
        String nameActual = bun.getName();
        assertEquals("Должен видеть имя с буквами на верхнем регистре", nameExpected, nameActual);

    }

    @Test
    public void getName1letterShowName() {
        String nameExpected = "B";
        bun = new Bun(nameExpected, 100F);
        String nameActual = bun.getName();
        assertEquals("Должен видеть имя из 1 буквы", nameExpected, nameActual);

    }

    @Test(expected = OutOfMemoryError.class)
    public void getNameMaxLengthShowsOutOfMemoryError() {
        //Следует добавить ограничение на максимально возможную строку в имени булочки
        int textLength = Integer.MAX_VALUE;
        String nameExpected = RandomStringUtils.randomAlphabetic(textLength);
        bun = new Bun(nameExpected, 100F);

    }

    @Test
    public void getNameLengthIsMoreThan40000LettersShowsName() {
        //Следует добавить ограничение на максимально возможную строку в имени булочки
        int textLength = (int) Math.sqrt(Integer.MAX_VALUE);
        String nameExpected = RandomStringUtils.randomAlphabetic(textLength);
        bun = new Bun(nameExpected, 100F);
        String nameActual = bun.getName();
        assertEquals("Должен видеть имя из 46340 букв", nameExpected, nameActual);

    }

    @Test
    public void getNameSpecificSymbolsShowsName() {
        //Следует добавить ограничение на допустимые символы в имени булочки
        String nameExpected = RandomStringUtils.randomAscii(5);
        bun = new Bun(nameExpected, 100F);
        String nameActual = bun.getName();
        assertEquals("Должен видеть имя со спецсимволами", nameExpected, nameActual);

    }

    @Test
    public void getNameNullValueShowsName() {
        //следует ограничить возможность создания объекта Bun, если имя булочки null
        bun = new Bun(null, 100.F);
        String nameActual = bun.getName();
        assertThat("Должен видеть имя с null", nameActual, is(nullValue()));

    }

    @Test
    public void getNameEmptyValueShowsName() {
        //следует ограничить возможность создания объекта Bun, если имя булочки пустое
        String nameExpected = "";
        bun = new Bun(nameExpected, 100.F);
        String nameActual = bun.getName();
        assertEquals("Должен видеть пустое имя", nameExpected, nameActual);

    }

    @Test
    public void getNameGapsOnlyValueShowsName() {
        //следует ограничить возможность создания объекта Bun, если имя булочки содержит только пробелы
        String nameExpected = "     ";
        bun = new Bun(nameExpected, 100.F);
        String nameActual = bun.getName();
        assertEquals("Должен видеть имя состоящее из пробелов", nameExpected, nameActual);

    }

    @Test
    public void getNameMoreThanOneGapInAMiddleShowsName() {
        //следует ограничить возможность создания объекта Bun, если имя булочки содерижт более 1 пробела между словами
        String nameExpected = "black  bun";
        bun = new Bun(nameExpected, 100.F);
        String nameActual = bun.getName();
        assertEquals("Должен видеть имя c более 1 пробелом в середине", nameExpected, nameActual);

    }

    @Test
    public void getNameStartsWithGapShowsName() {
        //следует ограничить возможность создания объекта Bun, если имя булочки начинается с пробела
        String nameExpected = " black bun";
        bun = new Bun(nameExpected, 100.F);
        String nameActual = bun.getName();
        assertEquals("Должен видеть имя, которое начинается с пробела", nameExpected, nameActual);

    }

    @Test
    public void getEndsWithGapShowsName() {
        //следует ограничить возможность создания объекта Bun, если имя булочки заканчивается пробелом
        String nameExpected = "black bun ";
        bun = new Bun(nameExpected, 100.F);
        String nameActual = bun.getName();
        assertEquals("Должен видеть имя, которое заканчивается пробелом", nameExpected, nameActual);

    }

    @Test
    public void getPricePositiveIntegerNumberPositivePrice() {
        int expectedPrice = 100;
        bun = new Bun("black bun", expectedPrice);
        float actualPrice = bun.getPrice();
        assertEquals("Должен видеть цену с положительным целым числом", expectedPrice, actualPrice, 0);
    }

    @Test
    public void getPricePositiveFloatNumberShowsPositivePrice() {
        float expectedPrice = 100.01F;
        bun = new Bun("black bun", expectedPrice);
        float actualPrice = bun.getPrice();
        assertEquals("Должен видеть цену с положительным дробным числом", expectedPrice, actualPrice, 0);
    }

    @Test
    public void getPriceNegativeNumberShowsNegativePrice() {
        //следует ограничить возможность создания объекта Bun с отрицательной ценой
        float negativePrice = -0.01F;
        bun = new Bun("black bun", negativePrice);
        assertThat("Должен видеть отрицательную цену", bun.getPrice(), is(negativePrice));
    }

    @Test
    public void getPriceZeroNumberShowsZeroPrice() {
        //следует ограничить возможность создания объекта Bun с нулевой ценой
        float expectedZeroPrice = 0F;
        bun = new Bun("black bun", expectedZeroPrice);
        float actualPrice = bun.getPrice();
        assertEquals("Должен видеть цену 0", actualPrice, expectedZeroPrice, 0);
    }


}