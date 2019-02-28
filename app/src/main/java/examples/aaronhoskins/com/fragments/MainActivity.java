package examples.aaronhoskins.com.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
        StaticFragment.OnStaticFragmentInteractionListener,
        DynamicFragment.OnDynamicFragmentInteractionListener {

    OutputFragment outputFragment;
    FragmentManager fragmentManager;

    private static final String DYNAMIC_FRAG_ONE_TAG = "dynamic_frag_one";
    private static final String OUTPUT_FRAG_ONE_TAG = "output_frag_one";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        outputFragment = OutputFragment.newInstance();
        //Fragment Manager
        fragmentManager = getSupportFragmentManager();
        //use fragment manager to begin fragment transaction, replace the frag in layout with the
        //    fragment we want there, add it to back stack with a tag, and commit the transaction
        fragmentManager
                .beginTransaction()
                .replace(R.id.frmDynamicOne, DynamicFragment.newInstance())
                .addToBackStack(DYNAMIC_FRAG_ONE_TAG)
                .commit();

        fragmentManager
                .beginTransaction()
                .replace(R.id.frmOutput, outputFragment)
                .addToBackStack(OUTPUT_FRAG_ONE_TAG)
                .commit();

    }

    //Receive info sent from the static fragment
    @Override
    public void onSendActivity(String passedInfo) {
        //Toast.makeText(this, passedInfo, Toast.LENGTH_SHORT).show();
        outputFragment.setStaticOutput(passedInfo);//send to output fragment
    }

    //Receive info sent from the dynamic fragment
    @Override
    public void onDynamicSendToMain(String infoPassed) {
        //Toast.makeText(this, infoPassed, Toast.LENGTH_SHORT).show();
        outputFragment.setDynamicOutput(infoPassed);//send to output fragment
    }

    public void onClick(View view) {
        View fragment = findViewById(R.id.frgStatic);
        //Remove last fragment still in stack
        fragmentManager.popBackStack();
        if(fragmentManager.getBackStackEntryCount() == 0){
            fragment.setVisibility(View.GONE);
        }
    }
}
