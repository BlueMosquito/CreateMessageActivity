package com.hfad.mymessenger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);
    }

    public void onSendMessage(View view){
        EditText messageView = (EditText) findViewById(R.id.message);
        String messageText = messageView.getText().toString();

        /*
        Ett Intent med action.
        Specifierar vilket sort av action dettga är.
        */
        Intent intent = new Intent(Intent.ACTION_SEND);

        //Typ av intent är text(String).
        intent.setType("text/plain");

        /*
        messageText typ måste vara String i detta fall.
        Android kollar och tar fram alla aktiviteter som kan skicka ett medelande.
         */
        intent.putExtra(Intent.EXTRA_TEXT, messageText);

        /*
        Här skapas chooser som gör att om det finns många aktiviteter som kan skicka ett medelande
        så ska alla visas varje gång man vill skicka meddelande.
         */
        String chooserTitle = (String) getText(R.string.chooser);
        Intent chosenIntent = Intent.createChooser(intent, chooserTitle);
        startActivity(chosenIntent);
    }
}