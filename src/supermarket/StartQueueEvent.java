package supermarket;

import eventsim.Event;

    public class StartQueueEvent extends Event {
        Customer customer;


        public StartQueueEvent(Customer customer) {
            super(customer.beginQueueTime);
            this.customer = customer;
        }


        @Override
        public Event happen() {
            return new EndQueueEvent(customer);
        }


    }

