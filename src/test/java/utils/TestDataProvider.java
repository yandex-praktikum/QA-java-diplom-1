package utils;

import praktikum.Bun;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;

public class TestDataProvider {

    public static List<Bun> getDeFaultBuns() {
        return List.of(
                new Bun("test bun one", 155.35f),
                new Bun("test bun two", 155.35f)
        );
    }

    public static List<Ingredient> getDefaultIngredients() {
        return List.of(
                new Ingredient(IngredientType.FILLING, "test filling one", 260),
                new Ingredient(IngredientType.FILLING, "test filling two", 188.50f),
                new Ingredient(IngredientType.SAUCE, "test sauce one", 78.99f),
                new Ingredient(IngredientType.SAUCE, "test sauce two", 10.00f)
        );
    }

    public static String getDefaultReceipt() {
        return "(==== test bun one ====)" + System.lineSeparator() +
                "= filling test filling one =" + System.lineSeparator() +
                "= filling test filling two =" + System.lineSeparator() +
                "= sauce test sauce one =" + System.lineSeparator() +
                "= sauce test sauce two =" + System.lineSeparator() +
                "(==== test bun one ====)" + System.lineSeparator() +
                System.lineSeparator() + "Price: 848,190002" + System.lineSeparator();
    }
}
