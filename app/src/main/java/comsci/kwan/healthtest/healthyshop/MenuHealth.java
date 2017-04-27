package comsci.kwan.healthtest.healthyshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import comsci.kwan.healthtest.R;

public class MenuHealth extends AppCompatActivity {
    //Exlicit
    private ListView listView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_health);



} // main method onCreate
    public void onClickBackMenu (View view){
        finish();
    }

    public void onClickTotalorder (View view){
        Intent intent = new Intent(MenuHealth.this,ShowOrder.class);
        startActivity(intent);
    }

}
