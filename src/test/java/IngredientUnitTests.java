import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Burger;
import praktikum.Database;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class IngredientUnitTests {
    private  final Burger burger = new Burger();
    private IngredientType expectedIngredientType = FILLING;
    private String expectedName = "dinosaur";
    private float expectedPrice = 200F;
    @Mock
    Database database;
    public List<Ingredient> ingredients = new ArrayList<>();
    @Before
    public void addIngredients() {
        ingredients.add(new Ingredient(SAUCE, "sour cream", 200));
        ingredients.add(new Ingredient(FILLING, "dinosaur", 200));
        Mockito.when(database.availableIngredients()).thenReturn(ingredients);
    }

    Ingredient ingredient = new Ingredient(
            expectedIngredientType,
            expectedName,
            expectedPrice
    );

    @Test
    public void getPrice() {
        MatcherAssert.assertThat(
                "Неверная стоимость ингредиента",
                ingredient.getPrice(),
                equalTo(expectedPrice)

        );
    }

    @Test
    public void getName() {
        MatcherAssert.assertThat(
                "Такого ингредиента не существует",
                ingredient.getName(),
                equalTo(expectedName)
        );
    }

    @Test
    public void getType() {
        MatcherAssert.assertThat(
                "Неверный тип ингредиента",
                ingredient.getType(),
                equalTo(expectedIngredientType)
        );
    }

    @Test
    public void addOneIngredient() {
        burger.addIngredient(database.availableIngredients().get(0));
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredient() {
        burger.addIngredient(database.availableIngredients().get(0));
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredient() {
        burger.addIngredient(database.availableIngredients().get(1));
        burger.addIngredient(database.availableIngredients().get(0));
        burger.moveIngredient(0,1);
        assertEquals(database.availableIngredients(), burger.ingredients);
    }
}

