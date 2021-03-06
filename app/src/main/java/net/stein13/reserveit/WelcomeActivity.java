package net.stein13.reserveit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Explode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;


public class WelcomeActivity extends Activity {
// Hi Hunter!
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.welcome, menu);
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


    public void NewReservation(View view) {
        Intent intent = new Intent(this, newReservation.class);
        startActivity(intent);
        Toast toast = Toast.makeText(getApplicationContext(), "Creating New Reservation..", Toast.LENGTH_SHORT);
        toast.show();
    }


    public void tellAbout(MenuItem item) {
        Intent intent = new Intent(this, aboutApp.class);
        startActivity(intent);

    }

    public void createDatabase(MenuItem item) {
        Intent intent = new Intent(this, createDatabase.class);
        startActivity(intent);
    }
}
