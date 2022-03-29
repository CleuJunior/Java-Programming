abstract class Fighter {

    boolean isVulnerable() { return false; }

    abstract int damagePoints(Fighter fighter);

}

class Warrior extends Fighter {

    @Override
    public String toString() { return "Fighter is a Warrior"; }

    @Override
    int damagePoints(Fighter wizard) { return wizard.isVulnerable() ? 10 : 6; }

}

class Wizard extends Fighter {

    private boolean vulnerability = true;
    @Override
    boolean isVulnerable() { return vulnerability; }

    @Override
    int damagePoints(Fighter warrior) { return vulnerability ? 3 : 12; }

    void prepareSpell() { vulnerability = false; }

}
