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
                        setSchedule(R.drawable.csk);
                        break;
                    case 2:
                        setSchedule(R.drawable.mi);
                        break;
                    case 3:
                        setSchedule(R.drawable.rcb);
                        break;
                    case 4:
                        setSchedule(R.drawable.kxip);
                        break;
                    case 5:
                        setSchedule(R.drawable.rr);
                        break;
                    case 6:
                        setSchedule(R.drawable.srh);
                        break;
                    case 7:
                        setSchedule(R.drawable.kkr);
                        break;

                    case 8:
                        setSchedule(R.drawable.dc);
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

        iplList.add(new helperClass(R.drawable.mi, R.drawable.csk, "Group Stage", "27 March", "8 pm IST", "Chepauk"));
        iplList.add(new helperClass(R.drawable.rcb, R.drawable.kkr, "Group Stage", "28 March", "8 pm IST", "Chinnaswami"));
        iplList.add(new helperClass(R.drawable.kxip, R.drawable.dc, "Group Stage", "29 March", "8 pm IST", "Mohali"));
        iplList.add(new helperClass(R.drawable.rr, R.drawable.srh, "Group Stage", "30 March", "8 pm IST", "Jaipur"));


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