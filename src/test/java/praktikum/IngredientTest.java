package praktikum;

import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    @Mock
    float priceMock;
    String nameMock;
    IngredientType typeMock;

    @Test
    public void getNameEqualsTasty() {
        String name = "Tasty";
        Ingredient ingredient = new Ingredient(typeMock, name, priceMock);

        String actualName = ingredient.getName();
        String expectedName = "Tasty";
        assertEquals(expectedName, actualName);
    }

    @Test
    public void getPriceEqualsTen() {
        float price = 10;
        Ingredient ingredient = new Ingredient(typeMock, nameMock, price);

        float actualPrice = ingredient.getPrice();
        float expectedPrice = 10;
        assertEquals(expectedPrice, actualPrice,0);
    }

}