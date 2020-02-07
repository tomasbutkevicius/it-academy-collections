package net.swedbank.gyk.collections.productset;

import java.time.LocalDateTime;

public class ProductStatistics {

    private LocalDateTime firstSaleOn;
    private LocalDateTime lastSaleOn;
    private double salesAmount;

    public ProductStatistics(LocalDateTime firstSaleOn, LocalDateTime lastSaleOn, double salesAmount) {
        this.firstSaleOn = firstSaleOn;
        this.lastSaleOn = lastSaleOn;
        this.salesAmount = salesAmount;
    }
    // implement constructor

    private LocalDateTime getMinDate(LocalDateTime d1, LocalDateTime d2) {
        if(d1.compareTo(d2) < 0) return d1;
        return d2;
    }

    private LocalDateTime getMaxDate(LocalDateTime d1, LocalDateTime d2) {
        if(d1.compareTo(d2) > 0) return d1;
        return d2;
    }

    //implement this
    public void updateSalesAmount(double amount) {
        this.salesAmount = salesAmount + amount;
    }

    //implement this
    public void updateFirstSalesDate(LocalDateTime dt) {

        firstSaleOn = getMinDate(dt, firstSaleOn);
    }

    //implement this
    public void updateLastSalesDate(LocalDateTime dt) {
        lastSaleOn = getMaxDate(dt, firstSaleOn);
    }

    @Override
    public String toString() {
        return "ProductStatistics{" +
                "firstSaleOn=" + firstSaleOn +
                ", lastSaleOn=" + lastSaleOn +
                ", salesAmount=" + salesAmount +
                '}';
    }
}
