public class PrematchStats {
    private String teamFormation;
    private String oppFormation;
    private String weather;

    public PrematchStats(String teamFormation, String oppFormation, String weather) {
        this.teamFormation = teamFormation;
        this.oppFormation = oppFormation;
        this.weather = weather;
    }

    public String getTeamFormation() {
        return teamFormation;
    }

    public String getOppFormation() {
        return oppFormation;
    }

    public String getWeather() {
        return weather;
    }
}


