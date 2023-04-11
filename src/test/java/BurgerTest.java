import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.apache.commons.lang3.StringUtils;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Spy
    Burger burger;

    private Bun bun;
    private Ingredient ingredient;

    @Test
    public void burgerGetRecipeReturnsBuns(){
        bun = new Bun("Briosh", 2);
        burger.setBuns(bun);

        assertEquals("Булка не нашлась!",2, StringUtils.countMatches(burger.getReceipt(), bun.getName()));
    }

    @Test
    public void burgerGetRecipeReturnsIngredient(){
        bun = new Bun("Briosh", 2);
        ingredient = new Ingredient(IngredientType.SAUCE, "Catchup", 1);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        assertEquals("Ингредиент не нашелся!",1, StringUtils.countMatches(burger.getReceipt(), ingredient.getName()));
    }

    @Test
    public void burgerGetRecipeReturnsPrice(){
        bun = new Bun("Briosh", 2);
        ingredient = new Ingredient(IngredientType.SAUCE, "Catchup", 1);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        assertEquals("Цена булок посчиталась неверно!",1, StringUtils.countMatches(burger.getReceipt(), "5"));
    }

    @Test
    public void burgerGetPriceReturnsPrice(){
        bun = new Bun("Briosh", 2);
        ingredient = new Ingredient(IngredientType.FILLING, "SpaceMeat", 1);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        assertEquals("Цена посчиталась неправильно", 5, burger.getPrice(), 0);
    }

    @Test
    public void burgerRemoveIngredientRemovesIngredient(){
        bun = new Bun("Briosh", 2);
        ingredient = new Ingredient(IngredientType.SAUCE, "Catchup", 1);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.removeIngredient(1);

        assertEquals("Ингредиент не нашелся!",1, StringUtils.countMatches(burger.getReceipt(), ingredient.getName()));
    }

    @Test
    public void burgerMoveIngredientMovesIngredient(){
        bun = new Bun("Briosh", 2);
        ingredient = new Ingredient(IngredientType.SAUCE, "Catchup", 1);
        Ingredient ingredient2 = new Ingredient(IngredientType.SAUCE, "Mayonesse", 1);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);

        String oldRecipe = burger.getReceipt();
        burger.moveIngredient(0,1);

        assertNotEquals("Рецепты одинаковы, ингредиент не переместился", oldRecipe, burger.getReceipt());
    }

    @Test
    public void burgerReceiptFormatCheck(){
        bun = new Bun("Briosh", 2);
        ingredient = new Ingredient(IngredientType.SAUCE, "Catchup", 1);
        Ingredient ingredient2 = new Ingredient(IngredientType.SAUCE, "Mayonesse", 1);

        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(), ingredient.getName()));
        receipt.append(String.format("= %s %s =%n", ingredient2.getType().toString().toLowerCase(), ingredient2.getName()));
        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", bun.getPrice()*2+ingredient.getPrice()+ ingredient2.getPrice()));

        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);

        assertEquals("Рецепт составлен неправильно", receipt.toString(), burger.getReceipt());
    }
}
