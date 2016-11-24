package io.techup.android.languagepreference;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    TextView languageTv;
    SharedPreferences sharedPreferences;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        switch (item.getItemId()) {
            case R.id.menu_english:
                languageTv.setText("English");
                saveSelectedLanguage("English");
                return true;


            case R.id.menu_spanish:
                languageTv.setText("Spanish");
                saveSelectedLanguage("Spanish");
                return true;
            case R.id.menu_reset:
                languageTv.setText("");
                saveSelectedLanguage("");
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
        sharedPreferences = this.getSharedPreferences("io.techup.android.languagepreference", Context.MODE_PRIVATE);
        languageTv = (TextView) findViewById(R.id.tv_language);

        languageTv.setText(sharedPreferences.getString("language", ""));
        if(languageTv.getText() == ""){
            new AlertDialog.Builder(this)
                    .setIcon(R.drawable.ic_language_black_24dp)
                    .setTitle("Choose a language")
                    .setMessage("Which language do you like?")
                    .setPositiveButton("SPANISH", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            languageTv.setText("Spanish");
                            saveSelectedLanguage("Spanish");

                        }
                    })
                    .setNegativeButton("ENGLISH", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            languageTv.setText("English");
                            saveSelectedLanguage("English");
                        }
                    })
                    .show();
        }

    }

    private void saveSelectedLanguage(String language) {
        sharedPreferences.edit().putString("language", language).apply();

    }


}
