package comsci.kwan.healthtest.menu;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;

import comsci.kwan.healthtest.MySQLite;

/**
 * Created by kwan_raksasook on 24/4/2560.
 */

public class OrderTable {
    private MySQLite objMySQLiteOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase;
    private SQLiteDatabase readSqLiteDatabase;

    public static final String ORDER_TABLE = "Ordertable";
    public static final String COLUMN_ID = "ID_Order";
    public static final String COLUMN_DRINK = "Name";
    public static final String COLUMN_DESK = "Desk";
    public static final String COLUMN_DATE = "Date";
    public static final String COLUMN_ITEM = "Item";
    public static final String COLUMN_OFFICER = "Officer";
    public static final String COLUMN_TOTALPRICE = "TotalPrice";

    public OrderTable(Context context){
        objMySQLiteOpenHelper = new MySQLite(context);
        writeSqLiteDatabase = objMySQLiteOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMySQLiteOpenHelper.getReadableDatabase();
    }

    public long addNewOrder(String strDrink, String strDesk,String strDate, String strItem, String strOfficer,String strTotalPrice){
        ContentValues objContentValues = new ContentValues();
        objContentValues.put(COLUMN_DRINK,strDrink);
        objContentValues.put(COLUMN_DESK,strDesk);
        objContentValues.put(COLUMN_DATE,strDate);
        objContentValues.put(COLUMN_ITEM,strItem);
        objContentValues.put(COLUMN_OFFICER,strOfficer);
        objContentValues.put(COLUMN_TOTALPRICE,strTotalPrice);

        return writeSqLiteDatabase.insert(ORDER_TABLE,null, objContentValues);
    }



}
