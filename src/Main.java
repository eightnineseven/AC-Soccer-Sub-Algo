import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static boolean validInput = false;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int selection = Utility.DEFAULT;
        while(Utility.continueSubs==true) {

            switch (selection) {
                case (Utility.BEGIN):
                    System.out.println("Match Begun!");
                    System.out.println("Please import player stats below: ");
                    int numberOfPlayers = 0;
                    System.out.print("How many players are on the squad: ");
                    validInput = false;
                    while(!validInput) {
                        try {
                            numberOfPlayers = scanner.nextInt();
                            validInput = true;
                        } catch(Exception e){
                            System.out.print("Please input the number of players on squad: ");
                            validInput = false;
                        }finally{
                            scanner.nextLine();
                        }
                    }

                   //get and store player stats
                    Player.addPlayers(numberOfPlayers, scanner);

                    System.out.println("Please import pre match stats below: ");
                    System.out.println("Please input the starting team formation:");
                    String teamFormation = scanner.nextLine();

                    System.out.println("Please input the opponent formation:");
                    String oppFormation = scanner.nextLine();

                    System.out.println("Please input weather conditions (Sunny/Raining):"); // Not sure if we really need this but maybe it would affect whether defense or offense is better?
                    String weather = scanner.nextLine();

                    PrematchStats preMatchStats = new PrematchStats(teamFormation, oppFormation, weather);
                    //get and store the prematch stats
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
                    validInput = false;
                    System.out.println();
                    System.out.println("Welcome to the substitution optimizer!");
                    System.out.println("Which of the following would you like to do?");
                    System.out.println("1. Begin the optimizer");
                    System.out.println("2. Update match statistics");
                    System.out.println("3. Make a substitution");
                    System.out.println("4. End the optimizer");
                    System.out.print("Selection: ");
                    try {
                        selection = scanner.nextInt();
                        validInput = true;
                    } catch(Exception e){
                        System.out.println("Please input your desired choice!");
                        validInput = false;
                    } finally{
                        scanner.nextLine();
                }

                break;
            }
        }

    }
}