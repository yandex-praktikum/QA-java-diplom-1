package praktikum;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class UtilForTest {
   protected Burger burger = new Burger();
   protected Ingredient ingredient1 = new Ingredient(SAUCE, "Сырный", 5f);
   protected Ingredient ingredient2 = new Ingredient(FILLING, "Начинка", 6f);
}
