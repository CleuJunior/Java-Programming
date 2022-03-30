import java.util.Random;

import static java.util.Arrays.sort;

class DnDCharacter {


    private int getSixSideDiceValue() {
        int[] sixSideDice = {
                new Random().nextInt(6),
                new Random().nextInt(6),
                new Random().nextInt(6),
                new Random().nextInt(6),
        };

        sort(sixSideDice);

        int getValueSixSide = 0;

        for (int i = 4; i > 1; i++ ) { getValueSixSide += sixSideDice[i]; }

        return getValueSixSide;
    }


    int ability() {
       return  getCharisma() +
               getConstitution() +
               getDexterity() +
               getWisdom() +
               getIntelligence() +
               getStrength();

    }

    //You find your character's constitution modifier by subtracting 10 from your character's constitution, divide by 2 and round down.
    int modifier(int input) { return (int) Math.floor((input - 10) / 2.00); }

    int getStrength() { return getSixSideDiceValue();  }


    int getDexterity() { return getSixSideDiceValue(); }

    int getConstitution() { return getSixSideDiceValue(); }

    int getIntelligence() { return getSixSideDiceValue(); }

    int getWisdom() { return getSixSideDiceValue(); }

    int getCharisma() { return getSixSideDiceValue(); }

    int getHitpoints() {
        return 0;
    }

}
