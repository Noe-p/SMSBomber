package com.example.smsbomber;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.telephony.SmsManager;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String CHANNEL_ID = "2";
    private EditText editTextNumber;
    private EditText editTextMessage;
    private EditText editNbMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(MainActivity.this, new String[] {Manifest.permission.SEND_SMS, Manifest.permission.READ_SMS, Manifest.permission.ACCESS_NOTIFICATION_POLICY}, PackageManager.PERMISSION_GRANTED);

        editTextMessage = findViewById(R.id.editText);
        editTextNumber = findViewById(R.id.editTextNumber);
        editNbMessage = findViewById(R.id.editNbMessage);

    }

    public void sendSMS(View view){

        String message = editTextMessage.getText().toString();
        String number = editTextNumber.getText().toString();
        String nbMessageStr = editNbMessage.getText().toString();
        int nbMessage = Integer.valueOf(nbMessageStr);

        for (int i = 0; i<nbMessage; i++){
            SmsManager mySmsManager = SmsManager.getDefault();
            mySmsManager.sendTextMessage(number, null, message, null, null);
        }

    }
}