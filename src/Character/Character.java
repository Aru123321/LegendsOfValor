package Character;

public abstract class Character {
    protected String name;
    protected int HP;
    protected int level;
    protected boolean alive = true;



    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public int getHP() {
        return HP;
    }

    public abstract boolean dodge();

    public boolean getAlive() {
        return alive;
    }

    public boolean isAlive() {
        if(HP <= 0){
            alive = false;
            return false;

        }
        return true;
    }

    public void hasDamage(int damage , Character hero) {
        HP = HP - damage;
        System.out.println(name+" take "+damage+ " damage.");
        if(!isAlive()){

            System.out.println(name+" loses all HP and dies.");
        }
    }

}
