package net.stein13.reserveit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
public class DBAdapter
{
    int id = 0;
    public static final String TAG = "YOUR-TAG-NAME";
    public static final String KEY_ROWID = "_id";
    static final String DATABASE_NAME = "Reservations.db";
    static final String TABLE_RESERVATIONS = "Reservations";
    static final String NAME_COLUMN = "Name";
    static final String EMAIL_COLUMN = "E-mail";
    static final String PHONENUMBER_COLUMN = "Phone Number";
    static final String ADDRESS_COLUMN = "Street Address";
    static final String ZIP_COLUMN = "Zip Code";
    static final String ARRIVAL_COLUMN = "Arrival Date";
    static final String DEPARTURE_COLUMN = "Departure Date";
    static final String ROOM_COLUMN = "Room Number";
    static final String NOTES_COLUMN = "Notes Area";

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE =
            "create table reservations (_id integer primary key autoincrement, "
                    + "Name text not null );";

    private final Context context;

    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;
    public DBAdapter(Context ctx)
    {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper
    {
        DatabaseHelper(Context context)
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db){
            String makeTable = "CREATE TABLE " + TABLE_RESERVATIONS + "("
                    + NAME_COLUMN + " TEXT," + EMAIL_COLUMN + " TEXT,"
                    + PHONENUMBER_COLUMN + " INTEGER," + ADDRESS_COLUMN + " TEXT,"
                    + ZIP_COLUMN + " TEXT," + ARRIVAL_COLUMN + " INTEGER,"
                    + DEPARTURE_COLUMN + " INTEGER," + ROOM_COLUMN + "INTEGER" + NOTES_COLUMN + " TEXT,"+ ")";
            db.execSQL(makeTable);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion,
                              int newVersion)
        {
            Log.w(TAG, "Upgrading database from version " + oldVersion
                    + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS reservations");
            onCreate(db);
        }
    }
    //---opens the database---
    public DBAdapter open() throws SQLException
    {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    //---closes the database---
    public void close()
    {
        DBHelper.close();
    }
    public long insertReservation(String nameValue, String  emailValue, String  phoneValue, String  addressValue, String zipValue, String arrivalValue, String departureValue, String notesValue, String roomValue)
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(NAME_COLUMN, nameValue);
        initialValues.put(EMAIL_COLUMN, emailValue);
        initialValues.put(PHONENUMBER_COLUMN, phoneValue);
        initialValues.put(ADDRESS_COLUMN, addressValue);
        initialValues.put(ZIP_COLUMN, zipValue);
        initialValues.put(ARRIVAL_COLUMN, arrivalValue);
        initialValues.put(DEPARTURE_COLUMN, departureValue);
        initialValues.put(NOTES_COLUMN, notesValue);
        initialValues.put(ROOM_COLUMN, roomValue);

        return db.insert(TABLE_RESERVATIONS, null, initialValues);
    }
    public int getAllEntries()
    {
        Cursor cursor = db.rawQuery(
                "SELECT COUNT(Quote) FROM tblReservations", null);
        if(cursor.moveToFirst()) {
            return cursor.getInt(0);
        }
        return cursor.getInt(0);

    }
}