package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class BurgerTest {

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1} {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new Bun("black bun", 100),
                    new ArrayList(){{
                        add(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
                        add(new Ingredient(IngredientType.FILLING, "cutlet", 100));
                        add(new Ingredient(IngredientType.SAUCE, "chili sauce", 300));
                    }},
                    2,
                    1},
                {new Bun("white bun", 200),
                    new ArrayList(){{
                            add(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
                            add(new Ingredient(IngredientType.FILLING, "cutlet", 100));
                            add(new Ingredient(IngredientType.SAUCE, "chili sauce", 300));
                    }},
                    2,
                    0},
                {new Bun("black bun", 100),
                    new ArrayList(){{
                        add(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
                            add(new Ingredient(IngredientType.SAUCE, "chili sauce", 300));
                    }},
                    1,
                    0}
        });
    }
    private Bun bun;
    private List<Ingredient> ingredients;
    private Burger burger;
    private int nowIndex;
    private int newIndex;

    public BurgerTest(Bun bun, List<Ingredient> ingredients, int nowIndex, int newIndex) {
        createStubBun(bun);
        createStubIngredients(ingredients);
        this.burger = new Burger();
        this.burger.ingredients.addAll(ingredients);
        this.nowIndex = nowIndex;
        this.newIndex = newIndex;
    }

    @Before
    public void setUp(){
        burger.setBuns(bun);
        burger.getIngredients().clear();
        burger.getIngredients().addAll(ingredients);
    }

    @Test
    public void setBuns() {
        assertEquals(bun, burger.getBun());
    }

    @Test
    public void addIngredient() {
        assertEquals(ingredients, burger.getIngredients());
    }

    @Test
    public void removeIngredient() {
        List<Ingredient> ingredientList = new ArrayList<>(){{addAll(burger.getIngredients());}};
        ingredientList.remove(0);
        burger.removeIngredient(0);
        assertEquals(ingredientList, burger.getIngredients());
    }

    @Test
    public void moveIngredient() {
        ingredients.add(newIndex, ingredients.remove(nowIndex));
        burger.moveIngredient(nowIndex, newIndex);
    }

    @Test
    public void getPrice() {
        float price = burger.getPrice();
        float ingredientPrice = burger.getIngredients().stream()
                .map(Ingredient::getPrice)
                .reduce((aFloat, aFloat2) -> aFloat+=aFloat2).get();
        float expectedPrice = burger.getBun().getPrice() * 2 + ingredientPrice;
        assertEquals(expectedPrice, price, 0);
    }

    @Test
    public void getReceipt() {
        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));

        ingredients.forEach(ingredient ->
            receipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName())));

        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", burger.getPrice()));

        assertEquals(receipt.toString(), burger.getReceipt());
    }

    private void createStubBun(Bun bun) {
        this.bun = Mockito.mock(Bun.class);
        Mockito.when(this.bun.getName()).thenReturn(bun.getName());
        Mockito.when(this.bun.getPrice()).thenReturn(bun.getPrice());
    }

    private void createStubIngredients(List<Ingredient> ingredients) {
        this.ingredients = new ArrayList<>();
        for (Ingredient ingredient : ingredients) {
            Ingredient mockIngredient = Mockito.mock(Ingredient.class);
            Mockito.when(mockIngredient.getName()).thenReturn(ingredient.getName());
            Mockito.when(mockIngredient.getPrice()).thenReturn(ingredient.getPrice());
            Mockito.when(mockIngredient.getType()).thenReturn(ingredient.getType());
            this.ingredients.add(mockIngredient);
        }
    }
}