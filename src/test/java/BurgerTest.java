import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.hamcrest.CoreMatchers.allOf;

import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.hamcrest.CoreMatchers.containsString;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.notNullValue;



@RunWith(Parameterized.class)
public class BurgerTest {
    private Burger burger;
    private String bunName;
    private String ingredientName;
    private float bunPrice;
    private float ingredientPrice;
    private float burgerPrice;
    private float delta;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient secondIngredient;
    @Mock
     Bun bun;
    @Mock
    IngredientType type ;

    public BurgerTest(String bunName, String ingredientName, float bunPrice, float ingredientPrice, float burgerPrice, float delta) {
        this.bunName = bunName;
        this.ingredientName = ingredientName;
        this.bunPrice = bunPrice;
        this.ingredientPrice = ingredientPrice;
        this.burgerPrice = burgerPrice;
        this.delta = delta;
    }

    @Before
    public void setUp(){
        burger = new Burger();
        MockitoAnnotations.openMocks(this);
    }

    @After
    public void tearDown(){

        burger.ingredients.clear();

    }


    @Parameterized.Parameters
    public static Object[][] getBurger()
    {
        return new Object[][] {
                {"булочка с кунжутом", "соленый огурчик", 56.000000f, 80.000000f, 272.00000f, 0.03f},
                {"чесночная булочка", "жареный бекон", 80.003000f, 80.200000f, 320.40600f, 0.03f}
        };
    }


    @Test
    public void addIngredientInBurgerSuccess(){
        burger.addIngredient(ingredient);
        Assert.assertEquals("В списке ингредиентов должен быть хотя бы один элемент" ,false, burger.ingredients.isEmpty());
    }

    @Test
    public void removeIngredientInBurgerSuccess(){
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);

        Assert.assertEquals("Ингредиент должен быть удален из списка" ,false, burger.ingredients.contains(ingredient));

    }

    @Test
    public void moveIngredientInBurgerSuccess(){

        burger.ingredients.add(ingredient);
        burger.ingredients.add(secondIngredient);
        int index = 0;
        int newIndex = 1;
        burger.moveIngredient(index, newIndex);
        Assert.assertEquals( "Ингредиенты в списке должны поменяться местами",secondIngredient, burger.ingredients.get(0));
        Assert.assertEquals( "Ингредиенты в списке должны поменяться местами", ingredient, burger.ingredients.get(1));

    }

    @Test
    public void getPriceReturnPriceForIngredientAndBun(){
        burger.bun = bun;
        burger.ingredients.add(ingredient);
        burger.ingredients.add(ingredient);
        float actualPriceBun = bunPrice;
        float actualIngredient= ingredientPrice;
        float expectedPrice=burgerPrice;

        Mockito.when(bun.getPrice()).thenReturn(actualPriceBun);
        Mockito.when(ingredient.getPrice()).thenReturn(actualIngredient);

        Assert.assertEquals("Цена должна быть равна expectedPrice", expectedPrice, burger.getPrice(), delta);
    }

    @Test
    public void setBunsSuccess(){
        burger.setBuns(bun);
        MatcherAssert.assertThat(burger.bun, notNullValue());
    }

    @Test
    public void getReceiptReturnStringWithBunNameBunPriceIngredientNameIngredientPrice() {
        burger.bun = bun;
        burger.ingredients.add(ingredient);
        burger.ingredients.add(ingredient);

        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        Mockito.when(ingredient.getType()).thenReturn(type);
        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);
        Assert.assertEquals("В рецепте должен быть хотя бы один ингредиент" ,false, burger.getReceipt().isEmpty());
        MatcherAssert.assertThat(burger.getReceipt(), allOf(containsString(bunName), containsString(ingredientName)));
        MatcherAssert.assertThat(burger.getReceipt(), containsString(String.format("%nPrice: %f%n", burgerPrice)));


    }




}
