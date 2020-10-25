package com.infoshare.activities;

public class Activity {

    private SportDisciplines sportDisciplines;
    private ActivityLevel activityLevel;

    public Activity(SportDisciplines sportDisciplines, ActivityLevel activityLevel) {
        this.sportDisciplines = sportDisciplines;
        this.activityLevel = activityLevel;
    }

    public SportDisciplines getSportDisciplines() {
        return sportDisciplines;
    }

    public ActivityLevel getActivityLevel() {
        return activityLevel;
    }

}
