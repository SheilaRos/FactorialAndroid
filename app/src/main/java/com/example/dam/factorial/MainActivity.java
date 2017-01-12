package com.example.dam.factorial;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView valor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        valor = (TextView) findViewById(R.id.valor);
        FactorialTask task = new FactorialTask();
        task.execute();

        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Click", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public class FactorialTask extends AsyncTask<Void, String, Void>{

        @Override
        protected Void doInBackground(Void... params) {
            for(int n = 0; n<10000; n++){
                int res = 1;
                for(int i = 1; i<=n; i++){
                    res*=i;
                }
                String text = n + "!=" + res;
                publishProgress(text);
                try{Thread.sleep(1000);}catch (InterruptedException e){}
            }
            return null;
        }

        @Override public void onProgressUpdate(String...args){
            String text = args[0];
            valor.setText(text);
        }
    }
}
