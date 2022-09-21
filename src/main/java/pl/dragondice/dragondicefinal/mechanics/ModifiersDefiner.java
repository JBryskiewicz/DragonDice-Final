package pl.dragondice.dragondicefinal.mechanics;
//TODO Make it look better than that whenever possible
public class ModifiersDefiner {
    /* checks ability score and return modifier that will be added to "dice rolls" */
    public static int abilityModifier(int abilityScore) {
        if (abilityScore == 8 || abilityScore == 9) {
            return -1;
        } else if (abilityScore == 10 || abilityScore == 11) {
            return 0;
        } else if (abilityScore == 12 || abilityScore == 13) {
            return 1;
        } else if (abilityScore == 14 || abilityScore == 15) {
            return 2;
        } else if (abilityScore == 16 || abilityScore == 17) {
            return 3;
        } else if (abilityScore == 18 || abilityScore == 19) {
            return 4;
        } else if (abilityScore == 20 || abilityScore == 21) {
            return 5;
        } else if (abilityScore == 22 || abilityScore == 23) {
            return 6;
        } else if (abilityScore == 24 || abilityScore == 25) {
            return 7;
        } else if (abilityScore == 26 || abilityScore == 27) {
            return 8;
        } else if (abilityScore == 28 || abilityScore == 29) {
            return 9;
        } else if (abilityScore >= 30) {
            return 10;
        } else {
            return -2;
        }
    }

    /* checks character level and returns proficiency */
    public static int proficiency(int characterLevel) {
        if (characterLevel >= 1 && characterLevel <= 4) {
            return 2;
        } else if (characterLevel > 4 && characterLevel <= 8) {
            return 3;
        } else if (characterLevel > 8 && characterLevel <= 12) {
            return 4;
        } else if (characterLevel > 12 && characterLevel <= 16) {
            return 5;
        } else {
            return 6;
        }
    }

    /* checks character level and how many possible ability score increases will be displayed in form */
    public static int checkLevel(int characterLevel) {
        int numberOfIncreases;
        if (characterLevel >= 19) {
            numberOfIncreases = 8;
        } else if (characterLevel >= 16) {
            numberOfIncreases = 7;
        } else if (characterLevel >= 14) {
            numberOfIncreases = 6;
        } else if (characterLevel >= 12) {
            numberOfIncreases = 5;
        } else if (characterLevel >= 10) {
            numberOfIncreases = 4;
        } else if (characterLevel >= 8) {
            numberOfIncreases = 3;
        } else if (characterLevel >= 6) {
            numberOfIncreases = 2;
        } else if (characterLevel >= 4) {
            numberOfIncreases = 1;
        } else {
            numberOfIncreases = 0;
        }
        return numberOfIncreases;
    }
}
