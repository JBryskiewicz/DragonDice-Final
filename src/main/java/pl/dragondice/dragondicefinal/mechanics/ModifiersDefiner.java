package pl.dragondice.dragondicefinal.mechanics;

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
}
