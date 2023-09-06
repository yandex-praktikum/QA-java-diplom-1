package praktikum;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Assert;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IngredientTypeTest {
    private final static String SAUCE = "SAUCE";
    private final static String FILLING = "FILLING";
    private final static String DIP = "DIP";

    @Test
    public void valuesNamesAreEqualExpectedNames() {
       List<String> expectedNames = List.of(SAUCE, FILLING);

        List<String> ingredients = Stream.of(IngredientType.values()).map(IngredientType::name)
                .collect(Collectors.toList());
        assertThat(ingredients,is(expectedNames));
    }

    @Test
    public void valuesNotContainsExtraValues(){
        List<String> ingredients = Stream.of(IngredientType.values()).map(IngredientType::name)
                .collect(Collectors.toList());
        assertThat(ingredients, not(hasItem(DIP)));
    }

    @Test
    public void valueOfSAUCEisContainedInEnum() {
        Assert.assertEquals(IngredientType.SAUCE, Enum.valueOf(IngredientType.class, SAUCE));
    }

    @Test
    public void valueOfFILLINGisContainedInEnum() {
        Assert.assertEquals(IngredientType.FILLING, Enum.valueOf(IngredientType.class, FILLING));
    }
}