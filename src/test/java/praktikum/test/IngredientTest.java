package praktikum.test;

import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {
        private Ingredient ingredient;
        private String name = "Соус с шипами Антарианского плоскоходца";
        private float price = 0.88f;
        public IngredientType type = SAUCE;

        @Before
        public void setUp() {
            ingredient = new Ingredient(type, name, price);
        }

        @Test
        public void testGetPrice() {
            float expectedPrice = price;
            float actualPrice = ingredient.getPrice();
            assertEquals(expectedPrice, actualPrice, 0.01);
        }

        @Test
        public void testGetName() {
            String expectedName = name;
            String actualName = ingredient.getName();
            assertEquals(expectedName, actualName);
        }

        @Test
        public void testGetType() {
            IngredientType expectedType = type;
            IngredientType actualType = ingredient.getType();
            assertEquals(expectedType, actualType);
        }
    }
