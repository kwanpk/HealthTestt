package comsci.kwan.healthtest.menu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import comsci.kwan.healthtest.MySQLite;

/**
 * Created by kwan_raksasook on 27/4/2560.
 */

public class UserTable {
    private MySQLite objMySQLiteOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase;
    private SQLiteDatabase readSqLiteDatabase;

    public static final String USER_TABLE = "Usertable";
    public static final String COLUMN_ID = "ID_Desk";
    public static final String COLUMN_USER = "Desk";


    public UserTable(Context context){
        objMySQLiteOpenHelper = new MySQLite(context);
        writeSqLiteDatabase = objMySQLiteOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMySQLiteOpenHelper.getReadableDatabase();
    }

    public String[] searchUser(String struser){
        try{
            String[] strResult = null;
            Cursor cursor = readSqLiteDatabase.query(USER_TABLE, new String[]{ COLUMN_ID, COLUMN_USER},
                    COLUMN_USER + "?", new String[]{String.valueOf(struser)},
                    null,null,null,null);
            if (cursor !=null){
                strResult = new String[2];
                strResult[0] = cursor.getString(0);
                strResult[1] = cursor.getString(1);
            }
            cursor.close();
            return strResult;
        }catch (Exception e){
            return null;
        }

    }



    public long addNewUser(String strUser){
        ContentValues objContentValues = new ContentValues();
        objContentValues.put(COLUMN_USER,strUser);

        return writeSqLiteDatabase.insert(USER_TABLE,null, objContentValues);
    }




}
