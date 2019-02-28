package examples.aaronhoskins.com.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class OutputFragment extends Fragment {
    TextView tvOutputDynamic;
    TextView tvOutputStatic;

    public OutputFragment() {
        // Required empty public constructor
    }


    public static OutputFragment newInstance() {
        OutputFragment fragment = new OutputFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_output, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvOutputDynamic = view.findViewById(R.id.tvInfoDynamic);
        tvOutputStatic = view.findViewById(R.id.tvInfoStatic);
    }

    public void setDynamicOutput(String string) {
        tvOutputDynamic.setText(string);
    }

    public void setStaticOutput(String string) {
        tvOutputStatic.setText(string);
    }

}
