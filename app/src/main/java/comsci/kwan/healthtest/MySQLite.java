package comsci.kwan.healthtest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kwan_raksasook on 24/4/2560.
 */

public class MySQLite extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "health.db";//กำหนดชื่อไฟล์ Database
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_USER_TABLE = "create table Usertable"+
            "(User text);";
    private static final String CREATE_DRINK_TABLE = "create table Drinktable"+
            "(ID_Drink integer primary key, Name text,Detail text, Source text, Price text);";
    private static final String CREATE_ORDER_TABLE = "create table Ordertable"+
            "(ID_Order integer primary key, Name text ,Desk text, Date text, Item text, Officer text , TotalPrice text);";

    public MySQLite(Context context){
        super(context, DATABASE_NAME,null,DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_USER_TABLE);
        sqLiteDatabase.execSQL(CREATE_DRINK_TABLE);
        sqLiteDatabase.execSQL(CREATE_ORDER_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
