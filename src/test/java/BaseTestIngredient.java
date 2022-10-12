import praktikum.Ingredient;
import praktikum.IngredientType;

public abstract class BaseTestIngredient {
    protected String name = "имя";
    protected float price = 100;
    protected IngredientType ingredientType = IngredientType.FILLING;

    Ingredient createIngredient() {
        return new Ingredient(ingredientType, name, price);
    }
}
