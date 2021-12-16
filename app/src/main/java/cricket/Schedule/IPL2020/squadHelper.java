package cricket.Schedule.IPL2020;

public class squadHelper {
    int imgId;
    String squadName,teamSquad;

    public squadHelper(int imgId, String squadName, String teamSquad) {
        this.imgId = imgId;
        this.squadName = squadName;
        this.teamSquad = teamSquad;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getSquadName() {
        return squadName;
    }

    public void setSquadName(String squadName) {
        this.squadName = squadName;
    }

    public String getTeamSquad() {
        return teamSquad;
    }

    public void setTeamSquad(String teamSquad) {
        this.teamSquad = teamSquad;
    }
}
