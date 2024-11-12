import java.util.Scanner;

public class Player {
    Utility.Position position;
    double injuryProneRating;
    double performanceRating;
    int jerseyNumber;
    String playerName;
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
            Utility.nameOfPlayer = scanner.next();


            System.out.print("Player number: ");
            Utility.numberOfPlayer = scanner.nextInt();

                System.out.print("Player Position (1 for defender, 2 for midfielder, and 3 for forward: ");
                int posNumb = scanner.nextInt();
                if (posNumb == 1) {
                    Utility.positionOfPlayer = Utility.Position.FORWARD;
                } else if (posNumb == 2) {
                    Utility.positionOfPlayer = Utility.Position.MIDFIELDER;
                } else if (posNumb == 3) {
                    Utility.positionOfPlayer = Utility.Position.DEFENDER;
                }

            System.out.print("Injury Rating of player: ");
            Utility.injuryRatingOfPlayer = scanner.nextDouble();


            System.out.print("Performance rating of player: ");
            Utility.performanceRatingOfPlayer = scanner.nextDouble();

            Player player = new Player(Utility.positionOfPlayer, Utility.injuryRatingOfPlayer, Utility.performanceRatingOfPlayer, Utility.numberOfPlayer, Utility.nameOfPlayer);
            if (player.getPosition().equals(Utility.Position.FORWARD)) {
                Utility.forwards.add(player);
            } else if (player.getPosition().equals(Utility.Position.MIDFIELDER)) {
                Utility.midfielders.add(player);
            } else {
                Utility.defenders.add(player);

            }
        }
    }
}
