import java.util.Random;

class DnDCharacter {

    private final int STRENGTH;
    private final int DEXTERITY;
    private final int CONSTITUTION;
    private final int INTELLIGENCE;
    private final int WISDOM;
    private final int CHARISMA;
    private final int HITPOINTS;


    public DnDCharacter() {
        STRENGTH = getSixSideDiceValue();
        DEXTERITY = getSixSideDiceValue();
        CONSTITUTION = getSixSideDiceValue();
        INTELLIGENCE = getSixSideDiceValue();
        WISDOM = getSixSideDiceValue();
        CHARISMA = getSixSideDiceValue();
        HITPOINTS = 10 + modifier(CONSTITUTION);

    }


    private int getSixSideDiceValue() {
        int[] sixSideDice = new int[4];
        int getValueSixSide = 0;

        for (int i = 0; i < 4; i++) { sixSideDice[i] = (int) Math.floor(new Random().nextInt(1, 7)); }
        for (int i = 3; i > 0; i--) { getValueSixSide += sixSideDice[i]; }

        return getValueSixSide;
    }


    int ability() {
        int abilityTotal = CHARISMA     +
                           WISDOM       +
                           DEXTERITY    +
                           INTELLIGENCE +
                           STRENGTH     +
                           CONSTITUTION;

        return Math.floorDiv(abilityTotal, 6);
    }

    int modifier(int input) { return (int) Math.floor((input - 10) / 2d); }
    int getStrength() { return STRENGTH;  }
    int getDexterity() { return DEXTERITY; }
    int getConstitution() { return CONSTITUTION; }
    int getIntelligence() { return INTELLIGENCE; }
    int getWisdom() { return WISDOM; }
    int getCharisma() { return CHARISMA; }
    int getHitpoints() { return HITPOINTS; }

}
