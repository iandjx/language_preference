package io.techup.android.languagepreference;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new AlertDialog.Builder(this)
                .setIcon(R.drawable.ic_language_black_24dp)
                .setTitle("Choose a language")
                .setMessage("Which language do you like?")
                .setPositiveButton("SPANISH", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "its done", Toast.LENGTH_LONG).show();
                    }
                })
                .setNegativeButton("ENGLISH", null)
                .show();
    }
}
