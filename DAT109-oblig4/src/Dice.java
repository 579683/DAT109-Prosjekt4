//%% NEW FILE Dice BEGINS HERE %%

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4823.43e750332 modeling language!*/


import java.util.Random;

// line 30 "model.ump"
// line 72 "model.ump"
public class Dice
{

    //------------------------
    // MEMBER VARIABLES
    //------------------------

    //Dice Attributes
    private int antallOyne;

    //------------------------
    // CONSTRUCTOR
    //------------------------

    public Dice(int aAntallOyne)
    {
        antallOyne = aAntallOyne;
    }

    //------------------------
    // INTERFACE
    //------------------------

    public boolean setAntallOyne(int aAntallOyne)
    {
        boolean wasSet = false;
        antallOyne = aAntallOyne;
        wasSet = true;
        return wasSet;
    }

    public int getAntallOyne()
    {
        return antallOyne;
    }

    public void delete()
    {}


    /**
     * implement
     */
    // line 35 "model.ump"
    public int roll(){
        Random random = new Random();
        return random.nextInt(antallOyne) + 1;
    }


    public String toString()
    {
        return super.toString() + "["+
                "antallOyne" + ":" + getAntallOyne()+ "]";
    }
}