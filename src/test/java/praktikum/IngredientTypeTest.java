package praktikum;

import org.junit.Ignore;
import org.junit.Test;

public class IngredientTypeTest {
    /**
     * Method under test: {@link IngredientType#valueOf(String)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testValueOf() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: No enum constant praktikum.IngredientType.Name
        //       at java.lang.Enum.valueOf(Enum.java:240)
        //       at praktikum.IngredientType.valueOf(IngredientType.java:8)
        //   In order to prevent valueOf(String)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   valueOf(String).
        //   See https://diff.blue/R013 to resolve this issue.

        IngredientType.valueOf("Name");
    }

    /**
     * Method under test: {@link IngredientType#valueOf(String)}
     */
    @Test
    public void testValueOf2() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by valueOf(String)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        IngredientType.valueOf("FILLING");
    }

    /**
     * Method under test: {@link IngredientType#valueOf(String)}
     */
    @Test
    public void testValueOf3() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by valueOf(String)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        IngredientType.valueOf("SAUCE");
    }
}

