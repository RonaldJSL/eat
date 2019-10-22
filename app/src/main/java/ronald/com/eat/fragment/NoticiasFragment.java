package ronald.com.eat.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import ronald.com.eat.R;

public class NoticiasFragment extends Fragment
{
    public static NoticiasFragment newInstance()
    {
        return new NoticiasFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.noticias_fragment, container, false);
        return view;
    }
}
