import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Ingredient;

public class BaseTest {
    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;
}
