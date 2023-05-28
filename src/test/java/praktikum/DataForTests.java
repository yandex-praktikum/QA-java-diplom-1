package praktikum;

public class DataForTests {
    public static final String BUN_NAME = "Космобулка";
    public static final float BUN_PRICE = 15F;

    public static final String INGREDIENT_TYPE_ONE = "SAUCE";
    public static final String INGREDIENT_ONE = "Супер острый";
    public static final float INGREDIENT_ONE_PRICE = 5F;
    public static final String INGREDIENT_TYPE_TWO = "FILLING";
    public static final String INGREDIENT_TWO = "Большая восстанавливающая сосиска";
    public static final float INGREDIENT_TWO_PRICE = 25F;

    public static final float BURGER_FULL_PRICE = (BUN_PRICE*2)+INGREDIENT_ONE_PRICE+INGREDIENT_TWO_PRICE;

    public static String gatherBurger(){
        StringBuilder fullBurger = new StringBuilder(String.format("(==== %s ====)%n", BUN_NAME));
        fullBurger.append(String.format("= %s %s =%n", INGREDIENT_TYPE_ONE.toString().toLowerCase(),INGREDIENT_ONE));
        fullBurger.append(String.format("= %s %s =%n", INGREDIENT_TYPE_TWO.toString().toLowerCase(),INGREDIENT_TWO));
        fullBurger.append(String.format("(==== %s ====)%n", BUN_NAME));
        fullBurger.append(String.format("%nPrice: %f%n", BURGER_FULL_PRICE));
        return fullBurger.toString();
    }




}
