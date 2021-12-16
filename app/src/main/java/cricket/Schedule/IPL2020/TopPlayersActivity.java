package cricket.Schedule.IPL2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class TopPlayersActivity extends AppCompatActivity {

    StatsDataModel totalData;
    FirebaseFirestore firebaseFirestore;
    ProgressBar progressBar;
    private AdView adView;
    LinearLayout adContainer;
    CardView runsCard, wicketsCard;
    private InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_players);

        interstitialAd = new InterstitialAd(this,  "790720731708984_913967079384348");
        InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {

            }

            @Override
            public void onInterstitialDismissed(Ad ad) {

            }

            @Override
            public void onError(Ad ad, AdError adError) {
                Toast.makeText(TopPlayersActivity.this,adError.getErrorMessage(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onAdLoaded(Ad ad) {
                interstitialAd.show();
            }

            @Override
            public void onAdClicked(Ad ad) {

            }

            @Override
            public void onLoggingImpression(Ad ad) {

            }
        };

        interstitialAd.loadAd(
                interstitialAd.buildLoadAdConfig()
                        .withAdListener(interstitialAdListener)
                        .build());



        adView = new AdView(this, "790720731708984_863694387744951", AdSize.BANNER_HEIGHT_50);

        //790720731708984_863694387744951
        // test- IMG_16_9_APP_INSTALL#YOUR_PLACEMENT_ID
        // Find the Ad Container
        adContainer = findViewById(R.id.stats_banner_container);

        // Add the ad view to your activity layout
        adContainer.addView(adView);

        // Request an ad
        adView.loadAd();
        progressBar = findViewById(R.id.statProgress);
        runsCard = findViewById(R.id.runsCard);
        wicketsCard = findViewById(R.id.wicCard);
        runsCard.setVisibility(View.GONE);
        wicketsCard.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);

        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("points table").document("stats data").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    String data = document.get("data").toString();
                    Gson gson = new Gson();
                    Type type = new TypeToken<StatsDataModel>() {
                    }.getType();
                    totalData = gson.fromJson(data, type);
                    setTopRuns();
                }
            }
        });

    }

    private void setTopRuns() {
        RecyclerView runsRecycler = findViewById(R.id.runsRecycler);
        StatsAdapter adapter = new StatsAdapter(totalData.getOrange(), null);
      //  runsRecycler.setHasFixedSize(true);
        runsRecycler.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        runsRecycler.setAdapter(adapter);
        setWickets();
    }

    private void setWickets() {
        RecyclerView wicketsRecycler = findViewById(R.id.wicketsRecycler);
        StatsAdapter adapter = new StatsAdapter(null, totalData.getPurple());
      //  wicketsRecycler.setHasFixedSize(true);
        wicketsRecycler.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        wicketsRecycler.setAdapter(adapter);

        progressBar.setVisibility(View.GONE);
        runsCard.setVisibility(View.VISIBLE);
        wicketsCard.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        if (interstitialAd != null) {
            interstitialAd.destroy();
        }
        super.onDestroy();
    }
}