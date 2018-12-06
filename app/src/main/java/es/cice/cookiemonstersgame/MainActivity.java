package es.cice.cookiemonstersgame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.String;

public class MainActivity extends AppCompatActivity {

    private ProgressBar pBar1;
    private ProgressBar pBar2;
    private ProgressBar pBar3;
    private Button btnStartOven;
    private Button btnCancel;
    private ovenAsyntask ovenAsyn;
    private monsterAsyntask monster1Asyn;
    private monsterAsyntask monster2Asyn;
    private tarroGalletas tarroG;
    EditText editTextCookie;
    EditText editTextTime;
    private boolean isStarted;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ovenAsyn = new ovenAsyntask();
        monster1Asyn = new monsterAsyntask();
        monster2Asyn = new monsterAsyntask();

        editTextCookie = (EditText) findViewById(R.id.editTextCookie);
        editTextTime = (EditText) findViewById(R.id.editTextTime);

        tarroG = tarroGalletas.getInstance();

        pBar1 = (ProgressBar) findViewById(R.id.pBar1);
        pBar2 = (ProgressBar) findViewById(R.id.pBar2);
        pBar3 = (ProgressBar) findViewById(R.id.pBar3);

        btnStartOven = (Button) findViewById(R.id.btnStartOven);
        btnStartOven.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                isStarted = true;
                int numCookie = Integer.parseInt(editTextCookie.getText().toString());
                int numTime = Integer.parseInt(editTextTime.getText().toString());
                if (numCookie <= 0 || numCookie == ' ') {
                    System.out.println("Please insert cookie limits for the application!");
                }
                if (numTime <= 0 || numTime == ' ') {
                    System.out.println("Please insert time limits of the contest for the application!");
                }
                lanzarOven();
                lanzarMonsters();
            }
        });

        btnCancel = (Button) findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                isStarted = false;
            }
        });
    }
    public void lanzarOven(){
        ovenAsyn.execute(5000);
    }
    public void lanzarMonsters(){
        monster1Asyn.execute();
        monster2Asyn.execute();
    }
}
