public class Technology {

    private int understanding;
    private boolean foundMeaningOfLife;
    private int experienceLevel;
    private boolean builtWonderOfTheWorld;

    public Technology() {
        understanding = 0;
        foundMeaningOfLife = false;
        experienceLevel = 0;
        builtWonderOfTheWorld = false;
    }

    public int getBuildExperience() {
        return experienceLevel;
    }

    public int getUnderstanding() {
        return understanding;
    }

    public void philosophize() {
        understanding += 25;
        if (understanding > 200) {
            foundMeaningOfLife = true;
        }
    }

    public void improveWriting() {
        understanding += 10;
        if (understanding > 200) {
            foundMeaningOfLife = true;
        }
    }

    public void increaseExperience(int value) {
        experienceLevel += value;
        if (experienceLevel > 200) {
            builtWonderOfTheWorld = true;
        }
    }

    public boolean hasTechnologyWin() {
        if (foundMeaningOfLife && builtWonderOfTheWorld) {
            return true;
        }
        return false;
    }

}