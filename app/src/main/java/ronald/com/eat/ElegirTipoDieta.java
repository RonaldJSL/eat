package ronald.com.eat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.View;

public class ElegirTipoDieta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_tipo_dieta);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    public void IrAlimentacionSalu (View v)
    {
        Intent a = new Intent(this, CalcularConsumoPromedio.class);
        startActivity(a);
    }

    public void IrGanarPeso(View v)
    {
        Intent g= new Intent(this,GanarPeso.class);
        startActivity(g);
    }

    public void IrPerderPeso (View v)
    {
        Intent l = new Intent(this, PerderPeso.class);
        startActivity(l);
    }
}