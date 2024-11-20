public class PrematchStats {
    private String teamFormation;
    private int[] oppFormation = new int[3];
    private String weather;

    public PrematchStats(String teamFormation, int[] oppFormation, String weather) {
        this.teamFormation = teamFormation;
        this.oppFormation = oppFormation;
        this.weather = weather;

    }

    public String getTeamFormation() {
        return teamFormation;
    }

    public int[] getOppFormation() {
        return oppFormation;
    }

    public String getWeather() {
        return weather;
    }
}


