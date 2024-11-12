public class InMatchStats{
        int homeGoals=0;
        int awayGoals=0;
        int minsPlayed=0;
        int homePasses=0;
        int awayPasses=0;
        int homeShots=0;
        int awayShots = 0;
        int subsRemaining = 4;

        public InMatchStats(int homeGoals, int awayGoals, int minsPlayed, int homePasses, int awayPasses, int homeShots, int awayShots, int subsRemaining) {
                this.homeGoals = homeGoals;
                this.awayGoals = awayGoals;
                this.minsPlayed = minsPlayed;
                this.homePasses = homePasses;
                this.awayPasses = awayPasses;
                this.homeShots = homeShots;
                this.awayShots = awayShots;
                this.subsRemaining = subsRemaining;
    }
        public int[] statsDiff() {
                int[] statsDiff = {this.homeGoals-this.awayGoals, this.homePasses-this.awayPasses,this.homeShots-this.awayShots};
                return statsDiff;
        }
        public int getMinsPlayed(){return this.minsPlayed;}
        public int getSubsRemaining(){return this.subsRemaining;}




}
