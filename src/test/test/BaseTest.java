import java.util.Random;

public abstract class BaseTest {

    static final String expectedBunName = "Булочка с кунжутом";

    static final String expectedIngredientName = "Фирменный соус";

    static final Random random = new Random();

    static final float testDelta = 0.0f;

    static final float expectedBunPrice = random.nextFloat();
}
