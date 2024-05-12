package com.beaverg.utils;

import com.beaverg.domain.AutoCard;
import com.beaverg.pages.AutoCardPage;
import com.beaverg.pages.OnlineBuyingPage;

public class AutoCardService {

    public static AutoCard createOnlineBuyingAutoCardByIndex(OnlineBuyingPage page, int index) {
        AutoCard card = new AutoCard();
        card.setTitle(page.getTitleByIndex(index));
        card.setPrice(page.getPriceByIndex(index));
        card.setFirstRegistration(page.getFirstRegistrationByIndex(index));
        card.setMileage(page.getMileageByIndex(index));
        card.setPerformance(page.getPerformanceByIndex(index));
        return card;
    }

    public static AutoCard createAutoCard(AutoCardPage page) {
        AutoCard card = new AutoCard();
        card.setTitle(page.getTitle());
        card.setPrice(page.getPrice());
        card.setFirstRegistration(page.getFirstRegistration());
        card.setMileage(page.getMileage());
        card.setPerformance(page.getPerformance());
        return card;
    }
}
