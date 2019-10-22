package ronald.com.eat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InsertarActividades extends AppCompatActivity implements View.OnClickListener {

    Button btnsiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_actividades);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        btnsiguiente=findViewById(R.id.btnNextAct);
        btnsiguiente.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent a = new Intent(this, IngresarPreferencias.class);
        startActivity(a);
    }
}
