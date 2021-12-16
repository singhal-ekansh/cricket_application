package cricket.Schedule.IPL2020;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


public class PlayQuiz extends Fragment {

    FirebaseFirestore firebaseFirestore;
    List<QuestionModel> allQuestionsList = new ArrayList<>();
    TextView lifeLeft, timeLeftText, ques, msg;
    Button optThree, optOne, optTwo, nextQ;
    ProgressBar timeView;
    CountDownTimer countDownTimer;
    int chanceRemaining, score = 0,highScore;
    String answer, one, two, three;
    NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_play_quiz, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        firebaseFirestore = FirebaseFirestore.getInstance();
        chanceRemaining = 3;
        lifeLeft = view.findViewById(R.id.life);
        timeLeftText = view.findViewById(R.id.timeCount);
        ques = view.findViewById(R.id.questionText);
        optOne = view.findViewById(R.id.option1);
        optTwo = view.findViewById(R.id.option2);
        optThree = view.findViewById(R.id.option3);
        nextQ = view.findViewById(R.id.nextQues);
        timeView = view.findViewById(R.id.timerBar);
        msg = view.findViewById(R.id.msgView);
        navController = Navigation.findNavController(view);

        firebaseFirestore.collection("Questions").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    allQuestionsList = task.getResult().toObjects(QuestionModel.class);
                    LoadUi();
                }else
                    navController.navigate(R.id.action_playQuiz_to_result);

            }
        });

        nextQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (allQuestionsList.size() > 0)
                    LoadUi();
                else
                    showResults();
            }
        });
        optOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                disableUi();
                if (one.equals(answer)) {
                    score++;
                    optOne.setBackgroundColor(Color.parseColor("#008000"));
                    nextQ.setVisibility(View.VISIBLE);

                } else {
                    optOne.setBackgroundColor(Color.parseColor("#FF0000"));
                    chanceRemaining--;
                    lifeLeft.setText(chanceRemaining + "");
                    msg.setText("Answer: "+answer);
                    if (chanceRemaining == 0) {
                        msg.setText("Game Over");
                        showResults();
                    }else
                        nextQ.setVisibility(View.VISIBLE);
                }

            }
        });
        optTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                disableUi();
                if (two.equals(answer)) {
                    score++;
                    optTwo.setBackgroundColor(Color.parseColor("#008000"));
                    nextQ.setVisibility(View.VISIBLE);

                } else {
                    optTwo.setBackgroundColor(Color.parseColor("#FF0000"));
                    chanceRemaining--;
                    lifeLeft.setText(chanceRemaining + "");
                    msg.setText("Answer: "+answer);
                    if (chanceRemaining == 0) {
                        msg.setText("Game Over");
                        showResults();
                    }else
                        nextQ.setVisibility(View.VISIBLE);
                }

            }
        });
        optThree.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                disableUi();
                if (three.equals(answer)) {
                    score++;
                    optThree.setBackgroundColor(Color.parseColor("#008000"));
                    nextQ.setVisibility(View.VISIBLE);
                } else {
                    optThree.setBackgroundColor(Color.parseColor("#FF0000"));
                    chanceRemaining--;
                    lifeLeft.setText(chanceRemaining + "");
                    msg.setText("Answer: "+answer);
                    if (chanceRemaining == 0) {
                        msg.setText("Game Over");
                        showResults();
                    }else
                        nextQ.setVisibility(View.VISIBLE);
                }

            }
        });
    }

    private void LoadUi() {
        lifeLeft.setText(chanceRemaining + "");
        if (chanceRemaining > 0 && allQuestionsList.size() > 0) {
            enableUi();
            loadQues(getRandomInt(0, allQuestionsList.size()));
        } else {
            msg.setText("Game Over");
            showResults();
        }
    }

    private int getRandomInt(int min, int max) {
        return ((int) (Math.random() * (max - min))) + min;
    }

    private void loadQues(int quesNo) {
        ques.setText(allQuestionsList.get(quesNo).getQuestion());

        one = allQuestionsList.get(quesNo).getOption_one();
        optOne.setText(one);
        two = allQuestionsList.get(quesNo).getOption_two();
        optTwo.setText(two);
        three = allQuestionsList.get(quesNo).getOption_three();
        optThree.setText(three);

        answer = allQuestionsList.get(quesNo).getAnswer();

        allQuestionsList.remove(quesNo);

        startTimer();
    }

    private void startTimer() {

        timeLeftText.setText("30");

        timeView.setVisibility(View.VISIBLE);

        countDownTimer = new CountDownTimer(30 * 1000, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftText.setText(millisUntilFinished / 1000 + "");
                long percent = millisUntilFinished / 300;

                timeView.setProgress((int) percent);
            }

            @Override
            public void onFinish() {
                disableUi();
                msg.setText("TIME OVER");
                chanceRemaining--;
                lifeLeft.setText(chanceRemaining + "");
                nextQ.setVisibility(View.VISIBLE);
            }
        };
        countDownTimer.start();
    }

    private void disableUi() {
        optOne.setEnabled(false);
        optTwo.setEnabled(false);
        optThree.setEnabled(false);
    }

    private void enableUi() {
        ques.setVisibility(View.VISIBLE);
        optOne.setVisibility(View.VISIBLE);
        optTwo.setVisibility(View.VISIBLE);
        optThree.setVisibility(View.VISIBLE);
        nextQ.setVisibility(View.GONE);
        optOne.setBackgroundResource(R.drawable.option_bg);
        optTwo.setBackgroundResource(R.drawable.option_bg);
        optThree.setBackgroundResource(R.drawable.option_bg);

        optOne.setEnabled(true);
        optTwo.setEnabled(true);
        optThree.setEnabled(true);

        msg.setText("");

    }

    private void showResults() {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("scores", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("last_score",score);
        highScore = sharedPreferences.getInt("high_score",0);
        if(highScore<score)
            editor.putInt("high_score",score);
        editor.commit();
        score = 0;
        navController.navigate(R.id.action_playQuiz_to_result);
       /* firebaseFirestore.collection("users").document(FirebaseAuth.getInstance().getCurrentUser().getUid()).update("last score", score).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {


            }
        });

        */
    }

}