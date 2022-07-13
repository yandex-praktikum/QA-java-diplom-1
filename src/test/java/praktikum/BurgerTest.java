package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class BurgerTest {
    private static final String BUN_NAME = "white bun";
    //private static final String BUN_NAME_BLACK = "black bun";
    private static final String INGREDIENT_NAME = "cutlet";
    //private static final String INGREDIENT_NAME_SAUCE = "sauce";
    private static final IngredientType INGREDIENT_TYPE = FILLING;
    //private static final IngredientType INGREDIENT_TYPE_SAUCE = SAUCE;
    //private static final String INGR_TYPE = "FILLING";
    private static final float BUN_PRICE = 200f;
    private static final float INGREDIENT_PRICE = 300f;

    @Mock
    static Bun whiteBun;
    @Mock
    static Bun blackBun;
    @Mock
    static Ingredient sourCreamIngredient;
    @Mock
    static Ingredient cutletIngredient;
    @Mock
    static Ingredient chiliSauceIngredient;

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1} {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {blackBun,
                    new ArrayList(){{
                        add(sourCreamIngredient);
                        add(cutletIngredient);
                        add(chiliSauceIngredient);
                    }},
                    2,
                    1},
                {whiteBun,
                    new ArrayList(){{
                        add(sourCreamIngredient);
                        add(cutletIngredient);
                        add(chiliSauceIngredient);
                    }},
                    2,
                    0},
                {blackBun,
                    new ArrayList(){{
                        add(sourCreamIngredient);
                        add(chiliSauceIngredient);
                    }},
                    1,
                    0}
        });
    }

    @Mock
    private Bun bun;
    private List<Ingredient> ingredients;

    private Burger burger;
    private int nowIndex;
    private int newIndex;

    public BurgerTest(Bun bun, List<Ingredient> ingredients, int nowIndex, int newIndex) {
        createStubBun();
        createStubIngredients(ingredients);
        this.burger = new Burger();
        this.burger.ingredients.addAll(ingredients);
        this.nowIndex = nowIndex;
        this.newIndex = newIndex;
    }

    @Before
    public void setUp(){
        burger = new Burger();
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

    private void createStubBun() {
        this.bun = Mockito.mock(Bun.class);
        Mockito.when(this.bun.getName()).thenReturn(BUN_NAME);
        Mockito.when(this.bun.getPrice()).thenReturn(BUN_PRICE);
    }

    private void createStubIngredients(List<Ingredient> ingredients) {
        this.ingredients = new ArrayList<>();
        for (Ingredient ingredient : ingredients) {
            Ingredient mockIngredient = Mockito.mock(Ingredient.class);
            Mockito.when(mockIngredient.getName()).thenReturn(INGREDIENT_NAME);
            Mockito.when(mockIngredient.getPrice()).thenReturn(INGREDIENT_PRICE);
            Mockito.when(mockIngredient.getType()).thenReturn(INGREDIENT_TYPE);
            this.ingredients.add(mockIngredient);
        }
    }
}