package comsci.kwan.healthtest.menu;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import comsci.kwan.healthtest.MySQLite;

/**
 * Created by kwan_raksasook on 24/4/2560.
 */

public class DrinkTable {
    private MySQLite objMySQLiteOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase;
    private SQLiteDatabase readSqLiteDatabase;

    public static final String DRINK_TABLE = "drinkTable";
    public static final String COLUMN_ID_DRINK = "_id";
    public static final String COLUMN_DRINKMAME = "drink";
    public static final String COLUMN_SOURCE = "source";
    public static final String COLUMN_PRICE = "price";


    public DrinkTable(Context context){
        objMySQLiteOpenHelper = new MySQLite(context);
        writeSqLiteDatabase = objMySQLiteOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMySQLiteOpenHelper.getReadableDatabase();
    }

    public long addNewDrink(String strDrink,String strSource,String strPrice){
        ContentValues objContentValues = new ContentValues();
        objContentValues.put(COLUMN_DRINKMAME,strDrink);
        objContentValues.put(COLUMN_SOURCE,strSource);
        objContentValues.put(COLUMN_PRICE,strPrice);

        return writeSqLiteDatabase.insert(DRINK_TABLE,null, objContentValues);
    }
}


