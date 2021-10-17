package pl.edu.uj.aml_intro;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultsActivity extends AppCompatActivity {

    private final Map<Integer, List<Integer>> correctAnswers = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        ArrayList<Integer> answersFor0 = new ArrayList<>();
        answersFor0.add(0);
        answersFor0.add(1);
        answersFor0.add(2);
        ArrayList<Integer> answersFor1 = new ArrayList<>();
        answersFor1.add(0);
        answersFor1.add(1);
        answersFor1.add(2);
        correctAnswers.put(0, answersFor0);
        correctAnswers.put(1, answersFor1);
    }

    @Override
    protected void onResume() {
        super.onResume();

        TextView correctAnswersTextView = (TextView) findViewById(R.id.resultsCorrectAnswers);
        TextView timeTextView = (TextView) findViewById(R.id.resultsTime);

        // todo change when having multiple questions
        int[] userAnswers = getIntent().getIntArrayExtra(Constants.USER_ANSWER);
        int correctAnswersCount = 0;
        for (int i = 0; i < userAnswers.length; i++) {
            int userAnswer = userAnswers[i];
            if (correctAnswers.get(i).contains(userAnswer)) {
                correctAnswersCount++;
            }
        }
        correctAnswersTextView.setText("" + correctAnswersCount);
    }
}