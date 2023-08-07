import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;

public class IngredientTest {

    String nameIngridient = "beef";
    float priceIngridient = 100f;
    IngredientType typeIngridient = FILLING ;

    @Test // проверка стоимости начинки
    public void getPriceTest(){
        Ingredient ingredient = new Ingredient(typeIngridient,nameIngridient,priceIngridient);
        assertEquals(priceIngridient,ingredient.getPrice(),0.00001);
    }

    @Test // проверка названия начинки
    public void getNameTest(){
        Ingredient ingredient = new Ingredient(typeIngridient,nameIngridient,priceIngridient);
        assertEquals(nameIngridient,ingredient.getName());
    }

    @Test // проверка типа начинки
    public void getTypeTest(){
        Ingredient ingredient = new Ingredient(typeIngridient,nameIngridient,priceIngridient);
        assertEquals(typeIngridient,ingredient.getType());
    }

}
