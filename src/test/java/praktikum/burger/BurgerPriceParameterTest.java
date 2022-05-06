package praktikum.burger;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(Parameterized.class)
@Epic(value = "Stellar Burgers")
@Feature(value = "Burger Receipt")
@Story(value = "Burger Parameter Test")
public class BurgerPriceParameterTest {
    private Float bunPrice;
    private Float ingredientPrice;
    private Float expectedPrice;

    public BurgerPriceParameterTest(Float bunPrice, Float ingredientPrice, Float expectedPrice) {
        this.bunPrice = bunPrice;
        this.ingredientPrice = ingredientPrice;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {0f, 0f, 0f},
                {2f, 0f, 4f},
                {0f, 3f, 3f},
                {2f, 1f, 5f}
        };
    }

    @InjectMocks
        private Burger burger;
    @Mock
        private Bun bun;
    @Mock
        private Ingredient ingredient;
    @Before
        public void setup() {
        initMocks(this);
    }

    @Test
    @DisplayName("Getting price of the burger")
    @Description("Create the new burger with parameters and then get price of the burger")
    public void methodGetPriceShouldReturnBurgerPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        when(bun.getPrice()).thenReturn(bunPrice);
        when(ingredient.getPrice()).thenReturn(ingredientPrice);
        Float burgerPrice = burger.getPrice();

        Assert.assertEquals("Expected price does not match actual price", burgerPrice, expectedPrice);
    }
}
