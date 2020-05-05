//%% NEW FILE Craps BEGINS HERE %%

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4823.43e750332 modeling language!*/



// line 2 "model.ump"
// line 67 "model.ump"

public class Craps
{

    //------------------------
    // MEMBER VARIABLES
    //------------------------

    //Craps State Machines
    public enum State { player, win, lose }
    private State state;

    //Craps Associations
    private DiceCup diceCup;

    //------------------------
    // CONSTRUCTOR
    //------------------------

    public Craps(DiceCup aDiceCup)
    {
        if (!setDiceCup(aDiceCup))
        {
            throw new RuntimeException("Unable to create Craps due to aDiceCup. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
        }
        setState(State.player);
    }

    //------------------------
    // INTERFACE
    //------------------------

    public String getStateFullName()
    {
        String answer = state.toString();
        return answer;
    }

    public State getState()
    {
        return state;
    }

    public boolean play()
    {
        boolean wasEventProcessed = false;

        State aState = state;
        switch (aState)
        {
            case player:
                if (getDiceCup().isSeven())
                {
                    setState(State.win);
                    wasEventProcessed = true;
                    break;
                }
                if (!(getDiceCup().isSeven()))
                {
                    setState(State.lose);
                    wasEventProcessed = true;
                    break;
                }
                break;
            default:
                // Other states do respond to this event
        }

        return wasEventProcessed;
    }

    private void setState(State aState)
    {
        state = aState;

        // entry actions and do activities
        switch(state)
        {
            case player:
                // line 7 "model.ump"
                getDiceCup().rollDices();
                break;
            case win:
                // line 13 "model.ump"
                winner();
                break;
            case lose:
                // line 16 "model.ump"
                loser();
                break;
        }
    }
    /* Code from template association_GetOne */
    public DiceCup getDiceCup()
    {
        return diceCup;
    }
    /* Code from template association_SetUnidirectionalOne */
    public boolean setDiceCup(DiceCup aNewDiceCup)
    {
        boolean wasSet = false;
        if (aNewDiceCup != null)
        {
            diceCup = aNewDiceCup;
            wasSet = true;
        }
        return wasSet;
    }

    public void delete()
    {
        diceCup = null;
    }


    /**
     * implement
     */
    // line 22 "model.ump"
    public void winner(){
        System.out.println("Congrats, you won!");
    }

    // line 25 "model.ump"
    public void loser(){
        System.out.println("Sorry, you lost!");
    }

}