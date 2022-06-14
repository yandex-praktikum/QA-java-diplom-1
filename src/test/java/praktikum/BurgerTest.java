package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Burger burgerMock;
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient1;
    @Mock
    Ingredient ingredient2;
    @Mock
    Ingredient ingredient3;

    @Test
    public void setBunIsCorrect() {

        Burger burger = new Burger();
        burger.setBuns(bun);
        Assert.assertEquals(bun,burger.bun);
    }

    @Test
    public void setBunMockBurgerIsCorrect() {

        burgerMock.setBuns(bun);
        Mockito.verify(burgerMock).setBuns(bun);
        Mockito.verify(burgerMock, Mockito.times(1)).setBuns(bun);
    }

    @Test
    public void addIngredientBurgerIsCorrect() {

        burgerMock.addIngredient(ingredient1);
        burgerMock.addIngredient(ingredient2);

        Mockito.verify(burgerMock, Mockito.times(2)).addIngredient(Mockito.any());
    }

    @Test
    public void addIngredient0BurgerIsCorrect() {

        Mockito.verify(burgerMock, Mockito.times(0)).addIngredient(Mockito.any());
    }

    @Test
    public void addIngredientNTimesIsCorrect() {

        int n = 5;
        for (int i =0; i<n;i++) {
            burgerMock.addIngredient(ingredient1);
        }
        Mockito.verify(burgerMock, Mockito.times(n)).addIngredient(Mockito.any());
    }

    @Test
    public void addIngredientNTimes2SizeIsCorrect() {

        Burger burger = new Burger();

        int n = 5;
        for (int i =0; i<n;i++) {
            burger.addIngredient(ingredient1);
        }
        Assert.assertNotNull(burger);
        Assert.assertEquals(n,burger.ingredients.size());
    }


    @Test
    public void removeIngredientIsCorrect() {

        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        burger.removeIngredient(0);
        Assert.assertNotNull(burger);
        Assert.assertEquals(1,burger.ingredients.size());

    }


    @Test
    public void removeIngredient1IsCorrect() {

        Burger burger = new Burger();

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        burger.removeIngredient(burger.ingredients.indexOf(ingredient1));
        Assert.assertNotNull(burger);

        Assert.assertEquals(-1,burger.ingredients.indexOf(ingredient1));
    }

    @Test
    public void removeIngredient3IsCorrect() {

        Burger burger = new Burger();

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);

        burger.removeIngredient(burger.ingredients.indexOf(ingredient3));
        Assert.assertNotNull(burger);

        Assert.assertEquals(-1,burger.ingredients.indexOf(ingredient3));
    }

    @Test
    public void removeIngredient03IsCorrect() {

        Burger burger = new Burger();

        burger.addIngredient(ingredient1);

        burger.removeIngredient(burger.ingredients.indexOf(ingredient1));

        Assert.assertNotNull(burger);
        Assert.assertEquals(-1,burger.ingredients.indexOf(ingredient1));
        }

    @Test
    public void moveIngredientIsCorrect() {

        Burger burger = new Burger();

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);

        int expected = burger.ingredients.indexOf(ingredient3);

        burger.moveIngredient(burger.ingredients.indexOf(ingredient1),burger.ingredients.indexOf(ingredient3));

        Assert.assertNotNull(burger);
        Assert.assertEquals(expected,burger.ingredients.indexOf(ingredient1));
    }

    @Test
    public void moveIngredient1IsCorrect() {

        Burger burger = new Burger();

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        int expected = burger.ingredients.indexOf(ingredient2);

        burger.moveIngredient(burger.ingredients.indexOf(ingredient3),burger.ingredients.indexOf(ingredient2));

        Assert.assertNotNull(burger);
        Assert.assertEquals(expected,burger.ingredients.indexOf(ingredient3));
    }

    @Test
    public void moveIngredient2IsCorrect() {

        Burger burger = new Burger();

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);

        int expected = burger.ingredients.indexOf(ingredient1);

        burger.moveIngredient(burger.ingredients.indexOf(ingredient2),burger.ingredients.indexOf(ingredient1));

        Assert.assertNotNull(burger);
        Assert.assertEquals(expected,burger.ingredients.indexOf(ingredient2));
    }

    @Test
    public void getPriceTest() {

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        Mockito.when(bun.getPrice()).thenReturn(150f);
        Mockito.when(ingredient1.getPrice()).thenReturn(200f);
        Mockito.when(ingredient2.getPrice()).thenReturn(200f);
        float expected = 700;

        float actual = burger.getPrice();

        Assert.assertEquals(expected,actual,0.00f);
    }

    @Test
    public void getPriceWithoutIngredientsTest() {

        Burger burger = new Burger();
        burger.setBuns(bun);
        //burger.addIngredient(ingredient1);
        //burger.addIngredient(ingredient2);
        Mockito.when(bun.getPrice()).thenReturn(150f);
        //Mockito.when(ingredient1.getPrice()).thenReturn(200f);
        //Mockito.when(ingredient2.getPrice()).thenReturn(200f);
        float expected = 300;

        float actual = burger.getPrice();

        Assert.assertEquals(expected,actual,0.00f);
    }

    @Test
    public void getPriceWithDoubleIngredientsTest() {

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient1);
        Mockito.when(bun.getPrice()).thenReturn(150f);
        Mockito.when(ingredient1.getPrice()).thenReturn(200f);

        float expected = 700;

        float actual = burger.getPrice();

        Assert.assertEquals(expected,actual,0.00f);
    }

    @Test
    public void getReceiptTest() {

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);

        Mockito.when(bun.getName()).thenReturn("Ржаная булочка");
        Mockito.when(bun.getPrice()).thenReturn(150f);
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient1.getName()).thenReturn("Сырный соус");
        Mockito.when(ingredient1.getPrice()).thenReturn(200f);


        String receiptExpected = String.format("(==== Ржаная булочка ====)%n= sauce Сырный соус =%n(==== Ржаная булочка ====)%n%nPrice: 500,000000%n");
        String receipt = burger.getReceipt();


        Assert.assertEquals(receiptExpected,receipt);
    }

    @Test
    public void getReceipt2Test() {

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        Mockito.when(bun.getName()).thenReturn("Ржаная булочка");
        Mockito.when(bun.getPrice()).thenReturn(150f);
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient1.getName()).thenReturn("Барбекю");
        Mockito.when(ingredient1.getPrice()).thenReturn(50f);
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient2.getName()).thenReturn("Котлета");
        Mockito.when(ingredient2.getPrice()).thenReturn(200f);


        String receiptExpected = String.format("(==== Ржаная булочка ====)%n= sauce Барбекю =%n= filling Котлета =%n(==== Ржаная булочка ====)%n%nPrice: 550,000000%n");
        String receipt = burger.getReceipt();


        Assert.assertEquals(receiptExpected,receipt);
    }
    @Test
    public void getReceipt3Test() {

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);

        Mockito.when(bun.getName()).thenReturn("Ржаная булочка");
        Mockito.when(bun.getPrice()).thenReturn(150f);
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient1.getName()).thenReturn("Барбекю");
        Mockito.when(ingredient1.getPrice()).thenReturn(50f);
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient2.getName()).thenReturn("Котлета");
        Mockito.when(ingredient2.getPrice()).thenReturn(200f);
        Mockito.when(ingredient3.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient3.getName()).thenReturn("Сыр");
        Mockito.when(ingredient3.getPrice()).thenReturn(100f);


        String receiptExpected = String.format("(==== Ржаная булочка ====)%n= sauce Барбекю =%n= filling Котлета =%n= filling Сыр =%n(==== Ржаная булочка ====)%n%nPrice: 650,000000%n");
        String receipt = burger.getReceipt();


        Assert.assertEquals(receiptExpected,receipt);
    }

}
