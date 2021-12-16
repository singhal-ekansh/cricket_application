package cricket.Schedule.IPL2020;

import androidx.annotation.Keep;

import com.google.firebase.firestore.IgnoreExtraProperties;

@IgnoreExtraProperties
@Keep

public class helperClass {

   public int logo1, logo2;
   public String type, date, time, venue;


    public helperClass(int logo1, int logo2, String type, String date, String time, String venue) {
        this.logo1 = logo1;
        this.logo2 = logo2;
        this.type = type;
        this.date = date;
        this.time = time;
        this.venue = venue;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getType() {
        return type;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setLogo1(int logo1) {
        this.logo1 = logo1;
    }

    public void setLogo2(int logo2) {
        this.logo2 = logo2;
    }

    public int getLogo1() {
        return logo1;
    }

    public int getLogo2() {
        return logo2;
    }


}
