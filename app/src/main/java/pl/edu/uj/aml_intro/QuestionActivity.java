package pl.edu.uj.aml_intro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class QuestionActivity extends AppCompatActivity {

    private static final String TAG = "QuestionActivity";
    private static final int QUESTIONS_COUNT = 2;

    private int[] answers = new int[]{-1, -1};
    private List<Question> questions = new ArrayList<>();
    private int currentQuestionIndex = 0; // todo should be persistd and views setup based upon this

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        Question question1 = new Question(
                "Czy podoba Ci się broda prowadzącego?",
                new String[]{"Tak.", "Zdecydowanie tak.", "Sam(a) chciał(a)bym taką mieć."},
                new int[]{0, 1, 2});
        Question question2 = new Question(
                "Czy podoba Ci się nos prowadzącego?",
                new String[]{"Tak.", "Zdecydowanie tak.", "Sam(a) chciał(a)bym taką mieć."},
                new int[]{0});
        questions.add(question1);
        questions.add(question2);

        updateViews();
    }

    public void onNextClicked(View view) {
        if (currentQuestionIndex == QUESTIONS_COUNT - 1) {
            Intent intent = new Intent(this, EndActivity.class);
            intent.putExtra(Constants.USER_ANSWER, answers);
            intent.putExtras(getIntent());
            startActivity(intent);
        } else {
            ++currentQuestionIndex;
            updateViews();
        }
    }

    public void onPrevClicked(View view) {
        if (currentQuestionIndex == 0) {
            finish();
        } else {
            --currentQuestionIndex;
            updateViews();
        }
    }

    private void updateViews() {
        Question current = questions.get(currentQuestionIndex);

        TextView questionText = (TextView) findViewById(R.id.question_text);
        RadioButton rb1 = (RadioButton) findViewById(R.id.answer1);
        RadioButton rb2 = (RadioButton) findViewById(R.id.answer2);
        RadioButton rb3 = (RadioButton) findViewById(R.id.answer3);

        questionText.setText(current.getUltimateQuestion());
        rb1.setText(current.getAnswers()[0]);
        rb2.setText(current.getAnswers()[1]);
        rb3.setText(current.getAnswers()[2]);

        RadioButton[] buttons = new RadioButton[]{rb1, rb2, rb3};
        for (RadioButton b : buttons) {
            b.setChecked(false);
        }
        int answer = answers[currentQuestionIndex];
        if (answer != -1) {
            buttons[answer].setChecked(true);
        }
    }


    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();

        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();

        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();

        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onRestart() {
        // TODO Auto-generated method stub
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    /**
     * UNCOMENT FOR SAVING/RESTORING STATE
     *
     * @Override protected void onSaveInstanceState(Bundle outState) {
     * // Save the answer
     * outState.putInt(USER_ANSWER, q.answer);
     * <p>
     * // Always call the superclass so it can save the view hierarchy state
     * super.onSaveInstanceState(outState);
     * }
     * @Override protected void onRestoreInstanceState(Bundle savedInstanceState) {
     * // Always call the superclass so it can restore the view hierarchy
     * super.onRestoreInstanceState(savedInstanceState);
     * <p>
     * // Restore the answer
     * q.answer = savedInstanceState.getInt(USER_ANSWER);
     * }
     * <p>
     * UNCOMENT FOR SAVING/RESTORING STATE
     **/


    public void recordAnswer(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.answer1:
                if (checked) answers[currentQuestionIndex] = 0;
                break;
            case R.id.answer2:
                if (checked) answers[currentQuestionIndex] = 1;
                break;
            case R.id.answer3:
                if (checked) answers[currentQuestionIndex] = 2;
                break;
        }
    }
}