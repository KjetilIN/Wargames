/**
 * This class represents a unit.
 * @author Kjetil Indrehus
 * @version 1.0-SNAPSHOT 31.01.22
 */
public class Unit {
    private  String name;
    private int health;
    private int attack;
    private int armor;

    /**
     * This is a constructor for the Unit class
     * @param name The name of the unit
     * @param health the health of the unit
     * @param attack the attack of the unit
     * @param armor the armor of a unit
     */
    public Unit(String name, int health, int attack, int armor) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.armor = armor;
    }

    public String getName(){
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getArmor() {
        return armor;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * This method return basic information about a unit in a string.
     * @return returns a string of information
     */
    @Override
    public String toString(){
        return "Name: "+name + "::HP: "+health +"::Attack: "+attack;
    }

    // TODO: 02.02.2022 add attack class and abstract methods
    public boolean attack(Unit unit){
        if(this.attack != 0){
            try{
                //unit.setHealth(unit.getHealth()-(this.attack));
                return true;
            }catch (ArithmeticException e){
                return false;
            }

        }
        return false;


    }
}
