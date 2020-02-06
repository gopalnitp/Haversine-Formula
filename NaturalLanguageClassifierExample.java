package com.example.ibmnlp;

import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.natural_language_classifier.v1.model.ClassifyOptions;
import com.ibm.watson.natural_language_classifier.v1.model.Classification;

public class NaturalLanguageClassifierExample {

    public static void main(String[] args) {
        Authenticator authenticator = new IamAuthenticator("0XUwqqeh4_q2uEZvNPYTgLzrv3HhqbfSgBaBkoXKk_Im");
        NaturalLanguageClassifier service = new NaturalLanguageClassifier(authenticator);

       ClassifyOptions classifyOptions = new ClassifyOptions.Builder()
                .classifierId("emotion")
                .text("Is it sunny?")
                .build();
        Classification classification = service.classify(classifyOptions).execute().getResult();

        System.out.println(classification);
    }

}
