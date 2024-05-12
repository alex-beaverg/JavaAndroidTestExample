package com.beaverg.domain;

import java.util.Objects;

public class AutoCard {
    private String title;
    private int price;
    private String firstRegistration;
    private int mileage;
    private String performance;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setFirstRegistration(String firstRegistration) {
        this.firstRegistration = firstRegistration;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AutoCard autoCard = (AutoCard) o;
        return price == autoCard.price &&
                mileage == autoCard.mileage &&
                Objects.equals(title, autoCard.title) &&
                Objects.equals(firstRegistration, autoCard.firstRegistration) &&
                Objects.equals(performance, autoCard.performance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, price, firstRegistration, mileage, performance);
    }

    @Override
    public String toString() {
        return "Auto card: [" + title + ", " + price + ", " + firstRegistration + ", " + mileage + ", " + performance + "]";
    }
}
