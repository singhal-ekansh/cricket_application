package cricket.Schedule.IPL2020;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class result extends Fragment {

    Button quitBtn, playAgainBtn;
    TextView scoreText, highScoreText;
    int lastScore, ownHigh;
    FirebaseFirestore firebaseFirestore;
    NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_result, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        quitBtn = view.findViewById(R.id.quit);
        playAgainBtn = view.findViewById(R.id.again);
        scoreText = view.findViewById(R.id.scoreView);
        highScoreText = view.findViewById(R.id.highScoreView);
        firebaseFirestore = FirebaseFirestore.getInstance();
        navController = Navigation.findNavController(view);

       /* firebaseFirestore.collection("users").document(FirebaseAuth.getInstance().getCurrentUser().getUid()).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot documentSnapshot = task.getResult();
                    lastScore = (int) (long) documentSnapshot.get("last score");
                    ownHigh = (int) (long) documentSnapshot.get("high score");
                    if (ownHigh < lastScore) {
                        ownHigh = lastScore;
                        firebaseFirestore.collection("users").document(FirebaseAuth.getInstance().getCurrentUser().getUid()).update("high score", ownHigh);
                    }

                }
            }
        });

        */
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("scores", Context.MODE_PRIVATE);
        lastScore=sharedPreferences.getInt("last_score",0);
        ownHigh = sharedPreferences.getInt("high_score",0);
        scoreText.setText("" + lastScore);
        highScoreText.setText("" + ownHigh);
        playAgainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_result_to_playQuiz);
            }
        });
        quitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
    }
}