package com.infoshare.workoutPlaces;

import com.infoshare.activities.Activity;

public class Playground {

    private Activity activity;
    private boolean isItOutside;
    private double pricePerHour;
    private int minNoPlayers;
    private int maxNoPlayers;

    public Playground(Activity activity, boolean isItOutside, double pricePerHour, int minNoPlayers, int maxNoPlayers) {
        this.activity = activity;
        this.isItOutside = isItOutside;
        this.pricePerHour = pricePerHour;
        this.minNoPlayers = minNoPlayers;
        this.maxNoPlayers = maxNoPlayers;
    }

    public Activity getActivity() {
        return activity;
    }

    public boolean isItOutside() {
        return isItOutside;
    }

    public void setItOutside(boolean itOutside) {
        isItOutside = itOutside;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public int getMinNoPlayers() {
        return minNoPlayers;
    }

    public int getMaxNoPlayers() {
        return maxNoPlayers;
    }
}
