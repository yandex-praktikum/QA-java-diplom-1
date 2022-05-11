package praktikum;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static java.lang.String.format;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerGetReceiptTest {

    String nameBun;
    String nameIngredient;
    IngredientType type;
    float priceBurger;
    Burger burger = new Burger();

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Test
    public void getPrice() {
        Mockito.when(bun.getName()).thenReturn(nameBun = RandomStringUtils.randomAlphabetic(8));
        burger.setBuns(bun);
        Mockito.when(ingredient.getName()).thenReturn(nameIngredient = RandomStringUtils.randomAlphabetic(8));
        int ingredientTypeChoice = RandomUtils.nextInt(0, 2);
        if (ingredientTypeChoice == 0) {
            type = SAUCE;
        } else {
            type = FILLING;
        }
        Mockito.when(ingredient.getType()).thenReturn(type);
        int ingredientsAmount = RandomUtils.nextInt(1, 5);
        for (int i = 1; i <= ingredientsAmount; i++) {
            burger.addIngredient(ingredient);
        }
        Mockito.when(burger.getPrice()).thenReturn(priceBurger = RandomUtils.nextInt(5, 500));

        assertThat(burger.getReceipt(), containsString(format("(==== %s ====)%n", nameBun)));
        assertThat(burger.getReceipt(), containsString(nameIngredient));
        assertThat(burger.getReceipt(), containsString(format("%nPrice: %f%n", burger.getPrice())));
    }

}
