import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

	private IngredientType ingredientType;

	public IngredientTypeTest(IngredientType ingredientType){
		this.ingredientType = ingredientType;
	}

	@Parameterized.Parameters(name = "Ingredient Type = {0}")
	public static ArrayList data() {
		IngredientType[] values = IngredientType.values();
		ArrayList data = new ArrayList(values.length);
		for (IngredientType ingredientType : values) { data.add(new Object[] { ingredientType }); }
		return data;
	}

	@Test
	public void ingredientTypeTest(){
		assertThat(Arrays.asList(IngredientType.values()), hasItem(ingredientType));
	}
}
