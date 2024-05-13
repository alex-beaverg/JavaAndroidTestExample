package com.beaverg.utils;

import com.beaverg.domain.AutoCard;
import com.beaverg.pages.OnlineBuyingAutoCardPage;
import com.beaverg.pages.AutoCardsPage;
import com.beaverg.pages.SearchAutoCardPage;

public class AutoCardService {

    public static AutoCard createAutoCardByIndex(AutoCardsPage page, int index) {
        AutoCard card = new AutoCard();
        card.setTitle(page.getTitleByIndex(index));
        card.setPrice(page.getPriceByIndex(index));
        card.setFirstRegistration(page.getFirstRegistrationByIndex(index));
        card.setMileage(page.getMileageByIndex(index));
        card.setPerformance(page.getPerformanceByIndex(index));
        return card;
    }

    public static AutoCard createOnlineBuyingAutoCard(OnlineBuyingAutoCardPage page) {
        AutoCard card = new AutoCard();
        card.setTitle(page.getTitle());
        card.setPrice(page.getPrice());
        card.setFirstRegistration(page.getFirstRegistration());
        card.setMileage(page.getMileage());
        card.setPerformance(page.getPerformance());
        return card;
    }

    public static AutoCard createSearchAutoCard(SearchAutoCardPage page, double percentageForSwiping) {
        AutoCard card = new AutoCard();
        card.setTitle(page.getTitle());
        card.setPrice(page.getPrice());
        card.setFirstRegistration(page.getFirstRegistration(percentageForSwiping));
        card.setMileage(page.getMileage());
        card.setPerformance(page.getPerformance());
        return card;
    }
}
