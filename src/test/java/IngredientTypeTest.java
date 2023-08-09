import org.junit.Test;
import praktikum.IngredientType;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.is;

public class IngredientTypeTest {

    /**
    * Гугл говорит, что перечисления можно протестировать так:
    * https://stackoverflow.com/questions/1079700/how-to-test-enum-types
    * Не знаю насколько это применимо в нашем случае, но пусть будет так.
    */

    @Test
    public void checkFillingIsNotNull() {
        assertThat("Начинка отсутствует!", IngredientType.valueOf("FILLING"), is(notNullValue()));
    }

    @Test
    public void checkSauceIsNotNull() {
        assertThat("Соус отсутствует!", IngredientType.valueOf("SAUCE"), is(notNullValue()));
    }
}
