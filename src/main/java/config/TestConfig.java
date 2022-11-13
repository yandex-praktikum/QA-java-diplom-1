package config;

import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.FILLING;

public class TestConfig {


    protected final static float GET_PRICE_EXPECTED = 700f;

    protected final static String GET_RECEIPT_EXPECTED = "(==== black bun ====)\r\n" +
            "= filling cutlet =\r\n" +
            "(==== black bun ====)\r\n" +
            "\r\n" +
            "Price: 200,000000\r\n";

    protected final static Ingredient REMOVE_INGREDIENT_EXPECTED =  new Ingredient(IngredientType.FILLING, "cutlet", 100);

    protected final static Ingredient MOVE_INGREDIENT_EXPECTED =  new Ingredient(IngredientType.SAUCE, "sour cream", 200);


    protected final static String GET_RECEIPT_PARAM_1_EXPECTED = "(==== black bun ====)\r\n" +
            "= sauce hot sauce =\r\n" +
            "(==== black bun ====)\r\n" +
            "\r\n" +
            "Price: 200,000000\r\n";
    protected final static String GET_RECEIPT_PARAM_2_EXPECTED = "(==== black bun ====)\r\n" +
            "= sauce sour cream =\r\n" +
            "(==== black bun ====)\r\n" +
            "\r\n" +
            "Price: 300,000000\r\n";

    protected final static String GET_RECEIPT_PARAM_3_EXPECTED ="(==== black bun ====)\r\n" +
            "= sauce chili sauce =\r\n" +
            "(==== black bun ====)\r\n" +
            "\r\n" +
            "Price: 400,000000\r\n";

    protected final static String GET_RECEIPT_PARAM_4_EXPECTED = "(==== black bun ====)\r\n" +
            "= filling cutlet =\r\n" +
            "(==== black bun ====)\r\n" +
            "\r\n" +
            "Price: 200,000000\r\n";

    protected final static String GET_RECEIPT_PARAM_5_EXPECTED = "(==== black bun ====)\r\n" +
            "= filling dinosaur =\r\n" +
            "(==== black bun ====)\r\n" +
            "\r\n" +
            "Price: 300,000000\r\n";

    protected final static String GET_RECEIPT_PARAM_6_EXPECTED = "(==== black bun ====)\r\n" +
            "= filling sausage =\r\n" +
            "(==== black bun ====)\r\n" +
            "\r\n" +
            "Price: 400,000000\r\n";
}
