package no.ntnu.wargames.backend.units;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * The Army class that holds all the units for a single class.
 * This class has all the methods for the list of units.
 *
 * @author Kjetil Indrehus
 * @version 1.0-SNAPSHOT 09.02.2022
 */

public class Army {
    private String name;
    private List<Unit> units;
    private Random random;

    /**
     * Constructor for the army.
     * This constructor takes only a name of the army.
     * Initialise the list as ArrayList.
     * Throws exception if name is empty or null.
     *
     * @param name name of the army.
     */
    public Army(String name) throws IllegalArgumentException, NullPointerException{
        if(name.isEmpty()){
            throw new IllegalArgumentException("No name given");
        }else if(name == null){
            throw new NullPointerException("Value given was null");
        }else{
            this.name = name;
        }

        units = new ArrayList<>();
    }

    /**
     * Constructor for the army class with two parameters.
     *
     * @param name name of the unit
     * @param units a list of units that is the total amount of units.
     */
    public Army(String name, List<Unit> units) throws IllegalArgumentException{
        if(name.isEmpty() || (name == null && units != null)){
            throw new IllegalArgumentException("No name given");
        }else if(units == null){
            throw new IllegalArgumentException("Units was empty object");
        }else{
            this.name = name;
        }


        this.units = units;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the name of the army.
     *
     * @return return the name of the army.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Method that adds a unit to the army.
     *
     * @param unit the unit to be added in the army.
     */

    public void add(Unit unit){
        units.add(unit);
    }

    /**
     * Method that adds a list of units to the army.
     *
     * @param newUnits a list of units to be added to the army.
     */

    public void addAll(List<Unit> newUnits){
        units.addAll(newUnits);
    }

    /**
     * Removes a unit from the army.
     *
     * @param unit the unit to be removed from the army.
     */
    public void remove(Unit unit){
        if(unit == null){throw new IllegalArgumentException("No unit is given.");}
        if(this.units.isEmpty()){ throw new IllegalArgumentException("Empty army have no unit to remove");}
        units.remove(unit);
    }

    /**
     * Method that check if there is anyone in the army.
     * Returns a boolean value.
     *
     * @return returns true if the army has units.
     */
    public boolean hasUnits(){
        return !units.isEmpty();
    }

    /**
     * A method that return all the units in the army.
     *
     * @return returns a list of unit that is in the army.
     */
    public List<Unit> getAllUnits(){
        return units;
    }

    /**
     * A method that gets all the InfantryUnits.
     *
     * @return returns a list of infantry units.
     */
    public List<Unit> getInfantryUnits(){
        return this.units.stream().filter(InfantryUnit.class::isInstance).collect(Collectors.toList());
    }

    /**
     * A method that gets all the CavalryUnit.
     *
     * @return returns a list of Cavalry-units.
     */
    public List<Unit> getCavalryUnits(){
        return this.units.stream().filter(CavalryUnit.class::isInstance).collect(Collectors.toList());
    }

    /**
     * A method that gets all the RangedUnit.
     *
     * @return returns a list of Ranged-units.
     */
    public List<Unit> getRangedUnits(){
        return this.units.stream().filter(RangedUnit.class::isInstance).collect(Collectors.toList());
    }

    /**
     * A method that gets all the CommanderUnit.
     *
     * @return returns a list of Commander-units.
     */
    public List<Unit> getCommanderUnits(){
        return this.units.stream().filter(CommanderUnit.class::isInstance).collect(Collectors.toList());
    }

    /**
     * Gets a random unit from the army.
     *
     * @return returns a random unit from the army.
     */
    public Unit getRandomUnit(){
        // TODO: 18.02.2022 Ask if needed to make new random (random class?)
        random = new Random();
        return units.get(random.nextInt(getAllUnits().size()));
    }

    /**
     * A method returns information about the army.
     *
     * @return returns a string with info about the army.
     */
    @Override
    public String toString() {
        return "Army{" + "name='" + name + '\'' + ", units size =" + units.size() + '}';
    }

    /**
     * Method that check if the object given is the same as the army class.
     *
     *
     * @param o The object that is compared to the army
     * @return return true if the object is the same as the army class
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Army)) return false;
        Army army = (Army) o;
        return getName().equals(army.getName()) && units.equals(army.units);
    }

    /**
     * Method that gives a hashcode for the army using name and units.
     *
     * @return return the hashcode for the army.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getName(), units);
    }
}
