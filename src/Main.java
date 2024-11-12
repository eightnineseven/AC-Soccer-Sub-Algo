import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int selection = Utility.DEFAULT;
        while(Utility.continueSubs==true) {

            switch (selection) {
                case (Utility.BEGIN):
                    System.out.println("Match Begun!");
                    int numberOfPlayers;
                    System.out.print("How many players are on the squad: ");
                    numberOfPlayers = scanner.nextInt();
                    System.out.println("Please import player stats below: ");
                   //get and store player stats
                    Player.addPlayers(numberOfPlayers, scanner);

                    System.out.println("Please import pre match stats below: ");
                    //get and store the prematch stats
                    selection=Utility.DEFAULT;
                    break;
                case (Utility.UPDATE):
                    System.out.println("Please add updated stats below: ");
                    //get and store updated match stats
                    selection=Utility.DEFAULT;
                    break;
                case (Utility.SUB):
                    //output the sub the algo thinks should be used
                    selection=Utility.DEFAULT;
                    break;
                case (Utility.END):
                    Utility.continueSubs = false;
                    selection=Utility.DEFAULT;
                    break;
                case (Utility.DEFAULT):
                    System.out.println();
                    System.out.println("Welcome to the substitution optimizer!");
                    System.out.println("Which of the following would you like to do?");
                    System.out.println("1. Begin the optimizer");
                    System.out.println("2. Update match statistics");
                    System.out.println("3. Make a substitution");
                    System.out.println("4. End the optimizer");
                    System.out.print("Selection: ");

                    selection = scanner.nextInt();
                break;
            }
        }

    }
}