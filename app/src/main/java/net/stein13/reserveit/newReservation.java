package net.stein13.reserveit;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Explode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import net.stein13.reserveit.R;

public class newReservation extends Activity {
    DBAdapter db = new DBAdapter(this);
    @TargetApi(Build.VERSION_CODES.L)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_reservation);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.new_reservation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void tellAbout(MenuItem item) {
        Intent intent = new Intent(this, aboutApp.class);
        startActivity(intent);
    }

    public void createReservation(View view) {
        db.open();
        EditText nameText = (EditText)findViewById(R.id.nameText);
        String nameValue = nameText.getText().toString();
        EditText emailText = (EditText)findViewById(R.id.emailText);
        String emailValue = emailText.getText().toString();
        EditText phoneNumber = (EditText)findViewById(R.id.phoneNumber);
        String phoneValue = phoneNumber.getText().toString();
        EditText addressText = (EditText)findViewById(R.id.addressText);
        String addressValue = addressText.getText().toString();
        EditText zipNumber = (EditText)findViewById(R.id.zipNumber);
        String zipValue = zipNumber.getText().toString();
        EditText arrivalDate = (EditText)findViewById(R.id.arrivalDate);
        String arrivalValue = arrivalDate.getText().toString();
        EditText departureDate = (EditText)findViewById(R.id.departureDate);
        String departureValue = departureDate.getText().toString();
        EditText notesArea = (EditText)findViewById(R.id.notesText);
        String notesValue = notesArea.getText().toString();

        db.insertReservation(nameValue, emailValue, phoneValue, addressValue, zipValue, arrivalValue, departureValue, notesValue);
        Toast toast = Toast.makeText(getApplicationContext(), "Creating Reservation", Toast.LENGTH_LONG);
        toast.show();
        db.close();
    }
}
