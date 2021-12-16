package cricket.Schedule.IPL2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;

public class QuizActivity extends AppCompatActivity {
    private AdView adView;
    LinearLayout adContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        adView = new AdView(this, "790720731708984_861401807974209", AdSize.BANNER_HEIGHT_50);

        //790720731708984_861401807974209
        // test- IMG_16_9_APP_INSTALL#YOUR_PLACEMENT_ID
        // Find the Ad Container
        adContainer = findViewById(R.id.quiz_banner_container);

        // Add the ad view to your activity layout
        adContainer.addView(adView);

        // Request an ad
        adView.loadAd();
    }

    @Override
    protected void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        super.onDestroy();
    }
}