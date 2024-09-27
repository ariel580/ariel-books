package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class TextToSpeechHelper extends AppCompatActivity {
    private static TextToSpeech textToSpeech;
    public static void initTextToSpeech(Context context){
        if (textToSpeech==null){
            textToSpeech new TextToSpeech(context, new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int status) {
                    if(status==TextToSpeech.SUCCESS){
                        int result = textToSpeech.setLanguage(Locale.US);
                        if (result==TextToSpeech.LANG_MISSING_DATA||result == TextToSpeech.LANG_NOT_SUPPORTED) {
                            Toast.makeText(context, "Text to speech language problem", Toast.LENGTH_LONG);
                        }else{
                            Toast.makeText(context, "Text to speech initialization problem", Toast.LENGTH_SHORT);

                        }
                    }

                }
            });
        }
    }
    public static void speak(String text){
        if (textToSpeech!=null)
            textToSpeech.speak(text,textToSpeech.QUEUE_ADD,null,null);
    }
    public static void close(){
        if (textToSpeech !=null){
            textToSpeech.stop();
            textToSpeech.shutdown();
            textToSpeech=null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_text_to_speech_helper);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}