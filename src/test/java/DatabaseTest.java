import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.BunGenerator;
import praktikum.Database;
import praktikum.Ingredient;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DatabaseTest {
    Database database = new Database();

    @Test
    public void testAvailableBuns() {
        assertTrue("В базе нет значений с ингедиентами", database.availableBuns().size() >0);

    }

    @Test
    public void testAvailableIngredients() {
        assertTrue("В базе нет значений с ингедиентами", database.availableIngredients().size() >0);
    }

}
