package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Author: Alexey Bondarenko
 * Date: 03.06.2022
 */
@RunWith(Parameterized.class)
public class BunPriceParameterizedTest {

    private final List<Object> checkedData;
    private final String expected;

    public BunPriceParameterizedTest(List<Object> checkedData, String expected) {
        this.checkedData = checkedData;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Test data: {0}")
    public static Object[][] getData() {
        return new Object[][]{
                {List.of("Alex", -1F), "Error message"}, //выглядит как баг, отрицательная цена - странно, должна быть проверка на это
                {List.of("Alex", 0F), "Error message"}, // аналогично, возможный баг, я бы уточнил сходил
                {List.of("Alex", 999999999999999F), "Error message"}, // возможный баг, есть смысл ограничить верхнюю сумму для цены
                {List.of("", 9F), "Error message"}, // баг, пустое имя
                {List.of(" ", 9F), "Error message"}, // баг, имя не должно содержать пробелов
                {List.of("z\\xd0\\x98\\xcc\\x86\\xcc\\x88y", 9F), "Error message"}, // уточнил бы еще тут
                {List.of("!№;%:?*()", 9F), "Error message"} // уточнил бы еще тут по спецсимволам
        };
    }

    @Test
    public void checkMoveIngredientWithWrongIndex() {
        try {
            new Bun(checkedData.get(0).toString(), (float) checkedData.get(1));
        } catch (IndexOutOfBoundsException e) {
            assertEquals(expected, e.getMessage());
        }
    }
}
