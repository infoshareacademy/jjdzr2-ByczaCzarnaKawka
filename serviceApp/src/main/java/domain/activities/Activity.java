package domain.activities;

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

    @Override
    public String toString() {

        return "\nActivity{\n sportDisciplines="
                + sportDisciplines
                + ", \n activityLevel="
                + activityLevel
                + '}';
    }
}
