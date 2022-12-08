package praktikum;

import junitparams.JUnitParamsRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Objects;

@RunWith(JUnitParamsRunner.class)
public class IngredientTypeTest {

    @Test
    public void IngredientTypeIsNotNull() {
       Assert.assertFalse(Objects.isNull(IngredientType.values()));
    }

}