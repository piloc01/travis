import fr.iut.Country;
import fr.iut.Country;
import fr.iut.Item;
import fr.iut.ShoppingCart;
import org.junit.Test;
import org.junit.Assert;


import java.util.HashMap;

import static org.junit.Assert.assertEquals;


public class TestShoppingCart {

    @Test
    public void addItem(){
        final ShoppingCart shoppingCart = new ShoppingCart();
        final Item carot = new Item("carot", 2.5);
        shoppingCart.addItem(carot, 1);

        Assert.assertEquals(shoppingCart.getContent(), new HashMap<Item, Integer>() {{
            put(carot, 1);
        }});
    }

    @Test
    public void computePriceWithoutTaxes(){
        final ShoppingCart shoppingCart = new ShoppingCart();
        final Item carot = new Item("carot", 2.5);
        shoppingCart.addItem(carot, 1);
        shoppingCart.addItem(new Item("aple", 1), 25);
        shoppingCart.addItem(new Item("bananas 1kg", 5), 3);
        Assert.assertEquals(shoppingCart.getPriceWithoutTaxes(), 42.5, 0.0001);
    }

    @Test
    public void computePriceWithTaxes(){
        final ShoppingCart shoppingCart = new ShoppingCart();
        final Item carot = new Item("carot", 2.5);
        shoppingCart.addItem(carot, 1);
        shoppingCart.addItem(new Item("aple", 1), 25);
        shoppingCart.addItem(new Item("bananas 1kg", 5), 3);
        Assert.assertEquals(shoppingCart.getPriceWithTaxes(Country.FR), 50.83, 0.0001);
    }


    @Test
    public void computePriceWithReduction(){
        final ShoppingCart shoppingCart = new ShoppingCart();
        final Item carot = new Item("carot", 2.5);
        shoppingCart.addItem(carot, 1);
        shoppingCart.addItem(new Item("aple", 1), 25);
        shoppingCart.addItem(new Item("bananas 1kg", 5), 3);
        Assert.assertEquals(shoppingCart.getPriceWithReduction(shoppingCart.getPriceWithTaxes(Country.FR)), 50.83, 0.0001);
    }


    @Test
    public void computePriceWithReductionDE(){
        final ShoppingCart shoppingCart = new ShoppingCart();
        final Item carot = new Item("carot", 2.5);
        shoppingCart.addItem(carot, 1);
        shoppingCart.addItem(new Item("aple", 1), 25);
        shoppingCart.addItem(new Item("bananas 1kg", 5), 3);
        Assert.assertEquals(shoppingCart.getPriceWithReduction(shoppingCart.getPriceWithTaxes(Country.DE)), 50.574999999999996, 0.0001);
    }

    @Test
    public void computePriceWithReductionDK(){
        final ShoppingCart shoppingCart = new ShoppingCart();
        final Item carot = new Item("carot", 2.5);
        shoppingCart.addItem(carot, 0);
        shoppingCart.addItem(new Item("aple", 1), 0);
        shoppingCart.addItem(new Item("bananas 1kg", 5), 10000);
        Assert.assertEquals(shoppingCart.getPriceWithReduction(shoppingCart.getPriceWithTaxes(Country.DK)), 53125, 0.0001);
    }

    @Test
    public void computePriceWithReductionHR(){
        final ShoppingCart shoppingCart = new ShoppingCart();
        final Item carot = new Item("carot", 2.5);
        shoppingCart.addItem(carot, 1);
        shoppingCart.addItem(new Item("aple", 1), 25);
        shoppingCart.addItem(new Item("bananas 1kg", 5), 3);
        Assert.assertEquals(shoppingCart.getPriceWithReduction(shoppingCart.getPriceWithTaxes(Country.HR)), 53.125, 0.0001);
    }

    @Test
    public void computePriceWithReductionIS(){
        final ShoppingCart shoppingCart = new ShoppingCart();
        final Item carot = new Item("carot", 2.5);
        shoppingCart.addItem(carot, 1);
        shoppingCart.addItem(new Item("aple", 1), 25);
        shoppingCart.addItem(new Item("bananas 1kg", 5), 3);
        Assert.assertEquals(shoppingCart.getPriceWithReduction(shoppingCart.getPriceWithTaxes(Country.IS)), 53.3375, 0.0001);
    }

    @Test
    public void computePriceWithReductionCH(){
        final ShoppingCart shoppingCart = new ShoppingCart();
        final Item carot = new Item("carot", 2.5);
        shoppingCart.addItem(carot, 1);
        shoppingCart.addItem(new Item("aple", 1), 25);
        shoppingCart.addItem(new Item("bananas 1kg", 5), 3);
        Assert.assertEquals(shoppingCart.getPriceWithReduction(shoppingCart.getPriceWithTaxes(Country.CH)), 45.900000000000006, 0.0001);
    }
}



















