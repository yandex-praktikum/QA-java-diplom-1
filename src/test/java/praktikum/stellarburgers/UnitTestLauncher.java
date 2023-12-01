package praktikum.stellarburgers;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import praktikum.stellarburgers.model.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        BunTest.class,
        BurgerTest.class,
        DatabaseTest.class,
        IngredientTest.class,
        IngredientTypeTest.class
})
public class UnitTestLauncher {
}
