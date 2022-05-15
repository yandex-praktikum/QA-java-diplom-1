import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class BurgerTest<expectedReceipt> {

    @Test
    void setBunsTest() {
       Burger burger=new Burger();
       Bun bun = Mockito.mock(Bun.class);
       burger.setBuns(bun);
       assertEquals(bun,burger.bun);
    }

    @Test
    void addIngredientTest() {
        Burger burger=new Burger();
        Ingredient ingredient = Mockito.mock(Ingredient.class);
        burger.addIngredient(ingredient);
        assertEquals(List.of(ingredient),burger.ingredients);
    }

    @Test
    void removeIngredientTest() {
        Burger burger=new Burger();
        List<Ingredient> ExpectedIngredients = new ArrayList<>();

        Ingredient firstIngredient=new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        Ingredient secondIngredient=new Ingredient(IngredientType.SAUCE, "test sauce", 120);
        burger.ingredients.add(firstIngredient);
        burger.ingredients.add(secondIngredient);

        ExpectedIngredients.add(firstIngredient);

        burger.removeIngredient(1);

        assertArrayEquals(ExpectedIngredients.toArray(),burger.ingredients.toArray());
    }



    @Test
    void moveIngredientTest() {
        Burger burger=new Burger();
        List<Ingredient> ExpectedIngredients = new ArrayList<>();
        Ingredient firstIngredient=new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        Ingredient secondIngredient=new Ingredient(IngredientType.SAUCE, "cold sauce", 120);
        Ingredient thirdIngredient=new Ingredient(IngredientType.SAUCE, "test sauce", 130);

        burger.ingredients.add(firstIngredient);
        burger.ingredients.add(secondIngredient);
        burger.ingredients.add(thirdIngredient);

        ExpectedIngredients.add(firstIngredient);
        ExpectedIngredients.add(thirdIngredient);
        ExpectedIngredients.add(secondIngredient);

        burger.moveIngredient(1,2);
        assertArrayEquals(ExpectedIngredients.toArray(),burger.ingredients.toArray());
    }

    @Test
    void getReceiptTest() {
        Burger burger=new Burger();
        Bun bun =new Bun("black bun", 100);

        Ingredient firstIngredient=new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        Ingredient secondIngredient=new Ingredient(IngredientType.FILLING, "dinosaur", 120);

        burger.ingredients.add(firstIngredient);
        burger.ingredients.add(secondIngredient);
        burger.setBuns(bun);

        String expectedReceipt="(==== black bun ====)\n"+ "= sauce hot sauce =\n"+ "= filling dinosaur =\n"
                +"(==== black bun ====)\n"
               // +"\n"
                +"\n"+ "Price: 420,000000\n";
        assertEquals(expectedReceipt, burger.getReceipt());
    }


    public static Object[][] params() {
        return new Object[][]{
                {
                        new Bun("black bun", 100),
                        new ArrayList<Ingredient>(){{
                            add(new Ingredient(IngredientType.SAUCE, "hot sauce", 140));
                        }},
                        340.0
                },
                {
                        new Bun("test bun", 110),
                        new ArrayList<Ingredient>(),
                        220.0
                },
                {
                        new Bun("test bun", 0),
                        new ArrayList<Ingredient>(){{
                            add(new Ingredient(IngredientType.SAUCE, "hot sauce", 140));
                            add(new Ingredient(IngredientType.FILLING, "cutlet", 100));
                            add(new Ingredient(IngredientType.SAUCE, "cold sauce", 150));
                        }},

                        390.0
                },


        };
    }

    @ParameterizedTest
    @MethodSource("params")
    void getPriceTest(Bun bun, List<Ingredient> ingredients, double expPrice) {
        Burger burger=new Burger();

        for (Ingredient ingredient: ingredients) {
            burger.ingredients.add(ingredient);
        }

        if (bun != null){
            burger.setBuns(bun);
        }

        System.out.println(burger.getPrice());
        assertEquals(expPrice, burger.getPrice());
    }

}