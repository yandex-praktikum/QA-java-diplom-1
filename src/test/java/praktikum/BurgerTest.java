package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;



@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {


    @Test
    public void setBuns() {
        Burger burger = new Burger();
        Bun bun = new Bun("Зерновой хлеб", 900F);

        Bun actual = burger.setBuns(bun);
        assertEquals(bun, actual);
    }

    @Test
    public void addIngredient() {
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "cutlet", 100);

        burger.addIngredient(ingredient);
        assertEquals(ingredient, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredient() {
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "cutlet", 100);

        burger.ingredients.add(0, ingredient);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredient() {
        Burger burger = new Burger();
        Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, "cutlet", 100);
        Ingredient ingredient2 = new Ingredient(IngredientType.SAUCE, "sour cream", 200);

        burger.ingredients.add(0, ingredient1);
        burger.ingredients.add(1, ingredient2);
        burger.moveIngredient(0, 1);
        assertEquals(ingredient2, burger.ingredients.get(0));
    }


    @Spy
    Burger burger;

    @Test
    public void getPrice() throws Exception {
        burger.setBuns(new Bun("Kolobok", 250F));

        Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, "cutlet", 100F);
        Ingredient ingredient2 = new Ingredient(IngredientType.SAUCE, "sour cream", 200F);
        burger.ingredients.add(0, ingredient1);
        burger.ingredients.add(1, ingredient2);

        float actual = burger.getPrice();
        float expected = 800F;
        assertEquals(expected, actual, 0.0F);
    }


    @Test
    public void getReceipt()  {

        burger.setBuns(new Bun("Колобок", 300F));

        Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, "по сусекам поскреби!", 100F);
        Ingredient ingredient2 = new Ingredient(IngredientType.SAUCE, "по амбару помети!", 200F);
        burger.ingredients.add(0, ingredient1);
        burger.ingredients.add(1, ingredient2);
        Mockito.when(burger.getPrice()).thenReturn(700F);

            String actual = burger.getReceipt().trim();
            String expected = String.format("(==== Колобок ====)%n"
                    + "= filling по сусекам поскреби! =%n"
                    + "= sauce по амбару помети! =%n"
                    + "(==== Колобок ====)%n"
                    + "%n" + "Price: 700,000000");

            assertEquals(expected, actual);
        }

    }
