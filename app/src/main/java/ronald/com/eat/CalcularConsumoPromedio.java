package ronald.com.eat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;


public class CalcularConsumoPromedio extends AppCompatActivity {

    private TextView txtv1;
    private Button btn1;
    private ProgressBar barraprogreso;
    private int estadobarraprogreso = 0;

    private Handler mhandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_consumo_promedio);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        final String kcal = getIntent().getStringExtra("kcal");
        txtv1 = findViewById(R.id.txtkcal);
        final double progresonum= Double.parseDouble(kcal);
        btn1= findViewById(R.id.btnContinuar);
        barraprogreso=findViewById(R.id.pgbarkcal);

        txtv1.setText(kcal);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(estadobarraprogreso<progresonum)
                {
                    estadobarraprogreso=estadobarraprogreso+1000;
                    android.os.SystemClock.sleep(10);
                    mhandler.post(new Runnable() {
                        @Override
                        public void run() {
                            barraprogreso.setProgress(estadobarraprogreso);
                        }
                    });
                }

                mhandler.post(new Runnable() {
                    @Override
                    public void run() {
                        txtv1.setVisibility(View.VISIBLE);
                    }
                });
            }
        });
    }

    public void Continuar (View view)
    {
        Intent i = new Intent(this, InsertarActividades.class );
        i.putExtra("kcal", txtv1.getText().toString());
        startActivity(i);
    }

}
