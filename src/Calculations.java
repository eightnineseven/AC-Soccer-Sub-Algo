public class Calculations {
//output sub and new formation
    InMatchStats inMatch;
    PrematchStats preMatch;
    Player players;
    double forwardIn;
    double midfielderIn;
    double defenderIn;
    public Calculations(InMatchStats in, PrematchStats pre, Player players){
        this.inMatch = in;
        this.preMatch = pre;
        this.players = players;
        this.forwardIn = 0;
        this.midfielderIn = 0;
        this.defenderIn=0;
    }
    public String updateFormation(){
        String output = "";
        int[] formation = Utility.formation;
        int defenders = formation[0];
        int midfielders = formation[1];
        int forwards = formation[2];
        output.concat(String.valueOf(defenders));
        output.concat("-");
        output.concat(String.valueOf(midfielders));
        output.concat("-");
        output.concat(String.valueOf(forwards));
        return output;
    }
    public void calculateSub(){
        int[] statsDiff = this.inMatch.statsDiff().clone();
        int[] oppFormation = this.preMatch.getOppFormation().clone();
        String weather = this.preMatch.getWeather();
        int weatherEffect= 0;
        if(weather.equals("rainy")){
            weatherEffect = -1;
        } else{
            weatherEffect = 1;
        }
        int[] formation = new int[3];
        formation = Utility.formation;
        //goals, passes, shots
        this.defenderIn = statsDiff[0]*200 +statsDiff[1]*0.2- statsDiff[2]*5 + weatherEffect*5 -oppFormation[0]*4;
        this.forwardIn = -statsDiff[0]*200 - statsDiff[1]*0.2 + statsDiff[2]*3-weatherEffect*5-oppFormation[2]*12;
        this.midfielderIn = statsDiff[0]*50-statsDiff[1]*0.8 -statsDiff[2]*7-oppFormation[1]*8;
        Player.sortPlayers(Utility.forwards, this.inMatch);
        Player.sortPlayers(Utility.midfielders, this.inMatch);
        Player.sortPlayers(Utility.defenders, this.inMatch);
        double subIN = Math.max(defenderIn, Math.max(forwardIn, midfielderIn));
        if(subIN ==defenderIn){
            formation[0]++;
            System.out.println("Sub in number " + Utility.defenders.get(0).jerseyNumber);
        } else if(subIN == midfielderIn){
            System.out.println("Sub in number " + Utility.midfielders.get(0).jerseyNumber);
            formation[1]++;
        } else{
            System.out.println("Sub in number " + Utility.forwards.get(0).jerseyNumber);
            formation[2]++;
        }


        double subOut = Math.min(defenderIn, Math.min(forwardIn, midfielderIn));
        if(subOut==defenderIn){
            System.out.println("Sub out number " + Utility.defenders.get(Utility.defenders.size()-1).jerseyNumber);
            formation[0]--;
        } else if(subOut ==midfielderIn){
            System.out.println("Sub out number " + Utility.midfielders.get(Utility.midfielders.size()-1).jerseyNumber);

            formation[1]--;
        } else{
            System.out.println("Sub out number " + Utility.forwards.get(Utility.forwards.size()-1).jerseyNumber);

            formation[2]--;
        }
        Utility.formation = formation;

        updateFormation();


    }
}
