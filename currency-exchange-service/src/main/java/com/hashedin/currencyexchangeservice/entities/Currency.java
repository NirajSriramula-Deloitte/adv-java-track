    package com.hashedin.currencyexchangeservice.entities;

    import javax.persistence.Entity;
    import javax.persistence.GeneratedValue;
    import javax.persistence.Id;

    @Entity
    public class Currency {

        @Id
        @GeneratedValue
        private int id;
        private String cur_name;
        private Float exchange_rate;

        public Currency() {
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCur_name() {
            return cur_name;
        }

        public void setCur_name(String cur_name) {
            this.cur_name = cur_name;
        }

        public Float getExchange_rate() {
            return exchange_rate;
        }

        public void setExchange_rate(Float exchange_rate) {
            this.exchange_rate = exchange_rate;
        }
    }
