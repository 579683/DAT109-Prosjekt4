//%% NEW FILE DiceCup BEGINS HERE %%

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4823.43e750332 modeling language!*/


import java.util.*;

// line 40 "model.ump"
// line 77 "model.ump"
public class DiceCup
{

    //------------------------
    // MEMBER VARIABLES
    //------------------------

    //DiceCup Attributes
    private int diceSum;

    //DiceCup Associations
    private List<Dice> dices;

    //------------------------
    // CONSTRUCTOR
    //------------------------

    public DiceCup(Dice... allDices)
    {
        diceSum = 0;
        dices = new ArrayList<Dice>();
        boolean didAddDices = setDices(allDices);
        if (!didAddDices)
        {
            throw new RuntimeException("Unable to create DiceCup, must have at least 1 dices. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
        }
    }

    //------------------------
    // INTERFACE
    //------------------------

    public boolean setDiceSum(int aDiceSum)
    {
        boolean wasSet = false;
        diceSum = aDiceSum;
        wasSet = true;
        return wasSet;
    }

    public int getDiceSum()
    {
        return diceSum;
    }
    /* Code from template association_GetMany */
    public Dice getDice(int index)
    {
        Dice aDice = dices.get(index);
        return aDice;
    }

    public List<Dice> getDices()
    {
        List<Dice> newDices = Collections.unmodifiableList(dices);
        return newDices;
    }

    public int numberOfDices()
    {
        int number = dices.size();
        return number;
    }

    public boolean hasDices()
    {
        boolean has = dices.size() > 0;
        return has;
    }

    public int indexOfDice(Dice aDice)
    {
        int index = dices.indexOf(aDice);
        return index;
    }
    /* Code from template association_MinimumNumberOfMethod */
    public static int minimumNumberOfDices()
    {
        return 1;
    }
    /* Code from template association_AddUnidirectionalMStar */
    public boolean addDice(Dice aDice)
    {
        boolean wasAdded = false;
        if (dices.contains(aDice)) { return false; }
        dices.add(aDice);
        wasAdded = true;
        return wasAdded;
    }

    public boolean removeDice(Dice aDice)
    {
        boolean wasRemoved = false;
        if (!dices.contains(aDice))
        {
            return wasRemoved;
        }

        if (numberOfDices() <= minimumNumberOfDices())
        {
            return wasRemoved;
        }

        dices.remove(aDice);
        wasRemoved = true;
        return wasRemoved;
    }
    /* Code from template association_SetUnidirectionalMStar */
    public boolean setDices(Dice... newDices)
    {
        boolean wasSet = false;
        ArrayList<Dice> verifiedDices = new ArrayList<Dice>();
        for (Dice aDice : newDices)
        {
            if (verifiedDices.contains(aDice))
            {
                continue;
            }
            verifiedDices.add(aDice);
        }

        if (verifiedDices.size() != newDices.length || verifiedDices.size() < minimumNumberOfDices())
        {
            return wasSet;
        }

        dices.clear();
        dices.addAll(verifiedDices);
        wasSet = true;
        return wasSet;
    }
    /* Code from template association_AddIndexControlFunctions */
    public boolean addDiceAt(Dice aDice, int index)
    {
        boolean wasAdded = false;
        if(addDice(aDice))
        {
            if(index < 0 ) { index = 0; }
            if(index > numberOfDices()) { index = numberOfDices() - 1; }
            dices.remove(aDice);
            dices.add(index, aDice);
            wasAdded = true;
        }
        return wasAdded;
    }

    public boolean addOrMoveDiceAt(Dice aDice, int index)
    {
        boolean wasAdded = false;
        if(dices.contains(aDice))
        {
            if(index < 0 ) { index = 0; }
            if(index > numberOfDices()) { index = numberOfDices() - 1; }
            dices.remove(aDice);
            dices.add(index, aDice);
            wasAdded = true;
        }
        else
        {
            wasAdded = addDiceAt(aDice, index);
        }
        return wasAdded;
    }

    public void delete()
    {
        dices.clear();
    }


    /**
     * implement
     */
    // line 47 "model.ump"
    public boolean isSeven(){
        return diceSum == 7;
    }


    /**
     * implement
     */
    // line 53 "model.ump"
    public void rollDices(){

    }


    public String toString()
    {
        return super.toString() + "["+
                "diceSum" + ":" + getDiceSum()+ "]";
    }
}
