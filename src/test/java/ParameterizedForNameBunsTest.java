import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class ParameterizedForNameBunsTest {
    Burger burger = new Burger();

    private final String expectedBunNameResult;
    private final String mockDataForBunName;

    public ParameterizedForNameBunsTest(String expectedBunNameResult, String mockDataForBunName) {
        this.expectedBunNameResult = expectedBunNameResult;
        this.mockDataForBunName = mockDataForBunName;
    }

    @Parameterized.Parameters
    public static Object[] getDataForMockTest() {
        return new Object[][]{
                {"Краторная булка N-200i", "Краторная булка N-200i"},
                {"Флюоресцентная булка R2-D3", "Флюоресцентная булка R2-D3"},
                {" ", " "},
                {"@#$%^&*~!()_", "@#$%^&*~!()_"},
                {null, null},
                {"Перед тем как писать тесты, протестируй API вручную в Postman. Это поможет разобраться, как работают запросы.", "Перед тем как писать тесты, протестируй API вручную в Postman. Это поможет разобраться, как работают запросы."}
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    Bun bun;

    @Test
    public void parameterizedGetBunNameTest() {
        burger.setBuns(bun);
        when(bun.getName()).thenReturn(mockDataForBunName);
        assertEquals(expectedBunNameResult, bun.getName());
    }
}

