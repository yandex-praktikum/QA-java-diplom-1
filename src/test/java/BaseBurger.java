import org.mockito.Mock;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import java.util.List;


public class BaseBurger {
    public static Burger burger = new Burger();

    @Mock
    protected List<Bun> buns;
    @Mock
    protected List<Ingredient> ingredients;
    protected final static String BUNS_ADDED_EXPECTED = String.format("(==== black bun ====)%n(==== black bun ====)%n%nPrice: 200,000000%n");

    protected final static String  INGREDIENT_ADDED_EXPECTED = String.format("(==== black bun ====)%n= sauce sour cream =%n(==== black bun ====)%n%nPrice: 400,000000%n");

    protected final static String INGREDIENT_MOVED_EXPECTED = String.format("(==== black bun ====)%n= filling dinosaur =%n= sauce sour cream =%n(==== black bun ====)%n%nPrice: 600,000000%n");
    protected final static String RECEIPT_EXPECTED = String.format("(==== black bun ====)%n= sauce sour cream =%n= filling cutlet =%n= filling dinosaur =%n(==== black bun ====)%n%nPrice: 700,000000%n");

}
