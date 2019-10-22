package ronald.com.eat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DatosUsuario extends AppCompatActivity implements View.OnClickListener {

    private Button btn1;
    private EditText edt1, edt2, edt3;
    private TextView txtv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_usuario);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        variables();
        btn1.setOnClickListener(this);
    }

    private void variables()
    {
        btn1 = findViewById(R.id.btnCalcularTMB);
        edt1 = findViewById(R.id.edtAños);
        edt2 = findViewById(R.id.edtTalla);
        edt3 = findViewById(R.id.edtPeso);
        txtv1 = findViewById(R.id.txtprueba);
    }

    @Override
    public void onClick(View view)
    {
        double edad = Double.parseDouble(edt1.getText().toString());
        double altura = Double.parseDouble(edt2.getText().toString());
        double peso = Double.parseDouble(edt3.getText().toString());
        double rTMS = 66 + (13.75 * peso) + (5 * altura) - (6.7 * edad);

        txtv1.setText(String.valueOf(rTMS));

        Intent i = new Intent(this, CalcularConsumoPromedio.class );
        i.putExtra("kcal", txtv1.getText().toString());
        startActivity(i);
    }
}
