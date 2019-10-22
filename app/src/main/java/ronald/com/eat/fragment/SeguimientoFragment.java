package ronald.com.eat.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;


import ronald.com.eat.R;

public class SeguimientoFragment extends Fragment
{
    View rootView;

    public static SeguimientoFragment newInstance()
    {
        return new SeguimientoFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        rootView=inflater.inflate(R.layout.seguimiento_fragment, container, false);


        PieChart piechart = rootView.findViewById(R.id.gr);
        piechart.setUsePercentValues(true);

        Description descripcion = new Description();
        descripcion.setText("Valor nutricional");
        descripcion.setTextSize(20f);

        piechart.setDescription(descripcion);
        piechart.setHoleRadius(25f);
        piechart.setTransparentCircleRadius(25f);

        List<PieEntry> value = new ArrayList<>();
        value.add(new PieEntry(38f, "Carbohidratos"));
        value.add(new PieEntry(37f, "Grasas"));
        value.add(new PieEntry(25f, "Proteinas"));
        value.add(new PieEntry(38f, "Carbohidratos"));

        PieDataSet piedataset = new PieDataSet(value ,"Nutriente");

        PieData piedata = new PieData(piedataset);

        piechart.setData(piedata);
        piedataset.setColors(ColorTemplate.JOYFUL_COLORS);

        piechart.animateXY(1400, 1400);

        return rootView;
    }
}
