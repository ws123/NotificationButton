package com.carlos.notificationbutton;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.carlos.notificatoinbutton.library.NotificationButton;

public class MainActivity extends AppCompatActivity {
    private NotificationButton button2, button3, button4, button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button2 = (NotificationButton) findViewById(R.id.button2);
        button3 = (NotificationButton) findViewById(R.id.button3);
        button4 = (NotificationButton) findViewById(R.id.button4);
        button5 = (NotificationButton) findViewById(R.id.button5);
        button2.setNotificationNumber(120);
        button3.setNotificationNumber(85);
        button4.setNotificationNumber(9);
        button5.setNotificationNumber(0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
