package praktikum;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class IngredientTest {

    private final SoftAssertions softAssertions = new SoftAssertions();

    public IngredientType typeIngredient;
    public String expectedType;
    public String nameIngredient;
    public String expectedName;
    public float priceIngredient;
    public float expectedPrice;

    public IngredientTest(IngredientType typeIngredient,String expectedType, String nameIngredient
            , String expectedName, float priceIngredient,float expectedPrice){
        this.typeIngredient = typeIngredient;
        this.expectedType = expectedType;
        this.nameIngredient = nameIngredient;
        this.expectedName = expectedName;
        this.priceIngredient = priceIngredient;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters(name = "type {1}, name \"{3}\", price = {5}")
    public static Object[][] dataBun() {
        return new Object[][]{
                {IngredientType.SAUCE, "SAUCE", "питиаровое масло", "питиаровое масло", 300.09f, 300.09f},
                {IngredientType.SAUCE, "SAUCE", "vanilla sauce", "vanilla sauce", 10, 10},
                {IngredientType.FILLING, "FILLING", "salmon", "salmon", 250, 250},
                {IngredientType.FILLING, "FILLING", "барабулька", "барабулька", 1000.9f, 1000.9f},
        };
    }

    @Test
    public void ingredientTest(){
        Ingredient ingredient = new Ingredient(typeIngredient,nameIngredient,priceIngredient);
        softAssertions.assertThat(ingredient
                .getType().toString()).isEqualTo(expectedType);
        softAssertions.assertThat(ingredient
                .getName()).isEqualTo(expectedName);
        softAssertions.assertThat(ingredient
                .getPrice()).isEqualTo(expectedPrice);
        softAssertions.assertAll();
    }

}
