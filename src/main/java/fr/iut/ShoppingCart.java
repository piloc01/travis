package fr.iut;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ShoppingCart {


    private Map<Item, Integer> cart = new HashMap<Item, Integer>();

    public void addItem(final Item item, final int quantity){
        cart.put(item, quantity);
    }

    public Map<Item, Integer> getContent() {
        final Map<Item, Integer> copied = new HashMap<Item, Integer>();
        copied.putAll(cart);
        return copied;
    }

    public double getPriceWithoutTaxes() {
        return cart.entrySet().stream().map(x -> x.getKey().getPrice() * x.getValue()).collect(Collectors.summingDouble(Double::doubleValue));
    }

    public Double getPriceWithTaxes(Country country) {
        return getPriceWithReduction() * country.getTaxToApply();
    }

    public Double getPriceWithReduction() {
        Double price = this.getPriceWithoutTaxes();
        if(price<1000) return price;
        else if(price<5000) return price * 0.97;
        else if(price<7000) return price * 0.95;
        else if(price<10000) return price * 0.93;
        else if(price<50000) return price * 0.9;
        else return price * 0.85;
    }
}
