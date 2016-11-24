package io.techup.android.languagepreference;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView languageTv;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        switch (item.getItemId()) {
            case R.id.menu_english:
                languageTv.setText("English");
                return true;


            case R.id.menu_spanish:
                languageTv.setText("Spanish");
                return true;
            default:
                return false;
        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        languageTv = (TextView) findViewById(R.id.tv_language);
        new AlertDialog.Builder(this)
                .setIcon(R.drawable.ic_language_black_24dp)
                .setTitle("Choose a language")
                .setMessage("Which language do you like?")
                .setPositiveButton("SPANISH", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        languageTv.setText("Spanish");
                    }
                })
                .setNegativeButton("ENGLISH", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        languageTv.setText("English");
                    }
                })
                .show();
    }
}
