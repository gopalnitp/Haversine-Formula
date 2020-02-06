package com.example.ibmnlp;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.natural_language_classifier.v1.model.ClassifyOptions;
import com.ibm.watson.natural_language_classifier.v1.model.Classification;

import java.lang.String;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    String name, email;
    EditText nameInput;
    Authenticator authenticator = new IamAuthenticator("0XUwqqeh4_q2uEZvNPYTgLzrv3HhqbfSgBaBkoXKk_Im");
    NaturalLanguageClassifier service = new NaturalLanguageClassifier(authenticator);



    Button submitButton;
    // Context context = getApplicationContext();
    //CharSequence text = "Hello toast!";
    int duration = Toast.LENGTH_SHORT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        nameInput = (EditText) findViewById(R.id.nameInput);
        submitButton = (Button) findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = nameInput.getText().toString();
                //System.out.println(name);
                Toast.makeText(getApplicationContext(),name,Toast.LENGTH_SHORT).show();


            }
        });


        ClassifyOptions classifyOptions = new ClassifyOptions.Builder().classifierId("emotion").text(name).build();
        Classification classification = service.classify(classifyOptions).execute().getResult();
        System.out.println(classification);


    }

//    ClassifyOptions classifyOptions = new ClassifyOptions.Builder()
//            .classifierId("emotion")
//            .text(name)
//            .build();
//    Classification classification = service.classify(classifyOptions).execute().getResult();
//    System.out.println(classification);


}

