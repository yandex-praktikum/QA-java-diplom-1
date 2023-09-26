import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientParametrizedTest {
    IngredientType type;
        String name;
        float price;
        public IngredientParametrizedTest(IngredientType type, String name, float price) {
            this.type = type;
            this.name = name;
            this.price = price;
        }
        @Parameterized.Parameters
        public static Object[][] getIngredient() {
            return new Object[][] {
                    {IngredientType.SAUCE, "Соус Spicy-X", 90},
                    {IngredientType.SAUCE, "Соус с шипами Антарианского плоскоходца", 88},
                    {IngredientType.FILLING, "Мясо бессмертных моллюсков Protostomia", 1337},
                    {IngredientType.FILLING, "Филе Люминесцентного тетраодонтимформа", 988},
                    {IngredientType.FILLING, "Сыр с астероидной плесенью", 4142}
            };
        }
        @Test
        public void getIngredientName() {
            Ingredient ingredient = new Ingredient(type, name, price);
            System.out.println(ingredient.getName());
        }
        @Test
        public void getIngredientPrice() {
            Ingredient ingredient = new Ingredient(type, name, price);
            System.out.println(ingredient.getPrice());
        }
        @Test
        public void shouldBeTwoIngredientTypesEquals() {
            Ingredient ingredient = new Ingredient(type, name, price);
            Assert.assertEquals(type, ingredient.getType());
        }
        @Test
        public void shouldBeTwoIngredientNamesEquals() {
            Ingredient ingredient = new Ingredient(type, name, price);
            Assert.assertEquals(name, ingredient.name);
        }
        @Test
        public void shouldBeTwoIngredientPricesEquals() {
            Ingredient ingredient = new Ingredient(type, name, price);
            Assert.assertEquals(price, ingredient.price, 0);
        }
    }