package cricket.Schedule.IPL2020;

import androidx.annotation.Keep;

import com.google.firebase.firestore.IgnoreExtraProperties;

@IgnoreExtraProperties
@Keep
public class pointsModelClass {

   public String position,name,played,win,lost,nrr,points;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlayed() {
        return played;
    }

    public void setPlayed(String played) {
        this.played = played;
    }

    public String getWin() {
        return win;
    }

    public void setWin(String win) {
        this.win = win;
    }

    public String getLost() {
        return lost;
    }

    public void setLost(String lost) {
        this.lost = lost;
    }

    public String getNrr() {
        return nrr;
    }

    public void setNrr(String nrr) {
        this.nrr = nrr;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public pointsModelClass(String position, String name, String played, String win, String lost, String nrr, String points) {
        this.position = position;
        this.name = name;
        this.played = played;
        this.win = win;
        this.lost = lost;
        this.nrr = nrr;
        this.points = points;
    }
}
