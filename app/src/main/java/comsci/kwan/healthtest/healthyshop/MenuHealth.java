package comsci.kwan.healthtest.healthyshop;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import comsci.kwan.healthtest.R;
import comsci.kwan.healthtest.menu.DrinkTable;

public class MenuHealth extends AppCompatActivity{
    //Exlicit

    private Spinner deskSpinner;
    private ListView foodListView;
    private String strDrink,strSource,strPrice,deskString;
    private TextView txtofficer;
    private ListView DrinkListView;
    private int[] ints = new int[]{R.drawable.fruit1, R.drawable.fruit2, R.drawable.fruit3,
            R.drawable.fruit4, R.drawable.fruit5, R.drawable.fruit6, R.drawable.fruit7,
            R.drawable.fruit8, R.drawable.fruit9, R.drawable.fruit91};
    private String[] drinkString, sourceString, priceString;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_health);

        DrinkListView = (ListView) findViewById(R.id.livmenu);

        drinkString = getResources().getStringArray(R.array.title);
        sourceString = getResources().getStringArray(R.array.detail);
        priceString = getResources().getStringArray(R.array.price);

        MyAdapterHealth health = new MyAdapterHealth(MenuHealth.this,ints,drinkString,sourceString,priceString );
        DrinkListView.setAdapter(health);


        // bindwidget
       // bindWidget();

        //show spinner
       // showSpinner();

        //create listview
       // createListView();
    } // main method onCreate

  //  private  void bindWidget(){
       // txtofficer = (TextView) findViewById(R.id.txtofficer);
       // deskSpinner = (Spinner) findViewById(R.id.spinner2);



    /*private void createListView(){
        DrinkTable drinkTable = new DrinkTable(this);
        final String[] strDrink = drinkTable.readAllFood(1);
        String[] strSource = drinkTable.readAllFood(2);
        String[] strPrice = drinkTable.readAllFood(3);*/




   /* private void showSpinner(){
        final  String[] strDeskSpinner = {"one","Two","Three","Four","five"};
        ArrayAdapter<String> deskAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,
                strDeskSpinner);
        deskSpinner.setAdapter(deskAdapter);

        deskSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                deskString = strDeskSpinner[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
               deskString = strDeskSpinner[0];

            }
        });
    } */




    public void onClickBackMenu (View view){
        finish();
    }

    public void onClickTotalorder (View view){
        Intent intent = new Intent(MenuHealth.this,ShowOrder.class);
        startActivity(intent);
    }

}
