import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

public class IngredientCompareTest {
        @Test
        public void shouldBeTwoFillingsEquals() {
            Assert.assertEquals("Должна быть начинка (FILLING)", IngredientType.FILLING, IngredientType.valueOf("FILLING"));
        }
        @Test
        public void shouldBeSauceAndFillingsNotEquals() {
            Assert.assertNotEquals("Соуса быть не должно!", IngredientType.SAUCE, IngredientType.valueOf("FILLING"));
        }
    }

