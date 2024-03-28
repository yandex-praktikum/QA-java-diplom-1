import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Database;
import praktikum.Ingredient;
import java.util.List;

@RunWith(Parameterized.class)
public class ParameterizedGetReceipt{
    private final Burger burger;
    private final String expected;

    public ParameterizedGetReceipt(Burger burger,String expected){
        this.burger = burger;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getReceipt() {
        Database database = new Database();
        List<Bun> buns = database.availableBuns();
        List<Ingredient> ingredients = database.availableIngredients();

        Burger burgerSourBlackCutlet = new Burger();
        Burger burgerHotWhiteDinosaur = new Burger();
        Burger burgerChiliRedSausage = new Burger();

        burgerSourBlackCutlet.setBuns(buns.get(0));
        burgerSourBlackCutlet.addIngredient(ingredients.get(1));
        burgerSourBlackCutlet.addIngredient(ingredients.get(3));
        String n = System.lineSeparator();
        String expectedSourBlackCutlet = new String(String.format("(==== black bun ====)" + n +
                "= sauce sour cream =" + n +
                "= filling cutlet =" + n +
                "(==== black bun ====)" + n
                + n +
                "Price: 500,000000") + n);
        burgerHotWhiteDinosaur.setBuns(buns.get(1));
        burgerHotWhiteDinosaur.addIngredient(ingredients.get(0));
        burgerHotWhiteDinosaur.addIngredient(ingredients.get(4));

        String expectedHotWhiteDinosaur = new String(String.format("(==== white bun ====)" + n +
                "= sauce hot sauce =" + n +
                "= filling dinosaur =" + n +
                "(==== white bun ====)" + n
                + n +
                "Price: 700,000000") + n);

        burgerChiliRedSausage.setBuns(buns.get(2));
        burgerChiliRedSausage.addIngredient(ingredients.get(2));
        burgerChiliRedSausage.addIngredient(ingredients.get(5));

        String expectedChiliRedSausage = new String(String.format("(==== red bun ====)" + n +
                "= sauce chili sauce =" + n +
                "= filling sausage =" + n +
                "(==== white bun ====)" + n
                + n +
                "Price: 1200,000000") + n);

        return new Object[][]{
                {burgerSourBlackCutlet,expectedSourBlackCutlet},
                {burgerHotWhiteDinosaur,expectedHotWhiteDinosaur},
        };
    }

    @Test
    public void checkReceipt(){
        Assert.assertEquals(expected,burger.getReceipt());
    }
}
