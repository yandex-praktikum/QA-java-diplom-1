package praktikum.stellarburgers.model;

import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static praktikum.stellarburgers.model.mock.BurgerDataGenerator.*;
import static praktikum.stellarburgers.model.mock.StabGenerator.*;

public class BurgerTest {
    private SoftAssertions softAssertions;

    private Burger burger;
    private Bun bun;
    private Ingredient sauce;
    private Ingredient filling;

    @Before
    public void setUp() {
        softAssertions = new SoftAssertions();

        bun = getRandomBun();
        sauce = getRandomSauce();
        filling = getRandomFilling();

        burger = new Burger();
    }

    @Test
    public void setBunsWithStubData() {
        String EXPECTED_NAME = bun.getName();
        float EXPECTED_PRICE = bun.getPrice();

        Bun bunStab = getBunStub(EXPECTED_NAME, EXPECTED_PRICE);
        burger.setBuns(bunStab);

        final String ACTUAL_NAME = burger.bun.getName();
        float ACTUAL_PRICE = burger.bun.getPrice();

        softAssertions.assertThat(ACTUAL_NAME).isEqualTo(EXPECTED_NAME);
        softAssertions.assertThat(ACTUAL_PRICE).isEqualTo(EXPECTED_PRICE);
        softAssertions.assertAll();
    }

    @Test
    public void addIngredientWithStubData() {
        final IngredientType EXPECTED_TYPE = sauce.getType();
        final String EXPECTED_NAME = sauce.getName();
        final float EXPECTED_PRICE = sauce.getPrice();

        burger.addIngredient(getSauceStub(EXPECTED_NAME , EXPECTED_PRICE));

        final int ACTUAL_INGREDIENTS_NUMBER = burger.ingredients.size();
        final int EXPECTED_INGREDIENTS_NUMBER = 1;

        Ingredient testedIngredient = burger.ingredients.get(0);

        final IngredientType ACTUAL_TYPE = testedIngredient.getType();
        final String ACTUAL_NAME =testedIngredient.getName();
        final float ACTUAL_PRICE = testedIngredient.getPrice();

        softAssertions.assertThat(ACTUAL_INGREDIENTS_NUMBER).isEqualTo(EXPECTED_INGREDIENTS_NUMBER);
        softAssertions.assertThat(ACTUAL_TYPE).isEqualTo(EXPECTED_TYPE);
        softAssertions.assertThat(ACTUAL_NAME).isEqualTo(EXPECTED_NAME);
        softAssertions.assertThat(ACTUAL_PRICE).isEqualTo(EXPECTED_PRICE);
        softAssertions.assertAll();
    }

    @Test
    public void removeIngredientWithStabData() {
        Ingredient sauceStub = getSauceStub(sauce.getName(), sauce.getPrice());
        Ingredient fillingStub = getFillingStub(filling.getName(), filling.getPrice());

        burger.addIngredient(sauceStub);
        burger.addIngredient(fillingStub);
        burger.removeIngredient(0);

        final IngredientType EXPECTED_TYPE = filling.getType();
        final String EXPECTED_NAME = filling.getName();
        final float EXPECTED_PRICE = filling.getPrice();

        final int ACTUAL_INGREDIENTS_NUMBER = burger.ingredients.size();
        final int EXPECTED_INGREDIENTS_NUMBER = 1;

        Ingredient testedIngredient = burger.ingredients.get(0);

        final IngredientType ACTUAL_TYPE =  testedIngredient.getType();
        final String ACTUAL_NAME =  testedIngredient.getName();
        final float ACTUAL_PRICE =  testedIngredient.getPrice();

        softAssertions.assertThat(ACTUAL_INGREDIENTS_NUMBER).isEqualTo(EXPECTED_INGREDIENTS_NUMBER);
        softAssertions.assertThat(ACTUAL_TYPE).isEqualTo(EXPECTED_TYPE);
        softAssertions.assertThat(ACTUAL_NAME).isEqualTo(EXPECTED_NAME);
        softAssertions.assertThat(ACTUAL_PRICE).isEqualTo(EXPECTED_PRICE);
        softAssertions.assertAll();
    }

    @Test
    public void moveIngredientWithStubData() {
        Ingredient sauceStub = getSauceStub(sauce.getName(), sauce.getPrice());
        Ingredient fillingStub = getFillingStub(filling.getName(), filling.getPrice());

        final int INDEX_BEFORE_MOVING = 0;
        final int INDEX_AFTER_MOVING = 1;

        final IngredientType EXPECTED_TYPE = sauce.getType();
        final String EXPECTED_NAME = sauce.getName();
        final float EXPECTED_PRICE = sauce.getPrice();

        burger.addIngredient(sauceStub);
        burger.addIngredient(fillingStub);
        burger.moveIngredient(INDEX_BEFORE_MOVING, INDEX_AFTER_MOVING);

        final int ACTUAL_INGREDIENTS_NUMBER = burger.ingredients.size();
        final int EXPECTED_INGREDIENTS_NUMBER = 2;

        final IngredientType ACTUAL_TYPE = burger.ingredients.get(INDEX_AFTER_MOVING).getType();
        final String ACTUAL_NAME = burger.ingredients.get(INDEX_AFTER_MOVING).getName();
        final float ACTUAL_PRICE = burger.ingredients.get(INDEX_AFTER_MOVING).getPrice();

        softAssertions.assertThat(ACTUAL_INGREDIENTS_NUMBER).isEqualTo(EXPECTED_INGREDIENTS_NUMBER);
        softAssertions.assertThat(ACTUAL_TYPE).isEqualTo(EXPECTED_TYPE);
        softAssertions.assertThat(ACTUAL_NAME).isEqualTo(EXPECTED_NAME);
        softAssertions.assertThat(ACTUAL_PRICE).isEqualTo(EXPECTED_PRICE);
        softAssertions.assertAll();
    }

    @Test
    public void getPriceWithStabData() {
        Bun bunStub = getBunStub(bun.getName(), bun.getPrice());
        Ingredient sauceStub = getSauceStub(sauce.getName(), sauce.getPrice());
        Ingredient fillingStub = getFillingStub(filling.getName(), filling.getPrice());

        burger.setBuns(bunStub);
        burger.addIngredient(sauceStub);
        burger.addIngredient(fillingStub);

        final float EXPECTED_PRICE = bun.getPrice() * 2 + sauce.getPrice() +  filling.getPrice();
        final float ACTUAL_PRICE = burger.getPrice();

        Assert.assertEquals(EXPECTED_PRICE, ACTUAL_PRICE, 0);
    }

    @Test
    public void getReceiptWithStabData() {
        Bun bunStab = getBunStub(bun.getName(), bun.getPrice());
        Ingredient sauceStub = getSauceStub(sauce.getName(), sauce.getPrice());

        burger.setBuns(bunStab);
        burger.addIngredient(sauceStub);

        final String ACTUAL_RECEIPT = burger.getReceipt();

        String expectedReceiptIngredientPart = String.format("= %s %s =%n",
                sauce.getType().toString().toLowerCase(),
                sauce.getName());
        String expectedReceiptBunPart = String.format("(==== %s ====)%n",
                bun.getName());
        String expectedReceiptPricePart = String.format("%nPrice: %f%n",
                bun.getPrice() * 2 + sauce.getPrice());

        final String EXPECTED_RECEIPT =
                expectedReceiptBunPart +
                        expectedReceiptIngredientPart +
                        expectedReceiptBunPart +
                        expectedReceiptPricePart;

        Assert.assertEquals(EXPECTED_RECEIPT, ACTUAL_RECEIPT);
    }
}
