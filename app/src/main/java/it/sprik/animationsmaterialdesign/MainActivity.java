package it.sprik.animationsmaterialdesign;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


public class MainActivity extends Activity {

    private Handler mHandler;
    ImageButton imgFAB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS))
            getWindow().setExitTransition(new Fade());
        else
            Toast.makeText(this, "No transition enables", Toast.LENGTH_LONG).show();

        setContentView(R.layout.activity_main);

        mHandler = new Handler();

        imgFAB = (ImageButton) findViewById(R.id.fab);

        //Outline
        int size = getResources().getDimensionPixelSize(R.dimen.fab_size);
        Outline outline = new Outline();
        outline.setOval(0, 0, size, size);
        imgFAB.setOutline(outline);
        imgFAB.setClipToOutline(true);

    }

    public void firstOnClick(View view) {
        final Button btnfirst = (Button) view;
        btnfirst.setText(R.string.touch_feed);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                btnfirst.setText(R.string.first_anim);
            }
        }, 1000);
    }

    public void secondOnClick(View view) {
        startActivity(new Intent(this, TransitionActivity.class));
    }

    public void thirdOnClick(View view) {
        startActivity(new Intent(this, RevealActivity.class));
    }
}
