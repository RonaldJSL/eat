package ronald.com.eat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MostrarDieta extends AppCompatActivity implements View.OnClickListener {

    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator=new ArgbEvaluator();
    Button btnsig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_dieta);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        btnsig=findViewById(R.id.btnSiguiente);
        btnsig.setOnClickListener(this);

        models=new ArrayList<>();
        models.add(new Model(R.drawable.pimientos_quinoa, "Pimientos rellenos de quinoa", "Una receta de aprovechamiento de sobras que nos alegra una comida o una cena. Podemos aprovechar unas sobras de quinoa con champiñones o de tabouleh de quinoa para rellenar unos pimientos"));
        models.add(new Model(R.drawable.huevos_revueltos, "Huevos revueltos", "Os enseñamos dos propuestas, con ensalada y taquitos de jamón o con unas sobras de pisto que, en esta ocasión, no tenía salsa de tomate."));
        models.add(new Model(R.drawable.salmon_plancha, "Salmón a la plancha", "Se prepara en 5 minutos y acompañado de verduras a la plancha como calabacín o berenjena o de una buena ensalada y es un plato completísimo para esos momentos en los que es imposible sacar tiempo"));
        models.add(new Model(R.drawable.pollo_plancha, "Pollo a la plancha", "En este caso, plato perfecto acompañada de un poco de ensalada y unas sobras de arroz con verduras al pimentón."));

        adapter = new Adapter(models, this);

        viewPager =findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130,0,130,0);

        Integer[] colors_temp={
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4),
        };

        colors=colors_temp;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position<(adapter.getCount()-1)&& position<(colors.length-1))
                {
                    viewPager.setBackgroundColor((Integer)argbEvaluator.evaluate(positionOffset, colors[position], colors[position+1]));
                }
                else
                    {
                        viewPager.setBackgroundColor(colors[colors.length-1]);
                    }
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        Intent a = new Intent(this, MenuGlobal.class);
        startActivity(a);
    }
}
