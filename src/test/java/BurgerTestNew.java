import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;


import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTestNew {
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;

    Burger burger = new Burger();
    Ingredient [] ingredients = new Ingredient[] {
            new Ingredient(SAUCE, "Традиционный галактический", 15),
            new Ingredient(FILLING, "Говяжий метеорит", 3000),
            new Ingredient(FILLING, "Магнолия", 323),
            new Ingredient(SAUCE, "Сыр с астероидной плесенью", 4152),
    };


    @Test
    public void setBunsTest() {
        burger.setBuns(new Bun("Флюоресцентная булка", 209));
        assertEquals("Наименование не соответствует ожидаемому","Флюоресцентная булка", burger.bun.getName());
        assertEquals("Цена не соответствует ожидаемой",209, burger.bun.getPrice(), 0.001);
    }

    @Test
    public void addIngredientsTest() {
        for (int i = 0; i < ingredients.length; i++) {
            burger.addIngredient(ingredients[i]);
            assertEquals("Количество не соответствует ожидаемому",ingredients[i], burger.ingredients.get(i));
        }
    }

    @Test
    public void removeIngredientTest() {
        int count;
        for (int i = 0; i < ingredients.length; i++) {
            burger.addIngredient(ingredients[i]);
        }
        count=ingredients.length-1;
        burger.removeIngredient(0);
        assertEquals("Количество не соответствует ожидаемому",count, burger.ingredients.size());
    }

    @Test
    public void moveIngredientInIngredientList() {
        for (int i = 0; i < ingredients.length; i++) {
            burger.addIngredient(ingredients[i]);
        }
        burger.moveIngredient(0, 3);
        assertEquals("Позиция не соответствует ожидаемой", ingredients[1], burger.ingredients.get(0));
       assertEquals("Позиция не соответствует ожидаемой",ingredients[2], burger.ingredients.get(1));
    }

    @Test
    public void getPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(120F);
        Mockito.when(ingredient.getPrice()).thenReturn(130F);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float actual = burger.getPrice();
        float expected = 370;
        assertEquals("Цена не соответствует ожидаемой", expected, actual, 0.001);
    }

    @Test
    public void getReceipt()  {
        for (int i = 0; i < ingredients.length; i++) {
            burger.addIngredient(ingredients[i]);
        }
        burger.setBuns(new Bun("Булка", 250));
        final String expected = "(==== Булка ====)\r\n" +
        "= sauce Традиционный галактический =\r\n" +
                "= filling Говяжий метеорит =\r\n" +
                "= filling Магнолия =\r\n" +
                "= sauce Сыр с астероидной плесенью =\r\n" +
                "(==== Булка ====)\r\n" +
                "\r\n" +
                "Price: 7990,000000\r\n";
        final String actual = burger.getReceipt();
        assertEquals("Рецепт отличается от ожидаемого", expected,actual);
    }

}