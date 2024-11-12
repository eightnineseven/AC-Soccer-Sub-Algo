import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    Utility.Position position;
    double injuryProneRating;
    double performanceRating;
    int jerseyNumber;
    String playerName;
    public static boolean validInput = false;
    public Player(Utility.Position position, double injuryProneRating, double performanceRating, int jerseyNumber, String playerName){
        this.position = position;
        this.injuryProneRating = injuryProneRating;
        this.performanceRating = performanceRating;
        this.jerseyNumber = jerseyNumber;
        this.playerName = playerName;
    }
    public Utility.Position getPosition(){return this.position;}
    public String getPlayerName(){return this.playerName;}
    public int getJerseyNumber(){return this.jerseyNumber;}
    public double getInjuryProneRating(){return injuryProneRating;}
    public double getPerformanceRating(){return performanceRating;}
    public static void addPlayers(int numberOfPlayers, Scanner scanner){
        for(int i=0; i <numberOfPlayers; i++) {
            //add try catch or while for each of these to make sure correct data type is entered so we dont terminate code.
            System.out.print("Player name: ");
            while(!validInput) {
                try {

                    Utility.nameOfPlayer = scanner.next();
                    validInput = true;
                } catch (Exception e) {
                    System.out.println("Please input a name: ");
                } finally{
                    scanner.nextLine();
                }
            }
            validInput = false;

                System.out.print("Player number: ");
                while(!validInput) {
                    try {

                        Utility.numberOfPlayer = scanner.nextInt();
                        validInput = true;
                    } catch (Exception e) {
                        validInput = false;
                        System.out.print("Please input the player's number: ");
                    } finally{
                        scanner.nextLine();
                    }
                }
                validInput = false;
            System.out.print("Player Position (1 for defender, 2 for midfielder, and 3 for forward: ");
            while(!validInput) {
                try {

                    int posNumb = scanner.nextInt();
                    if (posNumb == 1) {
                        Utility.positionOfPlayer = Utility.Position.FORWARD;
                    } else if (posNumb == 2) {
                        Utility.positionOfPlayer = Utility.Position.MIDFIELDER;
                    } else if (posNumb == 3) {
                        Utility.positionOfPlayer = Utility.Position.DEFENDER;
                    }
                    if (posNumb > 3 || posNumb < 1) {

                        Exception Exception = new Exception();
                        throw Exception;
                    }
                    validInput = true;
                } catch (Exception e) {
                    validInput = false;
                    System.out.print("Please input the player position as either a 1, 2, or 3: ");
                } finally{
                    scanner.nextLine();
                }
            }
            validInput = false;

            System.out.print("Injury Rating of player: ");
            while(!validInput) {
                try{
                    Utility.injuryRatingOfPlayer = scanner.nextDouble();
                    validInput = true;
                }catch(Exception e){
                    System.out.print("Please input the injury rating: ");
                    validInput = false;
                } finally{
                    scanner.nextLine();
                }

            }
            validInput = false;

            System.out.print("Performance rating of player: ");
            while(!validInput) {
                try {
                    Utility.performanceRatingOfPlayer = scanner.nextDouble();

                    Player player = new Player(Utility.positionOfPlayer, Utility.injuryRatingOfPlayer, Utility.performanceRatingOfPlayer, Utility.numberOfPlayer, Utility.nameOfPlayer);
                    if (player.getPosition().equals(Utility.Position.FORWARD)) {
                        Utility.forwards.add(player);
                    } else if (player.getPosition().equals(Utility.Position.MIDFIELDER)) {
                        Utility.midfielders.add(player);
                    } else {
                        Utility.defenders.add(player);

                    }
                    validInput = true;
                } catch(Exception e){
                    System.out.print("Please input the performance rating of player: ");
                    validInput = false;
                } finally{
                    scanner.nextLine();
                }
            }
        }
    }
    public static List<Player> sortPlayers(List<Player> players, InMatchStats stats){
        int size = players.size();
        double rating = 0;
        double rating2 = 0;

        double highestRating=0;
        List<Player> sortedList = new ArrayList<Player>();
        List<Player> temp = new ArrayList<Player>();
        sortedList = players;
        for(int i = 0; i < size; i++){
                for(int j = 0; j < size-i-1; j++){
                    rating = players.get(j).performanceRating/4- (players.get(j).injuryProneRating/stats.getMinsPlayed()) ;
                    rating2 = players.get(j+1).performanceRating/4-(players.get(j+1).injuryProneRating/stats.getMinsPlayed());
                    if(rating > rating2){
                        temp.add(sortedList.get(j));
                        sortedList.set(j,sortedList.get(j+1));
                        sortedList.set(j+1,temp.get(0));
                        temp.clear();
                    }

                }
            }
        return sortedList;
        }
    }


