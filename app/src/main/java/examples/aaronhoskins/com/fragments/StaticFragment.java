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


public class StaticFragment extends Fragment implements View.OnClickListener {
    EditText etUserInputStatic;
    Button btnSendToMain;

    private OnStaticFragmentInteractionListener mListener;

    public StaticFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_static, container, false);
    }
    //Bind the views and initialize listeners
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etUserInputStatic = view.findViewById(R.id.etStaticInput);
        btnSendToMain = view.findViewById(R.id.btnSendToActivity);
        btnSendToMain.setOnClickListener(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnStaticFragmentInteractionListener) {
            mListener = (OnStaticFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnStaticFragmentInteractionListener");
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
            String userInput = etUserInputStatic.getText().toString();//Get the user input
            mListener.onSendActivity(userInput); //Send the userInput through the interface
        }
    }

    //Used for fragment communication pipeline
    public interface OnStaticFragmentInteractionListener {
        void onSendActivity(String passedInfo);
    }
}
