package praktikum.ingredienttype;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

@Epic(value = "Stellar Burgers")
@Feature(value = "Burger Receipt")
@Story(value = "Ingredient Type")
public class IngredientTypeTest {

    @Test
    @DisplayName("Ingredient Type SAUCE check")
    @Description("Ingredient Type SAUCE check ")
    public void ingredientTypeShouldBeSause() {
        Assert.assertEquals("Ingredient Type SAUCE incorrect", IngredientType.SAUCE.name(), "SAUCE");
    }

    @Test
    @DisplayName("Ingredient Type FILLING check")
    @Description("Ingredient Type FILLING check ")
    public void ingredientTypeShouldBeFilling() {
        Assert.assertEquals("Ingredient Type FILLING incorrect", IngredientType.FILLING.name(), "FILLING");
    }
}
