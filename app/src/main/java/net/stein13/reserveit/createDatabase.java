package net.stein13.reserveit;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import net.stein13.reserveit.R;

public class createDatabase extends Activity {
public abstract class SQLHelp extends SQLiteOpenHelper {
        static final String DATABASE_NAME = "Reservations.db";
        static final String TABLE_RESERVATIONS = "Reservations";
        static final String NAME_COLUMN = "Name";
        static final String EMAIL_COLUMN = "E-mail";
        static final String PHONENUMBER_COLUMN = "Phone Number";
        static final String ADDRESS_COLUMN = "Street Address";
        static final String ZIP_COLUMN = "Zip Code";
        static final String ARRIVAL_COLUMN = "Arrival Date";
        static final String DEPARTURE_COLUMN = "Departure Date";
        static final String NOTES_COLUMN = "Notes Area";
        static final String ROOM_COLUMN = "Room Number";

        public SQLHelp(Context c){
            super(c, DATABASE_NAME, null, 1);
        }

    public void onCreate(SQLiteDatabase db){
        String makeTable = "CREATE TABLE " + TABLE_RESERVATIONS + "("
                + NAME_COLUMN + " TEXT," + EMAIL_COLUMN + " TEXT,"
                + PHONENUMBER_COLUMN + " INTEGER," + ADDRESS_COLUMN + " TEXT,"
                + ZIP_COLUMN + " TEXT," + ARRIVAL_COLUMN + " INTEGER,"
                + DEPARTURE_COLUMN + " INTEGER," + ROOM_COLUMN + "INTEGER" + NOTES_COLUMN + " TEXT,"+ ")";
        db.execSQL(makeTable);
    }

}}
