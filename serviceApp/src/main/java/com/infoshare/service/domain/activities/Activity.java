package com.infoshare.service.domain.activities;

public class Activity {

    private SportDiscipline sportDiscipline;
    private ActivityLevel activityLevel;

    public Activity(SportDiscipline sportDiscipline, ActivityLevel activityLevel) {
        this.sportDiscipline = sportDiscipline;
        this.activityLevel = activityLevel;
    }

    public SportDiscipline getSportDisciplines() {
        return sportDiscipline;
    }

    public ActivityLevel getActivityLevel() {
        return activityLevel;
    }

    @Override
    public String toString() {

        return "\nActivity{\n sportDiscipline="
                + sportDiscipline
                + ", \n activityLevel="
                + activityLevel
                + '}';
    }
}
