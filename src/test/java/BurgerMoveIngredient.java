import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)
public class BurgerMoveIngredient {
    private List<Ingredient>ingredients = new ArrayList<>();
    private int index;
    private int newIndex;
    private Ingredient newPos;
    private Ingredient oldPos;

    public BurgerMoveIngredient(List<Ingredient>ingredients,int index, int newIndex,Ingredient oldPos,Ingredient newPos){
        this.ingredients=ingredients;
        this.index=index;
        this.newIndex=newIndex;
        this.newPos=newPos;
        this.oldPos=oldPos;
    }
    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getData() {
        Ingredient ingredient0=new Ingredient(IngredientType.FILLING,"0",0);
        Ingredient ingredient1=new Ingredient(IngredientType.SAUCE  ,"1",1);
        Ingredient ingredient2=new Ingredient(IngredientType.FILLING,"2",2);
        List<Ingredient>ingredients = new ArrayList<>();
        ingredients.add(ingredient0);
        ingredients.add(ingredient1);
        ingredients.add(ingredient2);
        return new Object[][] {
                { ingredients, 0, 1, ingredient1,ingredient0},
                { ingredients, 0, 2, ingredient2,ingredient0},
                { ingredients, 1, 0, ingredient0, ingredient1},
                { ingredients, 1, 2, ingredient2, ingredient1}
        };
    }
    @Test
    public void testThatIngredientWasRemoved(){
        Burger burger = new Burger();
        burger.ingredients=ingredients;
        burger.moveIngredient(index,newIndex);
        System.err.println(burger.ingredients);
        assertEquals("Перемещение",newPos,burger.ingredients.get(newIndex));
        assertEquals("Перемещение",oldPos,burger.ingredients.get(index));

        //assertEquals("Ингредиент удалён",0,burger.ingredients.size());
    }
}
