
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final int AntallOyne = 6;

    public static void main(String[] args) {
        DiceCup diceCup = new DiceCup(new Dice(AntallOyne), new Dice(AntallOyne));

        Craps craps = new Craps(diceCup);
        craps.play();

    }
}

