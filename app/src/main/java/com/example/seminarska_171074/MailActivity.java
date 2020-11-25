package com.example.seminarska_171074;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MailActivity extends AppCompatActivity {
    String message;

    EditText etTo,etSubject,etMessage;
    Button btSend;
    Button btHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail);
        message=getIntent().getStringExtra("data2");
        etMessage=findViewById(R.id.poraka);
        etMessage.setText(message);

        etTo=findViewById(R.id.emailporaka);
        etSubject=findViewById(R.id.titleporaka);
        btSend=findViewById(R.id.buttonporaka);
        btHome=findViewById(R.id.buttonhome);



        btSend.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {
//                Intent intent=new Intent(MailActivity.this,CategoryActivity.class);
//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:"+etTo.getText().toString()));
//                intent.putExtra(Intent.EXTRA_SUBJECT,etSubject.getText().toString());
//                intent.putExtra(Intent.EXTRA_TEXT,etMessage.getText().toString());
//                startActivity(intent);

                String[] recepients;
                recepients=etTo.getText().toString().split(",");
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, recepients);
                email.putExtra(Intent.EXTRA_SUBJECT, etSubject.getText().toString());
                email.putExtra(Intent.EXTRA_TEXT, etMessage.getText().toString());

                //need this to prompts email client only
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client :"));
            }

        });

        btHome.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MailActivity.this,NewCardActivity.class);
                startActivity(intent);
            }
        });

    }

}