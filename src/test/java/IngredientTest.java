import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {

    Ingredient testIngredientSauce = new Ingredient(SAUCE, "Szechuan Sauce", 110);
    Ingredient testIngredientFilling = new Ingredient(FILLING, "SzechuanNotSauce", 109.9f);


    @Test
    public void ingredientSauceGetTypeTest() {
        Assert.assertEquals(
                "Тип ингредиентов барахлит",
                SAUCE,
                testIngredientSauce.getType());
    }

    @Test
    public void ingredientSauceGetNameTest() {
        Assert.assertEquals(
                "Имя ингредиента передает сигнал бедствия",
                "Szechuan Sauce",
                testIngredientSauce.getName());
    }

    @Test
    public void ingredientSauceGetPriceTest() {
        Assert.assertEquals(
                "Наблюдаются неполадки у цены ингредиента",
                110,
                testIngredientSauce.getPrice(),
                0);
    }

    @Test
    public void ingredientFillingGetTypeTest() {
        Assert.assertEquals(
                "Тип ингредиентов барахлит",
                FILLING,
                testIngredientFilling.getType());
    }

    @Test
    public void ingredientFillingGetNameTest() {
        Assert.assertEquals(
                "Имя ингредиента передает сигнал бедствия",
                "SzechuanNotSauce",
                testIngredientFilling.getName());
    }

    @Test
    public void ingredientFillingGetPriceTest() {
        Assert.assertEquals(
                "Наблюдаются неполадки у цены ингредиента",
                109.9f,
                testIngredientFilling.getPrice(),
                0);
    }

}

