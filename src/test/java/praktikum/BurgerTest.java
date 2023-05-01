package praktikum;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

  private static final float BUN_PRICE = 2.0f;
  private static final String BUN_NAME = "bun_test";
  private static final float EXPECTED_BURGER_PRICE = 11.0f;
  private static final float FIRST_INGREDIENT_PRICE = 3.0f;
  private static final float SECOND_INGREDIENT_PRICE = 4.0f;
  private static final String FIRST_INGREDIENT_NAME = "first_ingredient_type_name";
  private static final String SECOND_INGREDIENT_NAME = "second_ingredient_type_name";
  private static final int EXPECTED_INGREDIENTS_SIZE_ADD_INGREDIENT_TEST = 2;
  private static final int EXPECTED_INGREDIENTS_SIZE_REMOVE_INGREDIENT_TEST = 1;

  @Mock private Bun bun;

  @Mock private Ingredient firstIngredient;

  @Mock private Ingredient secondIngredient;

  @Before
  public void init() {
    when(bun.getName()).thenReturn(BUN_NAME);
    when(bun.getPrice()).thenReturn(BUN_PRICE);

    when(firstIngredient.getType()).thenReturn(IngredientType.SAUCE);
    when(firstIngredient.getName()).thenReturn(FIRST_INGREDIENT_NAME);
    when(firstIngredient.getPrice()).thenReturn(FIRST_INGREDIENT_PRICE);

    when(secondIngredient.getType()).thenReturn(IngredientType.FILLING);
    when(secondIngredient.getName()).thenReturn(SECOND_INGREDIENT_NAME);
    when(secondIngredient.getPrice()).thenReturn(SECOND_INGREDIENT_PRICE);
  }

  @Test
  public void setBunsTest() {
    Burger burger = new Burger();
    burger.setBuns(bun);
    assertEquals(bun, burger.bun);
  }

  @Test
  public void addIngredientTest() {
    Burger burger = new Burger();
    burger.addIngredient(firstIngredient);
    burger.addIngredient(secondIngredient);

    assertEquals(EXPECTED_INGREDIENTS_SIZE_ADD_INGREDIENT_TEST, burger.ingredients.size());
    assertEquals(firstIngredient, burger.ingredients.get(0));
    assertEquals(secondIngredient, burger.ingredients.get(1));
  }

  @Test
  public void removeIngredientTest() {
    Burger burger = new Burger();
    burger.addIngredient(firstIngredient);
    burger.addIngredient(secondIngredient);

    burger.removeIngredient(0);

    assertEquals(EXPECTED_INGREDIENTS_SIZE_REMOVE_INGREDIENT_TEST, burger.ingredients.size());
    assertEquals(secondIngredient, burger.ingredients.get(0));
  }

  @Test
  public void moveIngredientTest() {
    Burger burger = new Burger();
    burger.addIngredient(firstIngredient);
    burger.addIngredient(secondIngredient);

    burger.moveIngredient(1, 0);

    assertEquals(EXPECTED_INGREDIENTS_SIZE_ADD_INGREDIENT_TEST, burger.ingredients.size());
    assertEquals(secondIngredient, burger.ingredients.get(0));
  }

  @Test
  public void getPriceTest() {
    Burger burger = new Burger();
    burger.setBuns(bun);
    burger.addIngredient(firstIngredient);
    burger.addIngredient(secondIngredient);

    float price = burger.getPrice();

    assertEquals(EXPECTED_BURGER_PRICE, price, 0f);
  }

  @Test
  public void getReceiptTest() {
    Burger burger = new Burger();
    burger.setBuns(bun);
    burger.addIngredient(firstIngredient);
    burger.addIngredient(secondIngredient);

    String receipt = burger.getReceipt();

    String expectedReceipt = buildExpectedReceipt(burger);

    assertEquals(expectedReceipt, receipt);
  }

  private String buildExpectedReceipt(Burger burger) {
    StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));

    receipt.append(
        String.format(
            "= %s %s =%n",
            IngredientType.SAUCE.toString().toLowerCase(), firstIngredient.getName()));
    receipt.append(
        String.format(
            "= %s %s =%n",
            IngredientType.FILLING.toString().toLowerCase(), secondIngredient.getName()));

    receipt.append(String.format("(==== %s ====)%n", bun.getName()));
    receipt.append(String.format("%nPrice: %f%n", burger.getPrice()));

    return receipt.toString();
  }
}
