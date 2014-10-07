package it.sprik.animationsmaterialdesign;

import android.app.Activity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;


public class TransitionActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*if(getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS))
            getWindow().setEnterTransition(new Fade());
        else
            Toast.makeText(this, "No transition enables", Toast.LENGTH_LONG).show();*/


        // Obbligatorio altrimenti non esegue le transizioni anche da Activity precedenti
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        setContentView(R.layout.activity_transition);


    }


}
