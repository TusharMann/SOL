package com.example.tushar.sol;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.api.translate.Language;
import com.google.api.translate.Translate;



public class Translator extends AppCompatActivity {

    EditText MyInputText;
    Button MyTranslateButton;
    TextView MyOutputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        MyInputText = (EditText)findViewById(R.id.InputText);
        MyTranslateButton = (Button)findViewById(R.id.TranslateButton);
        MyOutputText = (TextView)findViewById(R.id.OutputText);

        MyTranslateButton.setOnClickListener(MyTranslateButtonOnClickListener);
    }

    private Button.OnClickListener MyTranslateButtonOnClickListener
            = new Button.OnClickListener(){

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            String InputString;
            String OutputString = null;
            InputString = MyInputText.getText().toString();

            try {
                Translate.setHttpReferrer("http://android-er.blogspot.com/");
                OutputString = Translate.execute(InputString,
                        Language.ENGLISH, Language.FRENCH);
            } catch (Exception ex) {
                ex.printStackTrace();
                OutputString = "Error";
            }

            MyOutputText.setText(OutputString);

        }

    };


    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
