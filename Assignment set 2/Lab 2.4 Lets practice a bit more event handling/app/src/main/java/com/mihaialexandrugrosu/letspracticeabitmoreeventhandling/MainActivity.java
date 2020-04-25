package com.mihaialexandrugrosu.letspracticeabitmoreeventhandling;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;

    enum Language { ENGLISH, SVERIGE, SUOMEKSI, SURPRISE}

    Language language = Language.ENGLISH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                textView.setText(getLanguage() + editText.getText().toString());
            }

        });

    }

    public void english(View view)
    {
        language = Language.ENGLISH;
        textView.setText(getLanguage() + editText.getText().toString());
    }

    public void sverige(View view)
    {
        language = Language.SVERIGE;
        textView.setText(getLanguage() + editText.getText().toString());
    }

    public void suomeksi(View view)
    {
        language = Language.SUOMEKSI;
        textView.setText(getLanguage() + editText.getText().toString());
    }

    public void surprise(View view)
    {
        language = Language.SURPRISE;
        textView.setText(getLanguage() + editText.getText().toString());
    }

    public String getLanguage()
    {
        switch (language)
        {
            case ENGLISH:
                return "Hi ";
            case SVERIGE:
                return "Hejjsan ";
            case SUOMEKSI:
                return "Terve ";
            case SURPRISE:
                return "Hola ";
            default:
                return "Hi";
        }
    }
}
