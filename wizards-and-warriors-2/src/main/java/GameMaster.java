public class GameMaster {
    private static final String BLANK_SPACE = " ";
    private static final TravelMethod DEFAULT_METHOD_WALKING = TravelMethod.WALKING;

    public String describe(Character character) {
        return String.format("You're a level %d %s with %d hit points.", character.getLevel(), character.getCharacterClass(), character.getHitPoints());
    }

    public String describe(Destination destination) {
        return String.format("You've arrived at %s, which has %d inhabitants.",destination.getName(), destination.getInhabitants());
    }

    public String describe(TravelMethod travelMethod) {
        return travelMethod.equals(TravelMethod.HORSEBACK) ?
                "You're traveling to your destination on horseback.":
                "You're traveling to your destination by walking.";
    }

    public String describe(Character character, Destination destination, TravelMethod travelMethod) {
        return describe(character) + BLANK_SPACE + describe(travelMethod) + BLANK_SPACE + describe(destination);
    }

    public String describe(Character character, Destination destination) {
        return describe(character, destination, DEFAULT_METHOD_WALKING);
    }

}
