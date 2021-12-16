package cricket.Schedule.IPL2020;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;


import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;

import java.util.ArrayList;

public class schedule extends AppCompatActivity {

    RecyclerView scheduleRecycler;
    ArrayList<helperClass> iplList;
    RecyclerView.Adapter adapter;
    Spinner teamNameSpin;
    private AdView adView;
    LinearLayout adContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        adView = new AdView(this, "790720731708984_861401807974209", AdSize.BANNER_HEIGHT_50);

        //790720731708984_861401807974209
        //test- IMG_16_9_APP_INSTALL#YOUR_PLACEMENT_ID
        // Find the Ad Container
        adContainer = findViewById(R.id.schedule_banner_container);

        // Add the ad view to your activity layout
        adContainer.addView(adView);
        // Request an ad
       adView.loadAd();

        scheduleRecycler = findViewById(R.id.scheduleRecycler);

        teamNameSpin = findViewById(R.id.spin);


        teamNameSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {

                    case 0:
                        setSchedule(0);
                        break;
                    case 1:
                        setSchedule(R.drawable.ind);
                        break;
                    case 2:
                        setSchedule(R.drawable.sa);
                        break;
                    case 3:
                        setSchedule(R.drawable.eng);
                        break;
                    case 4:
                        setSchedule(R.drawable.aus);
                        break;
                    case 5:
                        setSchedule(R.drawable.wi);
                        break;
                    case 6:
                        setSchedule(R.drawable.sl);
                        break;
                    case 7:
                        setSchedule(R.drawable.afg);
                        break;

                    case 8:
                        setSchedule(R.drawable.nz);
                        break;


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    private void setSchedule(int filterBy) {


    //    scheduleRecycler.setHasFixedSize(true);

        scheduleRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        iplList = new ArrayList<>();

        iplList.add(new helperClass(R.drawable.aus, R.drawable.eng, "Ashes 1st Test", "8 dec-12 dec", "10 am (local)", "Brisbane"));
        iplList.add(new helperClass(R.drawable.aus, R.drawable.eng, "Ashes 2nd Test", "16 dec-20 dec", "2:30 pm (local)", "Adelaide"));
        iplList.add(new helperClass(R.drawable.aus, R.drawable.eng, "Ashes 3rd Test", "26 dec-30 dec", "10:30 am (local)", "Melbourne"));
        iplList.add(new helperClass(R.drawable.ind, R.drawable.sa, "1st Test", "26 dec-30 dec", "1:30 pm (IST)", "Centurion"));
        iplList.add(new helperClass(R.drawable.ind, R.drawable.sa, "2nd Test", "3 jan-7 jan", "1:30 pm (IST)", "Johannesburg"));
        iplList.add(new helperClass(R.drawable.aus, R.drawable.eng, "Ashes 4th Test", "5 jan-9 jan", "10:30 am (local)", "Sydney"));
        iplList.add(new helperClass(R.drawable.ind, R.drawable.sa, "3rd Test", "11 jan-15 jan", "2 pm (IST)", "Cape Town"));
        iplList.add(new helperClass(R.drawable.aus, R.drawable.eng, "Ashes 5th Test", "14 jan-18 jan", "10 am (local)", "TBD"));

        iplList.add(new helperClass(R.drawable.ind, R.drawable.sa, "1st Odi", "19 january", "2 pm (IST)", "Paari"));
        iplList.add(new helperClass(R.drawable.ind, R.drawable.sa, "2nd Odi", "21 january", "2 pm (IST)", "Paari"));
        iplList.add(new helperClass(R.drawable.ind, R.drawable.sa, "3rd Odi", "23 january", "2 pm (IST)", "Cape Town"));

        iplList.add(new helperClass(R.drawable.ind, R.drawable.wi, "1st Odi", "6 february", "1 pm (IST)", "Ahmedabad"));
        iplList.add(new helperClass(R.drawable.ind, R.drawable.wi, "2nd Odi", "9 february", "1 pm (IST)", "Jaipur"));
        iplList.add(new helperClass(R.drawable.ind, R.drawable.wi, "3rd Odi", "12 february", "1 pm (IST)", "Kolkata"));
        iplList.add(new helperClass(R.drawable.ind, R.drawable.wi, "1st T20", "15 february", "7 pm (IST)", "Cuttack"));
        iplList.add(new helperClass(R.drawable.ind, R.drawable.wi, "2nd T20", "18 february", "7 pm (IST)", "Visakhapatnam"));
        iplList.add(new helperClass(R.drawable.ind, R.drawable.wi, "3rd Odi", "20 february", "7 pm (IST)", "Thiruvananthapuram"));

        iplList.add(new helperClass(R.drawable.ind, R.drawable.sl, "1st Test", "25 feb-1 mar", "9:30 am (IST)", "Bengaluru"));
        iplList.add(new helperClass(R.drawable.ind, R.drawable.sl, "2nd Test", "5 mar-9 mar", "9:30 am (IST)", "Mohali"));
        iplList.add(new helperClass(R.drawable.ind, R.drawable.sl, "1st T20", "13 march", "7 pm (IST)", "Mohali"));
        iplList.add(new helperClass(R.drawable.ind, R.drawable.sl, "2nd T20", "15 march", "7 pm (IST)", "Dharamshala"));
        iplList.add(new helperClass(R.drawable.ind, R.drawable.sl, "3rd Odi", "18 march", "7 pm (IST)", "Lucknow"));


        adapter = new iplAdapter(iplList, filterBy);
        scheduleRecycler.setAdapter(adapter);


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, 0);
    }

    @Override
    protected void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        super.onDestroy();
    }
}