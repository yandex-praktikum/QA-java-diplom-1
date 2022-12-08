package praktikum;

public class Generator {

    final static String BUN_TEST_NAME = "Test bun";
    final static float BUN_TEST_PRICE = 123.45F;

    final  static String INGREDIENT_TEST_NAME = "Test ingredient";
    final static float INGREDIENT_TEST_PRICE = 543.21F;
    final static IngredientType INGREDIENT_TEST_TYPE = IngredientType.SAUCE;

    public static Bun getDefaultBun() {
        return new Bun(BUN_TEST_NAME, BUN_TEST_PRICE);
    }

    public static Ingredient getDefaultIngredient() {
        return new Ingredient(INGREDIENT_TEST_TYPE, INGREDIENT_TEST_NAME, INGREDIENT_TEST_PRICE);
    }
}
