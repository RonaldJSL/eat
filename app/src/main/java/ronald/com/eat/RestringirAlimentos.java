package ronald.com.eat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RestringirAlimentos extends AppCompatActivity implements View.OnClickListener {

    ExpandableListView expandableListView;
    List<String> listaGrupo;
    HashMap<String,List<String>> listaItem;

    MainAdapter adapter;
    Button siguiente, regresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restringir_alimentos);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        siguiente=findViewById(R.id.btnSig);
        regresar=findViewById(R.id.btnRegresa);

        siguiente.setOnClickListener(this);
        regresar.setOnClickListener(this);

        expandableListView = findViewById(R.id.expandable_listview);
        listaGrupo=new ArrayList<>();
        listaItem=new HashMap<>();

        adapter=new MainAdapter(this,listaGrupo,listaItem);
        expandableListView.setAdapter(adapter);

        iniciaListaData();
    }

    private void iniciaListaData()
    {
        listaGrupo.add(getString(R.string.grupo1));
        listaGrupo.add(getString(R.string.grupo2));
        listaGrupo.add(getString(R.string.grupo3));
        listaGrupo.add(getString(R.string.grupo4));

        String[] array;

        List<String> lista1=new ArrayList<>();
        array = getResources().getStringArray(R.array.grupo1);
        for(String item:array)
        {
            lista1.add(item);
        }

        List<String> lista2=new ArrayList<>();
        array = getResources().getStringArray(R.array.grupo2);
        for(String item:array)
        {
            lista2.add(item);
        }

        List<String> lista3=new ArrayList<>();
        array = getResources().getStringArray(R.array.grupo3);
        for(String item:array)
        {
            lista3.add(item);
        }

        List<String> lista4=new ArrayList<>();
        array = getResources().getStringArray(R.array.grupo4);
        for(String item:array)
        {
            lista4.add(item);
        }

        listaItem.put(listaGrupo.get(0),lista1);
        listaItem.put(listaGrupo.get(1),lista2);
        listaItem.put(listaGrupo.get(2),lista3);
        listaItem.put(listaGrupo.get(3),lista4);

        adapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.btnSig:
                Intent a = new Intent(this,MostrarDieta.class);
                startActivity(a);
                break;
            case R.id.btnRegresa:
                Intent b =new Intent(this,IngresarPreferencias.class);
                startActivity(b);
                break;
        }
    }
}
