package praktikum;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class DatabaseTest {
    private final Database database = new Database();

    @Test
    public void availableBuns() {
        assertThat(database.availableBuns().size()).isEqualTo(3);
    }

    @Test
    public void availableIngredients() {
        assertThat(database.availableIngredients().size()).isEqualTo(6);
    }
}