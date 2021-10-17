package pl.edu.uj.aml_intro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EndActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
    }

    public void onEndQuizClicked(View view) {
        Intent intentOfPreviousActivity = getIntent();
        Intent intent = new Intent(this, ResultsActivity.class);
        intent.putExtras(intentOfPreviousActivity);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}