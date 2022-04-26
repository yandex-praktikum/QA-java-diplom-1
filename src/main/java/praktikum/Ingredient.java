package praktikum;

        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

/**
 * Модель ингредиента.
 * Ингредиент: начинка или соус.
 * У ингредиента есть тип (начинка или соус), название и цена.
 */
public class Ingredient {

    public IngredientType type;
    public String name;
    public float price;


    public Ingredient(IngredientType type, String name, float price) {
//        Pattern pattern = Pattern.compile("(^[а-яА-Я]*$)");
//        Matcher matcher = pattern.matcher(name);

        this.type = type;
        this.name = name;
        this.price = price;
//        if (price <= 0.0001f | price > 100000f) {
//            throw new IllegalArgumentException("price should be positive");
//        }
//        if (name == null | name ==" ") {
//            throw new IllegalArgumentException("name can't be null");
//        }
//        if (matcher.matches()) {
//            throw new IllegalArgumentException("name can't be null");
//        }
    }

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public IngredientType getType() {
        return type;
    }

}