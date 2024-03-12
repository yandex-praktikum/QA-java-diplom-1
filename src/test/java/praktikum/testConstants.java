package praktikum;

public class testConstants {
    public static final String BUN_FOR_BURGER = "white bun";
    public static final String SAUCE_FOR_BURGER = "sauce";
    public static final String FILLING_FOR_BURGER = "filling";
    public static final String EXPECTED_RECEIPT = "(==== white bun ====)\r\n" + "= sauce sauce =\r\n" + "= filling filling =\r\n" + "(==== white bun ====)\r\n" + "\r\nPrice: 40,000000\r\n";
    public static final float BUN_PRICE = 5F;
    public static final float FIRST_INGREDIENT_PRICE = 10F;
    public static final float SECOND_INGREDIENT_PRICE = 20F;
    public static final float BURGER_SUM_PRICE = BUN_PRICE+ BUN_PRICE + FIRST_INGREDIENT_PRICE + SECOND_INGREDIENT_PRICE;
}