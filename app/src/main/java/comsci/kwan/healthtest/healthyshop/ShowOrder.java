package comsci.kwan.healthtest.healthyshop;

import android.content.DialogInterface;
import android.content.Intent;
import android.preference.DialogPreference;
import android.support.annotation.IdRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import comsci.kwan.healthtest.R;

public class ShowOrder extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_order);

    }




    public void onClickOK (View view) {


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("HealthyShop");
        builder.setMessage("ขอบคุณที่มาใช้บริการ");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(ShowOrder.this, EnterYourName.class);
                startActivity(intent);

            }
        });

        builder.show();

    }

}
