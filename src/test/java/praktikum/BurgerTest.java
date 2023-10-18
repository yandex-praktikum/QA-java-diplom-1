package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.constants.Сonstants.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;
    @Mock
    private Ingredient sauce;
    @Mock
    private Ingredient filling;
    private Burger burger;


    @Before
    public void createNewInstance() {
        burger = new Burger();
    }

    @Test
    public void setBuns(){
        burger.setBuns(bun);
        assertEquals("Проверяем создание булочки", bun, burger.bun);
    }

    @Test
    public void addIngredient(){
        burger.addIngredient(ingredient);
        assertEquals("Проверяем добавление ингредиентов", List.of(ingredient), burger.ingredients);
    }

    @Test
    public void removeIngredient(){
        burger.addIngredient(ingredient);
        burger.removeIngredient(INDEX_0);
        assertEquals("Проверяем удаление ингредиентов", List.of(), burger.ingredients);
    }

    @Test
    public void moveIngredient(){
        burger.addIngredient(filling);
        burger.addIngredient(sauce);
        burger.moveIngredient(INDEX_0,NEW_INDEX_1);
        assertEquals("Проверяем перемещение ингредиентов", sauce, burger.ingredients.get(INDEX_0));
    }

    @Test
    public void getRecipe(){
        Mockito.when(bun.getName()).thenReturn(NAME_BLACK_BUN);
        Mockito.when(bun.getPrice()).thenReturn(PRICE_100_0f);
        burger.setBuns(bun);

        Mockito.when(ingredient.getType()).thenReturn(FILLING);
        Mockito.when(ingredient.getName()).thenReturn(NAME_FILLING_DINOSAUR);
        Mockito.when(ingredient.getPrice()).thenReturn(PRICE_200_0f);
        burger.addIngredient(ingredient);
        List<Ingredient> ingredients = burger.ingredients;

        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));

        for (Ingredient ingredient : ingredients) {
            receipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }

        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", burger.getPrice()));

        assertEquals("Проверяем рецепт", receipt.toString(), burger.getReceipt());
    }
}

