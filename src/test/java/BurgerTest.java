import org.junit.Test;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

// Some change to trigger pull request

public class BurgerTest {
    //Так как Jacoco не видит покрытие тествми двух функций черех моки, проводим боевое тестирование здесь.
    @Test
    public  void burgerRemoveIngredient(){
        Burger burger = new Burger();

        Ingredient ingredient = new Ingredient(IngredientType.SAUCE,"maionez",100F);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
    }
    @Test
    public  void burgerMoveIngredient(){
        Burger burger = new Burger();

        burger.addIngredient(new Ingredient(IngredientType.SAUCE,"maionez",100F));
        burger.addIngredient(new Ingredient(IngredientType.FILLING,"beefsteak",100F));
        burger.moveIngredient(0,1);
    }

}
