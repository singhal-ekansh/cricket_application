package cricket.Schedule.IPL2020;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.cardview.widget.CardView;

import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.AudienceNetworkAds;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textview.MaterialTextView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

    MaterialTextView scheduleButton, pointsBtn, squadsButton, updateBtn, quizzerBtn, predictionBtn, statsBtn;
    private AdView adView;
    LinearLayout adContainer;
    CardView showHideQuiz;
    FirebaseAuth auth;
    FirebaseFirestore firebaseFirestore;
    // FirebaseRemoteConfig firebaseRemoteConfig;
    final String urlQuiz = "https://818.win.qureka.com";
    final String urlPrediction = "https://630.live.predchamp.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AudienceNetworkAds.initialize(this);

        adView = new AdView(this, "790720731708984_861391827975207", AdSize.BANNER_HEIGHT_50);

        //790720731708984_861391827975207
        // test- IMG_16_9_APP_INSTALL#YOUR_PLACEMENT_ID
        // Find the Ad Container
        adContainer = findViewById(R.id.home_banner_container);

        // Add the ad view to your activity layout
        adContainer.addView(adView);

        // Request an ad
        adView.loadAd();


        auth = FirebaseAuth.getInstance();
        scheduleButton = findViewById(R.id.scheduleBtn);
        pointsBtn = findViewById(R.id.toPointsBtn);
        squadsButton = findViewById(R.id.squadsBtn);
        updateBtn = findViewById(R.id.checkUpdate);
        quizzerBtn = findViewById(R.id.quizBtn);
        predictionBtn = findViewById(R.id.querkaBtn);
        statsBtn = findViewById(R.id.statsBtn);
        showHideQuiz = findViewById(R.id.quizShowHide);
        firebaseFirestore = FirebaseFirestore.getInstance();

        /*
        // config code
        firebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        FirebaseRemoteConfigSettings.Builder configBuilder = new FirebaseRemoteConfigSettings.Builder();
        if (BuildConfig.DEBUG) {
            long cacheInterval = 0;
            configBuilder.setMinimumFetchIntervalInSeconds(cacheInterval);
        }
        firebaseRemoteConfig.setConfigSettingsAsync(configBuilder.build());
        firebaseRemoteConfig.setDefaultsAsync(R.xml.remote_config_defaults);
        firebaseRemoteConfig.fetchAndActivate()
                .addOnCompleteListener(this, new OnCompleteListener<Boolean>() {
                    @Override
                    public void onComplete(@NonNull @NotNull Task<Boolean> task) {
                        if (task.isSuccessful()) {
                            if (task.getResult()) {
                                SharedPreferences sharedPreferences = getSharedPreferences("scores", MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                if (firebaseRemoteConfig.getString("show_hide_quiz").equals("yes")) {
                                    editor.putString("show_hide_quiz", "yes");
                                    // quizzerBtn.setVisibility(View.VISIBLE);
                                } else {
                                    editor.putString("show_hide_quiz", "no");
                                    //quizzerBtn.setVisibility(View.GONE);
                                }
                                editor.commit();
                            }

                        }
                    }
                });
//
        SharedPreferences sharedPreferences = getSharedPreferences("scores", MODE_PRIVATE);
        if (sharedPreferences.getString("show_hide_quiz", "yes").equals("yes"))
            showHideQuiz.setVisibility(View.VISIBLE);
        else
            showHideQuiz.setVisibility(View.GONE);


         */

        scheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, schedule.class));
            }
        });
        pointsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, pointsTable.class));
            }
        });

        squadsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Squads.class));
            }
        });
        quizzerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                CustomTabsIntent customTabsIntent = builder.build();
                customTabsIntent.launchUrl(MainActivity.this, Uri.parse(urlQuiz));
            }
        });
        predictionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                CustomTabsIntent customTabsIntent = builder.build();
                customTabsIntent.launchUrl(MainActivity.this, Uri.parse(urlPrediction));
            }
        });

        statsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TopPlayersActivity.class));
            }
        });

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent rateIntent = rateIntentForUrl("market://details");
                    startActivity(rateIntent);
                } catch (ActivityNotFoundException e) {
                    Intent rateIntent = rateIntentForUrl("https://play.google.com/store/apps/details");
                    startActivity(rateIntent);
                }
            }
        });
    }

    private Intent rateIntentForUrl(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(String.format("%s?id=%s", url, getPackageName())));
        int flags = Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_MULTIPLE_TASK;
        flags |= Intent.FLAG_ACTIVITY_NEW_DOCUMENT;
        intent.addFlags(flags);
        return intent;
    }

    @Override
    protected void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        super.onDestroy();
    }

    @Override
    protected void onStart() {
        super.onStart();
/*
        if (auth.getCurrentUser() == null) {
            auth.signInAnonymously()
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            Map<String, Object> map = new HashMap<>();
                            map.put("last score", 0);
                            map.put("high score", 0);
                            firebaseFirestore.collection("users").document(auth.getCurrentUser().getUid()).set(map);
                        }
                    });

        }

 */
    }
}