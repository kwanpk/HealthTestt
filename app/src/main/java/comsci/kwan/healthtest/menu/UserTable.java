package comsci.kwan.healthtest.menu;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import comsci.kwan.healthtest.MySQLite;

/**
 * Created by kwan_raksasook on 27/4/2560.
 */

public class UserTable {
    private MySQLite objMySQLiteOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase;
    private SQLiteDatabase readSqLiteDatabase;

    public static final String USER_TABLE = "userTable";
    public static final String COLUMN_USER = "user";


    public UserTable(Context context){
        objMySQLiteOpenHelper = new MySQLite(context);
        writeSqLiteDatabase = objMySQLiteOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMySQLiteOpenHelper.getReadableDatabase();
    }

    public long addNewUser(String strUser){
        ContentValues objContentValues = new ContentValues();
        objContentValues.put(COLUMN_USER,strUser);

        return readSqLiteDatabase.insert(USER_TABLE,null, objContentValues);
    }
}
