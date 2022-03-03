package supermarket;

import eventsim.Event;
import eventsim.EventSim;

public class EndQueueEvent extends Event {
    Customer customer;

    public EndQueueEvent(Customer customer) {
        super(EventSim.getClock() + customer.checkoutTime);

        this.customer = customer;
    }


    @Override
    public Event happen() {
        customer.leaveTime = customer.checkoutTime + customer.checkoutDuration;
        return null;
    }


    @Override
    public String toString() {
        return "EndShoppingEvent{" + getTime() + " cust=" + customer.name
                + " " + customer.shoppingDuration + '}';
    }
}
