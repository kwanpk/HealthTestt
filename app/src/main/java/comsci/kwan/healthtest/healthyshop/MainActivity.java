package comsci.kwan.healthtest.healthyshop;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import comsci.kwan.healthtest.R;
import comsci.kwan.healthtest.menu.DrinkTable;
import comsci.kwan.healthtest.menu.OrderTable;
import comsci.kwan.healthtest.menu.UserTable;

public class MainActivity extends AppCompatActivity {
    private UserTable objUserTABLE;
    private DrinkTable objDrinkTABLE;
    private OrderTable objOrderTABLE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connectedSQLite();//เชื่อมต่อกับ SQLite

        testAddValue();//ทดสอบ เพิ่มข้อมูลลง SQLite

        synJSONtoSQLite();

    }
    public void testAddValue(){
        objUserTABLE.addNewUser("testUser");
        objDrinkTABLE.addNewDrink("testDrink","testPicture","testPrice");
        objOrderTABLE.addNewOrder("testOfficer","testDrink","testDesk","testTotal","testItem");

    }

    private void connectedSQLite(){
        objUserTABLE = new UserTable(this);
        objDrinkTABLE = new DrinkTable(this);
        objOrderTABLE = new OrderTable(this);
    }
    private void synJSONtoSQLite() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        // loop2time
        int intTimes = 0;
        while (intTimes <=1) {
            //variable
            InputStream objInputStream = null;
            String strJSON = null;
            String strUserURL = "http://57110206600.sci.dusit.ac.th/user.php";
            String strDrinkURL = "http://57110206600.sci.dusit.ac.th/drink.php";
            String strOrderURL = "http://57110206600.sci.dusit.ac.th/order.php";
            HttpPost objHttpPost;

            // create inputstream
            try {
                HttpClient objHttpClient = new DefaultHttpClient();
                switch (intTimes) {
                    case 0:
                        objHttpPost = new HttpPost(strUserURL);
                        break;
                    case 1:
                        objHttpPost = new HttpPost(strDrinkURL);
                        break;
                    default:
                        objHttpPost = new HttpPost(strOrderURL);
                        break;
                }
                HttpResponse objHttpResponse = objHttpClient.execute(objHttpPost);
                HttpEntity objHttpEntity = objHttpResponse.getEntity();
                objInputStream = objHttpEntity.getContent();
            }catch (Exception e){
                Log.d("HealthyShop","InputStream ==>"+e.toString());
            }

               //create strJSON
            try{
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(objInputStream,"UTF-8"));
                StringBuilder stringBuilder = new StringBuilder();
                String strLine = null;
                while ((strLine = bufferedReader.readLine()) !=null){
                    stringBuilder.append(strLine);
                }
                objInputStream.close();
                strJSON = stringBuilder.toString();
            }catch (Exception e){
                Log.d("HealthyShop","strJSON ==>"+e.toString());
            }

              //update SQLite
            try{
                JSONArray jsonArray = new JSONArray(strJSON);
                for (int i = 0; i<jsonArray.length(); i++){
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    switch (intTimes){
                        case 0:
                            String struser = jsonObject.getString("User");
                           long addValue = objUserTABLE.addNewUser(struser);
                            break;
                        case 1:
                            //update drinktable
                            String striddrink = jsonObject.getString("ID");
                            String strdrink = jsonObject.getString("Drink");
                            String strsource = jsonObject.getString("Source");
                            String strprice = jsonObject.getString("Price");
                            addValue = objDrinkTABLE.addNewDrink(strdrink, strsource, strprice);
                            break;
                        default:
                            // update ordertable
                            String stridorder = jsonObject.getString("ID");
                            String strorder = jsonObject.getString("Drink");
                            String strofficer = jsonObject.getString("Officer");
                            String strdesk = jsonObject.getString("Desk");
                            String strItem = jsonObject.getString("Item");
                            String strTotal = jsonObject.getString("TotalPrice");
                            addValue = objOrderTABLE.addNewOrder(strorder,strofficer,strdesk,strItem,strTotal);
                            break;
                    }
                }
            }catch (Exception e){
                Log.d("HealthyShop","Update SQLite ==>"+e.toString());
            }
            //increase inttime
            intTimes += 1;
        }
    }// synjson


    public void onClickLogout (View view){
        Intent intent = new Intent(MainActivity.this,EnterYourName.class);
        startActivity(intent);
        finish();


    }

    public void onClickMenu(View view){
        Intent intent = new Intent(MainActivity.this,MenuHealth.class);
        startActivity(intent);
    }
}
