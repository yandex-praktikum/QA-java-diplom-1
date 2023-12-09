import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerParameterizedTest {
    private final List<Ingredient> ingredients;
    private final Bun bun;
    private final float expectedPrice;
    private Burger burger;

    // Constructor to handle parameterized test data
    public BurgerParameterizedTest(List<Ingredient> ingredients, Bun bun, float expectedPrice) {
        this.ingredients = ingredients;
        this.bun = bun;
        this.expectedPrice = expectedPrice;
    }

    // Define parameters for the tests
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {


                {
                        Arrays.asList(
                                new Ingredient(IngredientType.SAUCE, "hot sauce", 100),
                                new Ingredient(IngredientType.FILLING, "cutlet", 100)
                        ),
                        new Bun("black bun", 100),
                        400 // Expected price: 100 (bun) * 2 + 100 (hot sauce) + 100 (cutlet)
                },

                {
                        Arrays.asList(
                                new Ingredient(IngredientType.SAUCE, "sour cream", 200),
                                new Ingredient(IngredientType.FILLING, "dinosaur", 200)
                        ),
                        new Bun("white bun", 200),
                        800 // Expected price: 200 (bun) * 2 + 200 (sour cream) + 200 (dinosaur)
                },

                {
                        Arrays.asList(
                                new Ingredient(IngredientType.SAUCE, "chili sauce", 300),
                                new Ingredient(IngredientType.FILLING, "sausage", 300)
                        ),
                        new Bun("red bun", 300),
                        1200 // Expected price: 300 (bun) * 2 + 300 (chili sauce) + 300 (sausage)
                },
                // More test cases can be added as needed
        });
    }

    // Set up the Burger object before each test
    @Before
    public void setUp() {
        // Arrange
        burger = new Burger();
        burger.setBuns(bun);
        for (Ingredient ingredient : ingredients) {
            burger.addIngredient(ingredient);
        }
    }
    @Test
    public void testGetPrice() {
        // Act
        float actualPrice = burger.getPrice();

        System.out.println(expectedPrice);
        System.out.println(actualPrice);
        // Assert
        assertEquals("The price calculated by the Burger class should match the expected price.", expectedPrice, actualPrice, 0.01f);
    }
}
