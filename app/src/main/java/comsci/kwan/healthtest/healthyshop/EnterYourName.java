package comsci.kwan.healthtest.healthyshop;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import comsci.kwan.healthtest.R;
import comsci.kwan.healthtest.Starts;

public class EnterYourName extends AppCompatActivity {

    String nameString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_your_name);
        Button button = (Button) findViewById(R.id.button2);
        final EditText editText = (EditText) findViewById(R.id.editText);
        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                if (editText.length() == 0) { //ถ้า edittext ว่าง คือยังไม่กรอกชื่อ
                    Toast.makeText(getApplicationContext(), "Please Enter Your Desk !", Toast.LENGTH_LONG).show();

                } else {

                    nameString = editText.getText().toString().trim();

                    Toast.makeText(getApplicationContext(), "Welcome Your Desk " + nameString, Toast.LENGTH_LONG).show();

                    Intent startIntent = new Intent(EnterYourName.this, MainActivity.class);

                    startActivity(startIntent);
                }
            }
        });
    }



}
