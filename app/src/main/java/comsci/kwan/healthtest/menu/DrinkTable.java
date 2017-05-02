package comsci.kwan.healthtest.menu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import comsci.kwan.healthtest.MySQLite;

/**
 * Created by kwan_raksasook on 24/4/2560.
 */

public class DrinkTable {
    private MySQLite objMySQLiteOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase;
    private SQLiteDatabase readSqLiteDatabase;

    public static final String DRINK_TABLE = "Drinktable";
    public static final String COLUMN_ID = "ID_Drink";
    public static final String COLUMN_DRINK = "Name";
    public static final String COLUMN_DETAIL = "Detail";
    public static final String COLUMN_SOURCE = "Source";
    public static final String COLUMN_PRICE = "Price";


    public DrinkTable(Context context){
        objMySQLiteOpenHelper = new MySQLite(context);
        writeSqLiteDatabase = objMySQLiteOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMySQLiteOpenHelper.getReadableDatabase();
    }

    public long addNewDrink(String strDrink,String strDetail,String strSource,String strPrice){
        ContentValues objContentValues = new ContentValues();
        objContentValues.put(COLUMN_DRINK,strDrink);
        objContentValues.put(COLUMN_DETAIL,strDetail);
        objContentValues.put(COLUMN_SOURCE,strSource);
        objContentValues.put(COLUMN_PRICE,strPrice);

        return writeSqLiteDatabase.insert(DRINK_TABLE,null, objContentValues);
    }

    public String[] readAllFood (int intColumn){
        String[] strReadALL = null;
        Cursor cursor = readSqLiteDatabase.query(DRINK_TABLE,new String[]{COLUMN_ID, COLUMN_DRINK, COLUMN_DETAIL,
        COLUMN_SOURCE,COLUMN_PRICE}, null, null , null, null, null);

        if (cursor != null);
        cursor.moveToFirst();
        strReadALL = new String[cursor.getCount()];
        for (int i = 0; i<= cursor.getCount(); i++){
            switch (intColumn){
                case 1:
                    strReadALL[i] = cursor.getString(cursor.getColumnIndex(COLUMN_DRINK));
                    break;
                case 2:
                    strReadALL[i] = cursor.getString(cursor.getColumnIndex(COLUMN_SOURCE));
                    break;
                default:
                    strReadALL[i] = cursor.getString(cursor.getColumnIndex(COLUMN_PRICE));
                    break;
            }
            cursor.moveToNext();
        }
        return strReadALL;
    }
}


