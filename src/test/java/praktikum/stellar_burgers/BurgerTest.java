package praktikum.stellar_burgers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    Burger burger = new Burger();
    Ingredient [] ingredients = new Ingredient[] {
            new Ingredient(SAUCE, "hot sauce", 100),
            new Ingredient(SAUCE, "sour cream", 200),
            new Ingredient(SAUCE, "chili sauce", 300),
            new Ingredient(FILLING, "cutlet", 100),
            new Ingredient(FILLING, "dinosaur", 200),
            new Ingredient(FILLING, "sausage", 300)
    };

    @Test
    public void setBunsTest() {
        burger.setBuns(new Bun("Bun", 60));
        assertEquals("Bun", burger.bun.getName());
        assertEquals(60, burger.bun.getPrice(), 0);
    }

    @Test
    public void addIngredientsToIngredientList() {
        for (int i = 0; i < ingredients.length; i++) {
            burger.addIngredient(ingredients[i]);
            assertEquals("Ингредиент отличается от ожидаемого",
                    ingredients[i], burger.ingredients.get(i));
        }
    }

    @Test
    public void removeIngredientFromIngredientList() {
        for (Ingredient value : ingredients) {
            burger.addIngredient(value);
        }
        burger.removeIngredient(5);
        assertEquals("Ингредиентов больше, чем должно быть",
                5, burger.ingredients.size());
    }

    @Test
    public void moveIngredientInIngredientList() {
        for (Ingredient value : ingredients) {
            burger.addIngredient(value);
        }
        burger.moveIngredient(0, 5);
        burger.moveIngredient(4, 0);
        assertEquals("Порядок ингредиентов отличается от ожидаемого",
                ingredients[0], burger.ingredients.get(5));
        assertEquals("Порядок ингредиентов отличается от ожидаемого",
                ingredients[5], burger.ingredients.get(0));
    }

    @Test
    public void getPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(30F);
        Mockito.when(ingredient.getPrice()).thenReturn(10F);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float actual = burger.getPrice();
        float expected = 70;
        assertEquals("Цена бургера не соответствует ожидаемой", expected, actual, 0);
    }

    @Test
    public void getReceipt() throws IOException {
        String reference = Files.readString(Paths.get("src/main/java/praktikum/Receipt"));
        for (Ingredient value : ingredients) {
            burger.addIngredient(value);
        }
        burger.setBuns(new Bun("Половинка свежей булочки", 30));
        String actual = burger.getReceipt();
        assertEquals("Рецепт отличается от ожидаемого", reference, actual);
    }

}