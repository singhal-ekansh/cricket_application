package cricket.Schedule.IPL2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class pointsTable extends AppCompatActivity {

    RecyclerView ptsRecycler;
    ArrayList<pointsModelClass> pointsList;
    RecyclerView.Adapter adapter;
    FirebaseFirestore firebaseFirestore;
    ProgressBar progressBar;
    private AdView adView;
    LinearLayout adContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_points_table);

        adView = new AdView(this, "790720731708984_790726681708389", AdSize.BANNER_HEIGHT_50);

        //790720731708984_790726681708389
        //test- IMG_16_9_APP_INSTALL#YOUR_PLACEMENT_ID
        // Find the Ad Container
        adContainer = findViewById(R.id.points_banner_container);

        // Add the ad view to your activity layout
        adContainer.addView(adView);

        // Request an ad
        adView.loadAd();

        progressBar = findViewById(R.id.pTableProgress);
        progressBar.setVisibility(View.VISIBLE);
        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("points table").document("table data").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();

                    String data = document.get("data").toString();
                    Gson gson = new Gson();
                    Type type = new TypeToken<ArrayList<pointsModelClass>>() {
                    }.getType();
                    pointsList = gson.fromJson(data, type);
                    setPointsTable();
                }
            }
        });


    }

    void setPointsTable() {
        ptsRecycler = findViewById(R.id.pTableRecycler);
      //  ptsRecycler.setHasFixedSize(true);
        ptsRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

        adapter = new pointsTableAdapter(pointsList);
        ptsRecycler.setAdapter(adapter);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0,0);
    }

    @Override
    protected void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        super.onDestroy();
    }
}