package praktikum;

public class СontainParam {
    private String nameBun = "black bun"; //Наименование булочки
    private float priceBun = 100; //Цена булочки

    private String nameIngredient = "dinosaur"; //Название ингридиента
    private float priceIngredient = 200; //Цена ингридиента
    private float expectedBurgerPrice = 300; //Ожидаемая цена бургера

    public float getExpectedBurgerPrice() {
        return expectedBurgerPrice;
    }

    public void setExpectedBurgerPrice(float expectedBurgerPrice) {
        this.expectedBurgerPrice = expectedBurgerPrice;
    }

    public String getNameIngredient() {
        return nameIngredient;
    }

    public void setNameIngredient(String nameIngredient) {
        this.nameIngredient = nameIngredient;
    }

    public float getPriceIngredient() {
        return priceIngredient;
    }

    public void setPriceIngredient(float priceIngredient) {
        this.priceIngredient = priceIngredient;
    }


    public String getNameBun() {
        return nameBun;
    }

    public void setNameBun(String nameBun) {
        this.nameBun = nameBun;
    }

    public float getPriceBun() {
        return priceBun;
    }

    public void setPriceBun(float priceBun) {
        this.priceBun = priceBun;
    }


}
