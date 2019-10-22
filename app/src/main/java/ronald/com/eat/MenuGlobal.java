package ronald.com.eat;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import ronald.com.eat.fragment.ActividadesFragment;
import ronald.com.eat.fragment.MasFragment;
import ronald.com.eat.fragment.NoticiasFragment;
import ronald.com.eat.fragment.PerfilFragment;
import ronald.com.eat.fragment.SeguimientoFragment;

public class MenuGlobal extends AppCompatActivity {

    private BottomNavigationView bnview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_global);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        init();

        cambiarFragment(NoticiasFragment.newInstance());

        bnview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId())
                {
                    case R.id.m_noticias:
                        cambiarFragment(NoticiasFragment.newInstance());
                        return true;

                    case R.id.m_seguimiento:
                        cambiarFragment(SeguimientoFragment.newInstance());
                        return true;

                    case R.id.m_perfil:
                        cambiarFragment(PerfilFragment.newInstance());
                        return true;

                    case R.id.m_mas:
                        cambiarFragment(MasFragment.newInstance());
                        return true;

                    case R.id.m_actividad:
                        cambiarFragment(ActividadesFragment.newInstance());
                        return true;
                }
                return false;
            }
        });
    }

    private void init()
    {
        this.bnview=findViewById(R.id.bnview);
    }

    private void cambiarFragment(Fragment fragment)
    {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame, fragment);
        transaction.commit();
    }
}
