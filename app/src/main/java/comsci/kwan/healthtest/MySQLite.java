package comsci.kwan.healthtest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kwan_raksasook on 24/4/2560.
 */

public class MySQLite extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "health2.db";//กำหนดชื่อไฟล์ Database
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_USER_TABLE = "create table uerTABLE"+
            "(_id integer primary key, User text);";
    private static final String CREATE_DRINK_TABLE = "create table drinkTABLE"+
            "(_id integer primary key, Drink text, Picture text, Price text);";
    private static final String CREATE_ORDER_TABLE = "create table orderTABLE"+
            "(_id integer primary key, officer text ,Drink text, Desk text, Item text);";

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
