/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import eventsim.EventSim;


/**
 *
 * @author evenal
 */
public class Customer {
    // customer will pick a random number of products between these two values
    public static final int MAX_PRODUCTS = 500;
    public static final int MIN_PRODUCTS = 1;

    // customer will spend ranom amount of time between these values before
    // going to check out
    public static final int MAX_SHOP_TIME = 50;
    public static final int MIN_SHOP_TIME = 1;

    public static final int MAX_QUEUE_TIME = 30;
    public static final int MIN_QUEUE_TIME = 1;


    SuperMarket shop;
    String name;
    Checkout checkout;

    int beginShoppingTime;
    int beginQueueTime;
    int shoppingDuration;
    int numProducts;
    int endShoppingTime;
    int queueWaitDuration;
    int checkoutTime;
    int checkoutDuration;
    int leaveTime;



    public Customer(SuperMarket shop, int i) {
        this.shop = shop;
        name = "Cust" + i;
        System.out.println(name);
        beginShoppingTime = i;
        System.out.println(beginShoppingTime);
        numProducts = EventSim.nextInt(MIN_PRODUCTS, MAX_PRODUCTS);
        shoppingDuration = EventSim.nextInt(MIN_SHOP_TIME, MAX_SHOP_TIME);
        System.out.println(shoppingDuration);
        endShoppingTime = beginShoppingTime + shoppingDuration;

        queueWaitDuration = EventSim.nextInt(MIN_QUEUE_TIME, MAX_QUEUE_TIME);
        System.out.println("queue wait: " + queueWaitDuration);

        checkoutTime = checkout.PAY_DURATION + checkout.PROD_DURATION*numProducts;
        System.out.println("Checkout time: "+checkoutTime);
        int totalTime = this.checkoutTime + this.queueWaitDuration;
        System.out.println("Total time used at checkout: " + totalTime);

    }
}
