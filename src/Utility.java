import java.util.ArrayList;
import java.util.List;

public class Utility {
    //This file is just going to be used to store values we dont want to keep reffering to. The ints here are just being
    //used for arrays and the switch case so we have a word representing what is happening instead of just the numebr.
    public enum Position{
        DEFENDER,
        MIDFIELDER,
        FORWARD
    }
    public int subsLeft = 5;
    public static List<Player> forwards = new ArrayList<>();
    public static List<Player> midfielders = new ArrayList<>();
    public static List<Player> defenders = new ArrayList<>();
    public static String nameOfPlayer;
    public static int numberOfPlayer;
    public static double injuryRatingOfPlayer;
    public static double performanceRatingOfPlayer;
    public static Position positionOfPlayer;
    public static double passingRatingOfPlayer;
    public static double dribblingRatingOfPlayer;
    public static double shootingRatingOfPlayer;





    //never going to change as they are for the array/switch
    public final int GOALS = 0;
    public final int PASSES = 1;
    public final int SHOTS = 2;
    public static final int BEGIN = 1;
    public static final int UPDATE = 2;
    public static final int SUB = 3;
    public static final int END = 4;
    public static final int DEFAULT = 5;
    public static boolean continueSubs = true;
    public static int[] formation = new int[3];
}
