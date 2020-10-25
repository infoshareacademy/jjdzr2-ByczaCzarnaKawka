package com.infoshare.activities;

public class Activity {

    private SportDisciplines sportDisciplines;
    private ActivityLevel activityLevel;

    public Activity(SportDisciplines sportDisciplines, ActivityLevel activityLevel) {
        this.sportDisciplines = sportDisciplines;
        this.activityLevel = activityLevel;
    }

    public void printActivities(){
        System.out.println("Discipline: " + sportDisciplines.toString());
        System.out.println("level: " + activityLevel.toString());
    }

    public SportDisciplines getSportDisciplines() {
        return sportDisciplines;
    }

    public ActivityLevel getActivityLevel() {
        return activityLevel;
    }

}
