package com.example.administrator.movieonline;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
import android.content.Context;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    public static final String CREATE_ACCOUNT = "create table Account ("
            + "a_id integer primary key autoincrement not null, "
            + "password text not null, "
            + "email text not null )";


    public static final String CREATE_MOVIE = "create table Movie ("
            + "m_id integer primary key autoincrement not null, "
            + "name text not null, "
            + "blurb text not null, "
            + "certificate integer not null, "
            + "director text not null, "
            + "lead_actors text not null, "
            + "release_date date not null, "
            + "duration integer not null)";

    public static final String CREATE_MOVIE_HALL = "create table Movie_Hall ("
            + "h_id integer primary key autoincrement not null, "
            + "type text not null, "
            + "row_number integer not null, "
            + "column_number integer not null)";


    public static final String CREATE_MOVIE_ORDER = "create table Movie_Order ("
            + "o_id integer primary key autoincrement not null, "
            + "a_id integer not null, "
            + "s_id integer not null, "
            + "row_str text not null, "
            + "cloumn_str text not null, "
            + "ticket_number integer not null, "
            + "original_price real not null, "
            + "actual_price real not null, "
            + "status integer not null)";

    public static final String CREATE_SCHEDULE = "create table Schedule ("
            + "s_id integer primary key autoincrement not null, "
            + "m_id integer not null, "
            + "h_id integer not null, "
            + "start_time time not null, "
            + "duration integer not null, "
            + "price real not null)";

    private Context mContext;

    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_ACCOUNT);
        db.execSQL(CREATE_MOVIE);
        db.execSQL(CREATE_MOVIE_HALL);
        db.execSQL(CREATE_MOVIE_ORDER);
        db.execSQL(CREATE_SCHEDULE);
        Toast.makeText(mContext, "Create succeeded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
     //   db.execSQL("drop table if exists Account");
       // db.execSQL("drop table if exists Movie");
        //onCreate(db);
    }
}
