package praktikum;

public class BunAndIngredientsPrices {
    public static final float BUN_PRICE = 5.0f;
    public static final float INGREDIENT_1_PRICE = 10.0f;
    public static final float INGREDIENT_2_PRICE = 20.0f;
    public static final float INGREDIENT_3_PRICE = 30.0f;

    public static float countPriceOfBurger() {
        return BUN_PRICE * 2 + INGREDIENT_1_PRICE + INGREDIENT_2_PRICE + INGREDIENT_3_PRICE;
    }

    public static float countPriceOfBurgerWithoutSecondIngredient() {
        return BUN_PRICE * 2 + INGREDIENT_1_PRICE + INGREDIENT_3_PRICE;
    }
}
