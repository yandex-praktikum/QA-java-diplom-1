package praktikum;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BurgerTest {

    String name = "Putbar";
    float price = 354;
    Enum type = IngredientType.FILLING;
    String nameLast = "PutbaBlack";
    float priceLast = 152;
    Enum typeLast = IngredientType.SAUCE;

    public String getActualReceipt() {
        StringBuilder receiptActual = new StringBuilder("(==== LambXXL ====)\n");
        receiptActual.append("= sauce Cheese =\n");
        receiptActual.append("(==== LambXXL ====)\n");
        receiptActual.append("\nPrice: 950,000000\n");
        return receiptActual.toString().replaceAll("\\s+", "");
    }

    @Test
    void setBuns() {
        Bun bun = new Bun("adsf", 11);
        Burger burger = new Burger();
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    void addIngredient() {
        Ingredient ingredient = new Ingredient((IngredientType) type, name, price);
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        Assertions.assertEquals(burger.ingredients.get(0).getName(), name, "Название бургера сохранилось не правильно");
        Assertions.assertEquals(price, burger.ingredients.get(0).getPrice());
        Assertions.assertEquals(type, burger.ingredients.get(0).getType());
    }

    @Test
    void moveIngredient() {
        Ingredient ingredient = new Ingredient((IngredientType) type, name, price);
        Ingredient ingredientLast = new Ingredient((IngredientType) typeLast, nameLast, priceLast);
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientLast);
        burger.moveIngredient(0, 1);
        Assertions.assertEquals(burger.ingredients.get(0).getName(), nameLast, "Название бургера сохранилось не правильно");
        Assertions.assertEquals(priceLast, burger.ingredients.get(0).getPrice());
        Assertions.assertEquals(typeLast, burger.ingredients.get(0).getType());
    }

    @Test
    void getPrice() {
        Bun bun = new Bun("LambXXL", 370);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.getPrice();
        Assertions.assertEquals(bun.getPrice() * 2, burger.getPrice());
    }

    @Test
    void getReceipt() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Cheese", 40);
        Bun bun = Mockito.mock(Bun.class);
        Mockito.when(bun.getName()).thenReturn("LambXXL");
        Mockito.when(bun.getPrice()).thenReturn(455F);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        String expected = burger.getReceipt().replaceAll("\\s+", "");
        Assertions.assertEquals(getActualReceipt(), expected);
    }
}