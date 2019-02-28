package examples.aaronhoskins.com.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class DynamicFragment extends Fragment implements View.OnClickListener {
    EditText etDynamicInput;
    Button btnSendDynamicInfoToMain;

    private OnDynamicFragmentInteractionListener mListener;

    public DynamicFragment() {
        // Required empty public constructor
    }


    public static DynamicFragment newInstance() {
        DynamicFragment fragment = new DynamicFragment();
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
        return inflater.inflate(R.layout.fragment_dynamic, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etDynamicInput = view.findViewById(R.id.etDynamicInput);
        btnSendDynamicInfoToMain = view.findViewById(R.id.btnSendToActivityFromDynamic);
        btnSendDynamicInfoToMain.setOnClickListener(this);
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnDynamicFragmentInteractionListener) {
            mListener = (OnDynamicFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnDynamicFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        if (mListener != null) {
            String input = etDynamicInput.getText().toString();
            mListener.onDynamicSendToMain(input);
        }
    }

    public interface OnDynamicFragmentInteractionListener {
        void onDynamicSendToMain(String infoPassed);
    }
}
