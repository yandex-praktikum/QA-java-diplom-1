import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import praktikum.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CheckBurgerTest {
    static Database database = Mockito.mock(Database.class);

    static List<Ingredient> mockedIngredients = new ArrayList<Ingredient>() {{
        add(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        add(new Ingredient(IngredientType.FILLING, "dinosaur", 120));
        add(new Ingredient(IngredientType.SAUCE, "test sauce", 130));
    }};
    static List<Bun> mockedBuns = new ArrayList<Bun>() {{
        add(new Bun("test bun", 100));
    }};
    Burger burger = new Burger();

    private float calculateBurgerPrice(List<Ingredient> ingredients, Bun bun) {
        float price = bun.price * 2;
        for (Ingredient ingredient : ingredients) {
            price += ingredient.price;
        }
        return price;

    }

    @BeforeEach
    void setup() {
        Mockito.when(database.availableIngredients()).thenReturn(mockedIngredients);
        Mockito.when(database.availableBuns()).thenReturn(mockedBuns);
    }

    @Test
    void setBunsTest() {
        burger.setBuns(database.availableBuns().get(0));
        assertEquals(database.availableBuns().get(0), burger.bun);
    }

    public static Object[][] ingredientData() {
        return new Object[][]{
                {new ArrayList<Ingredient>() {{
                    add(mockedIngredients.get(0));
                }}
                },
                {new ArrayList<Ingredient>() {{
                    add(mockedIngredients.get(1));
                }}
                },
                {new ArrayList<Ingredient>() {{
                    add(mockedIngredients.get(0));
                    add(mockedIngredients.get(1));
                }}
                },
                {new ArrayList<Ingredient>()
                },
        };
    }

    @ParameterizedTest
    @MethodSource("ingredientData")
    void addIngredientTest(List<Ingredient> ingredients) {
        for (Ingredient ingredient : ingredients) {
            burger.addIngredient(ingredient);
        }
        assertEquals(ingredients, burger.ingredients);
    }

    @Test
    void removeIngredientTest() {
        List<Ingredient> ExpectedIngredients = new ArrayList<>();

        burger.addIngredient(database.availableIngredients().get(0));
        burger.addIngredient(database.availableIngredients().get(1));

        ExpectedIngredients.add(mockedIngredients.get(0));

        burger.removeIngredient(1);

        assertArrayEquals(ExpectedIngredients.toArray(), burger.ingredients.toArray());
    }

    @Test
    void moveIngredientTest() {
        List<Ingredient> ExpectedIngredients = new ArrayList<>();

        burger.addIngredient(database.availableIngredients().get(0));
        burger.addIngredient(database.availableIngredients().get(1));
        burger.addIngredient(database.availableIngredients().get(2));

        ExpectedIngredients.add(mockedIngredients.get(0));
        ExpectedIngredients.add(mockedIngredients.get(2));
        ExpectedIngredients.add(mockedIngredients.get(1));

        burger.moveIngredient(1, 2);
        assertArrayEquals(ExpectedIngredients.toArray(), burger.ingredients.toArray());
    }

    public static Object[][] burgerData() {
        return new Object[][]{
                {
                        mockedBuns.get(0),
                        new ArrayList<Ingredient>() {{
                            add(mockedIngredients.get(0));
                        }}

                },
                {
                        mockedBuns.get(0),
                        new ArrayList<Ingredient>()
                },
                {
                        new Bun("test bun", 0),
                        new ArrayList<Ingredient>() {{
                            add(mockedIngredients.get(0));
                            add(mockedIngredients.get(1));
                            add(mockedIngredients.get(2));
                        }}
                },
        };
    }

    @ParameterizedTest
    @MethodSource("burgerData")
    void getReceiptTest(Bun bun, List<Ingredient> ingredients) {
        burger.ingredients.addAll(ingredients);
        burger.bun = bun;

        StringBuilder expectedReceipt = new StringBuilder(String.format("(==== %s ====)\n", bun.getName()));
        for (Ingredient ingredient : ingredients) {
            expectedReceipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }
        expectedReceipt.append(String.format("(==== %s ====)\n", bun.getName()));
        expectedReceipt.append(String.format("\nPrice: %f\n", calculateBurgerPrice(ingredients, bun)));
        assertEquals(expectedReceipt.toString(), burger.getReceipt());
    }

    @ParameterizedTest
    @MethodSource("burgerData")
    void getPriceTest(Bun bun, List<Ingredient> ingredients) {
        Burger burger = new Burger();
        burger.ingredients.addAll(ingredients);

        if (bun != null) {
            burger.setBuns(bun);
        }
        assertEquals(calculateBurgerPrice(ingredients, bun), burger.getPrice());
    }
}


