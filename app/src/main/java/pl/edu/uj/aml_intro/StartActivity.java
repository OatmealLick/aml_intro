package pl.edu.uj.aml_intro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    public void startQuiz(View view){
        Intent intent = new Intent(this, QuestionActivity.class);
        EditText name = (EditText) findViewById(R.id.name_edit_text);
        EditText surname = (EditText) findViewById(R.id.surname_edit_text);
        String username = String.format("%s %s", name, surname);
        intent.putExtra(Constants.USER_NAME, username);
        startActivity(intent);
    }
}