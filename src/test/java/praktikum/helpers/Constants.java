package praktikum.helpers;

import praktikum.Burger;

public class Constants {

    public static final String BUN_NAME = "Флюоресцентная булка R2-D3";
    public static final float BUN_PRICE = 999.99f;
    public static final String INGREDIENT_ONE_NAME = "Биокотлета из марсианской Магнолии";
    public static final String INGREDIENT_TWO_NAME = "Соус с шипами Антарианского плоскоходца";

    public static final float INGREDIENT_ONE_PRICE = 333.33f;
    public static final float INGREDIENT_TWO_PRICE = 15.15f;
    public static final String INGREDIENT_ONE_TYPE_STR = "FILLING";
    public static final String INGREDIENT_TWO_TYPE_STR = "SAUCE";

    //region TEST MESSAGES
    public static final String CHECK_NAME_TEST_MESSAGE = "Ожидалось значение: '%s'. Фактическое значение:'%s'";
    public static final String CHECK_PRICE_TEST_MESSAGE = "Ожидалось значение: '%.2f'. Фактическое значение:'%.2f'";
    public static final String CHECK_IS_BUN_NULL_IN_BURGER_MESSAGE =
            String.format("Свойство '%s' в объекте '%s' не может иметь значение 'null'", "bun", Burger.class.getName());
    public static final String CHECK_COUNT_ELEMENTS_IN_INGREDIENT_LIST_MESSAGE =
            "Ожидалось количество ингридиентов: %d. Фактическое количество элементов: %d";
    public static final String CHECK_POSITION_ELEMENTS_IN_INGREDIENT_LIST_MESSAGE =
            "Ожидалось, что элемент с индексом %d будет иметь имя %s. Фактически элементу соответствует имя %s";
    public static final String CHECK_THAT_ELEMENT_DOESNT_CONTAIN_IN_LIST_OF_INGREDIENTS_MESSAGE =
            "Список ингридиетов не должен содержать элемент с именем '%s'";

    public static final String CHECK_THAT_ELEMENT_CONTAINS_IN_LIST_OF_INGREDIENTS_MESSAGE =
            "Список ингридиетов должен содержать элемент с именем '%s'";

    public static final String CHECK_THAT_INGREDIENT_HAS_CHANGED_POSITION_MESSAGE =
            "Ожидалось, что ингридиентом с индексом %d в спике окажется %s. Фактически: %s";

    public static final String CHECK_TOTAL_BURGER_PRICE_MESSAGE =
            "Ожидалось, что цена бургера составит %.2f.Фактическая цена бургера %.2f";

    public static final String CHECK_BURGER_RECEIPT_MESSAGE =
            "Ожидалось, что рецепт бургера будет выглядеть так \n %s. Фактически рецепт выглядит так: \n %s";

    //endregion
}
