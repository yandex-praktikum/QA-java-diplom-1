//package praktikum;
//
//import org.apache.commons.lang3.RandomStringUtils;
//import org.junit.Assert;
//import org.junit.Test;
//
//import java.util.Random;
//
//public class BurgerTest {
//
//    Burger burger;
//    String name = RandomStringUtils.randomAlphabetic(10);
//    Float price = new Random().nextFloat();
//
//
//    public BurgerTest(){
//        burger = new Burger();
//    }
//
//    @Test
//    public void setBunsTest() {
//        Bun bun = new Bun("test burger",5);
//        burger.setBuns(bun);
//        Assert.assertEquals(bun,burger.bun);
//    }
////
////    @Test
////    public void addIngredientTest() {
////        Ingredient ingredient = new Ingredient(IngredientType.FILLING, name, price);
////        burger.addIngredient(ingredient);
////        Assert.assertEquals(burger.ingredients.get(0),ingredient);
////        burger.addIngredient(null);
////        System.out.println(burger.ingredients.size());
////        System.out.println(burger.getReceipt());
////
////    }
////
////    @Test //I assumed that ingredient size should be equal 0, after adding null ingredient
////    public void addNullIngredient(){
////        burger.addIngredient(null);
////        System.out.println(burger.ingredients.size());
////        Assert.assertEquals(0,burger.ingredients.size());
////    }
//
//    @Test
//    public void removeIngredientTest() {
//        Ingredient ingredient0 = new Ingredient(IngredientType.SAUCE, name, price);
//        burger.addIngredient(ingredient0);
//        Ingredient ingredient1 = new Ingredient(IngredientType.FILLING,name,price);
//        burger.addIngredient(ingredient1);
//
//        //check deletion from index zero
//        burger.removeIngredient(0);
//        Assert.assertEquals(burger.ingredients.get(0),ingredient1);
//
//        //check deletion from index one
//        burger.addIngredient(ingredient0);
//        burger.removeIngredient(1);
//        Assert.assertEquals(burger.ingredients.get(0),ingredient1);
//    }
//
//    @Test
//    public void moveIngredientTest() {
//        Ingredient ingredient0 = new Ingredient(IngredientType.SAUCE, name, price);
//        burger.addIngredient(ingredient0);
//        Ingredient ingredient1 = new Ingredient(IngredientType.FILLING,name, price);
//        burger.addIngredient(ingredient1);
//        burger.moveIngredient(1,0);
//        Assert.assertEquals(burger.ingredients.get(0),ingredient1);
//        Assert.assertEquals(burger.ingredients.get(1),ingredient0);
//
//    }
//
//    @Test
//    public void getPriceTest() {
//
//        Random rnd = new Random();
//        Bun bun = new Bun(RandomStringUtils.randomAlphabetic(10),rnd.nextFloat());
//        burger.setBuns(bun);
//        Ingredient ingredient = new Ingredient(IngredientType.FILLING, name, rnd.nextFloat());
//        burger.addIngredient(ingredient);
//        Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, name, rnd.nextFloat());
//        burger.addIngredient(ingredient1);
//        Assert.assertEquals(bun.price * 2 + ingredient.price + ingredient1.price,burger.getPrice(),0 );
//    }
//
//    @Test
//    public void getReceiptTest() {
//        Random rnd = new Random();
//        Bun bun = new Bun("bun",7);
//        burger.setBuns(bun);
//        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "ingredient1", 5);
//        burger.addIngredient(ingredient);
//        Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, "ingredient2", 5);
//        burger.addIngredient(ingredient1);
//        System.out.println(burger.getReceipt());
//        String   expt =   "(==== bun ====)\r\n";
//                 expt +=  "= filling ingredient1 =\r\n";
//                 expt +=  "= sauce ingredient2 =\r\n";
//                 expt +=  "(==== bun ====)\r\n";
//                 expt +=  "\r\nPrice: 24.000000\r\n";
//        //System.out.println(expt);
//        //String act=burger.getReceipt();
//        Assert.assertEquals(expt,burger.getReceipt());
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
