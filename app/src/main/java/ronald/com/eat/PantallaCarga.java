package ronald.com.eat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class PantallaCarga extends AppCompatActivity {

    private int duracioncarga = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_pantalla_carga);

        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent a = new Intent(PantallaCarga.this,DatosUsuario.class);
                startActivity(a);
                finish();
            };
        }, duracioncarga);
    }
}
