package praktikum.ingredient_tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import praktikum.Ingredient;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {
    Ingredient ingredient;

    @Test
    public void getNameEnglishLettersShowName() {
        String nameExpected = "mustard";
        ingredient = new Ingredient(SAUCE, nameExpected, 200F);
        String nameActual = ingredient.getName();
        assertEquals("Должен видеть имя английскими буквами", nameExpected, nameActual);

    }

    @Test
    public void getNameCyrillicLettersShowName() {
        String nameExpected = "горчица";
        ingredient = new Ingredient(SAUCE, nameExpected, 200F);
        String nameActual = ingredient.getName();
        assertEquals("Должен видеть имя на кириллице", nameExpected, nameActual);

    }

    @Test
    public void getNameWithGapInsideShowName() {
        String nameExpected = "горчица yellow";
        ingredient = new Ingredient(SAUCE, nameExpected, 200F);
        String nameActual = ingredient.getName();
        assertEquals("Должен видеть имя с пробелом", nameExpected, nameActual);

    }

    @Test
    public void getNameUpperCaseShowName() {
        String nameExpected = "MUSTARD";
        ingredient = new Ingredient(SAUCE, nameExpected, 200F);
        String nameActual = ingredient.getName();
        assertEquals("Должен видеть имя с буквами на верхнем регистре", nameExpected, nameActual);

    }

    @Test
    public void getName1letterShowName() {
        String nameExpected = "m";
        ingredient = new Ingredient(SAUCE, nameExpected, 200F);
        String nameActual = ingredient.getName();
        assertEquals("Должен видеть имя из 1 буквы", nameExpected, nameActual);

    }

    @Test(expected = OutOfMemoryError.class)
    public void getNameMaxLengthShowsOutOfMemoryError() {
        //Следует добавить ограничение на максимально возможную строку в имени ингридиента
        int textLength = Integer.MAX_VALUE;
        String nameExpected = RandomStringUtils.randomAlphabetic(textLength);
        ingredient = new Ingredient(SAUCE, nameExpected, 200F);

    }

    @Test
    public void getNameLengthIsMoreThan40000LettersShowsName() {
        //Следует добавить ограничение на максимально возможную строку в имени ингридиента
        int textLength = (int) Math.sqrt(Integer.MAX_VALUE);
        String nameExpected = RandomStringUtils.randomAlphabetic(textLength);
        ingredient = new Ingredient(SAUCE, nameExpected, 200F);
        String nameActual = ingredient.getName();
        assertEquals("Должен видеть имя из 46340 букв", nameExpected, nameActual);

    }

    @Test
    public void getNameSpecificSymbolsShowsName() {
        //Следует добавить ограничение на допустимые символы в имени ингридиента
        String nameExpected = RandomStringUtils.randomAscii(5);
        ingredient = new Ingredient(SAUCE, nameExpected, 200F);
        String nameActual = ingredient.getName();
        assertEquals("Должен видеть имя со спецсимволами", nameExpected, nameActual);

    }

    @Test
    public void getNameEmptyValueShowsName() {
        //Следует добавить ограничение на допустимые символы в имени ингридиента
        String nameExpected = RandomStringUtils.randomAscii(5);
        ingredient = new Ingredient(SAUCE, nameExpected, 200F);
        String nameActual = ingredient.getName();
        assertEquals("Должен видеть имя со спецсимволами", nameExpected, nameActual);

    }

    @Test
    public void getNameGapsOnlyValueShowsName() {
        //следует ограничить возможность создания объекта Ingridient, если имя содержит только пробелы
        String nameExpected = "     ";
        ingredient = new Ingredient(SAUCE, nameExpected, 200F);
        String nameActual = ingredient.getName();
        assertEquals("Должен видеть имя состоящее из пробелов", nameExpected, nameActual);

    }

    @Test
    public void getNameMoreThanOneGapInAMiddleShowsName() {
        //следует ограничить возможность создания объекта Ingridient, если имя содержит более 1 пробела между словами
        String nameExpected = "горчица  yellow";
        ingredient = new Ingredient(SAUCE, nameExpected, 200F);
        String nameActual = ingredient.getName();
        assertEquals("Должен видеть имя c более 1 пробелом в середине", nameExpected, nameActual);

    }

    @Test
    public void getNameStartsWithGapShowsName() {
        //следует ограничить возможность создания объекта Ingridient, если имя начинается с пробела
        String nameExpected = " горчица";
        ingredient = new Ingredient(SAUCE, nameExpected, 200F);
        String nameActual = ingredient.getName();
        assertEquals("Должен видеть имя, которое начинается с пробела", nameExpected, nameActual);

    }

    @Test
    public void getEndsWithGapShowsName() {
        //следует ограничить возможность создания объекта Ingredient, если имя заканчивается пробелом
        String nameExpected = "горчица ";
        ingredient = new Ingredient(SAUCE, nameExpected, 200F);
        String nameActual = ingredient.getName();
        assertEquals("Должен видеть имя, которое заканчивается пробелом", nameExpected, nameActual);

    }

    @Test
    public void getNameNullValueShowsName() {
        //следует ограничить возможность создания объекта Ingredient, если имя null
        ingredient = new Ingredient(SAUCE, null, 200F);
        String nameActual = ingredient.getName();
        assertThat("Должен видеть имя с null", nameActual, is(nullValue()));

    }

    @Test
    public void getTypeFillingShowsFilling() {
        ingredient = new Ingredient(FILLING, "горчица", 200F);
        assertEquals("Должен видеть имя, которое заканчивается пробелом", FILLING, ingredient.getType());

    }

    @Test
    public void getTypeSauceShowsSauce() {
        ingredient = new Ingredient(SAUCE, "горчица", 200F);
        assertEquals("Должен видеть имя, которое заканчивается пробелом", SAUCE, ingredient.getType());

    }

    @Test
    public void getTypeNullShowsNull() {
        //следует ограничить возможность создания объекта Ingredient, если тип null
        ingredient = new Ingredient(null, "горчица", 200F);
        assertThat("Должен видеть тип с null", ingredient.getType(), is(nullValue()));

    }

    @Test
    public void getPricePositiveIntegerNumberPositivePrice() {
        int expectedPrice = 100;
        ingredient = new Ingredient(SAUCE, "горчица", expectedPrice);
        float actualPrice = ingredient.getPrice();
        assertEquals("Должен видеть цену с положительным целым числом", expectedPrice, actualPrice, 0);
    }

    @Test
    public void getPricePositiveFloatNumberShowsPositivePrice() {
        float expectedPrice = 100.01F;
        ingredient = new Ingredient(SAUCE, "горчица", expectedPrice);
        float actualPrice = ingredient.getPrice();
        assertEquals("Должен видеть цену с положительным дробным числом", expectedPrice, actualPrice, 0);
    }

    @Test
    public void getPriceNegativeNumberShowsNegativePrice() {
        //следует ограничить возможность создания объекта с отрицательной ценой
        float negativePrice = -0.01F;
        ingredient = new Ingredient(SAUCE, "горчица", negativePrice);
        assertThat("Должен видеть отрицательную цену", ingredient.getPrice(), is(negativePrice));
    }

    @Test
    public void getPriceZeroNumberShowsZeroPrice() {
        //следует ограничить возможность создания объекта с нулевой ценой
        float expectedZeroPrice = 0F;
        ingredient = new Ingredient(SAUCE, "горчица", expectedZeroPrice);
        float actualPrice = ingredient.getPrice();
        assertEquals("Должен видеть цену 0", actualPrice, expectedZeroPrice, 0);
    }


}