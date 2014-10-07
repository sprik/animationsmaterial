package it.sprik.animationsmaterialdesign;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;


public class RevealActivity extends Activity {

    TextView txtreveal;
    ImageView imgreveal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reveal);

        txtreveal = (TextView) findViewById(R.id.txtreveal);
        imgreveal = (ImageView) findViewById(R.id.imgreveal);
    }

    private void revealView(final View view) {
        if(view.getVisibility() == View.INVISIBLE) {
            // previously invisible view
            //View myView = findViewById(R.id.my_view);
            view.setVisibility(View.VISIBLE);

            // get the center for the clipping circle
            int cx = (view.getLeft() + view.getRight()) / 2;
            int cy = (view.getTop() + view.getBottom()) / 2;

            // get the final radius for the clipping circle
            int finalRadius = view.getWidth();

            // create and start the animator for this view
            // (the start radius is zero)
            ValueAnimator anim = ViewAnimationUtils.createCircularReveal(view, cx, cy, 0, finalRadius);
            anim.start();
        } else {
            // previously visible view
            //final View myView = findViewById(R.id.my_view);

            // get the center for the clipping circle
            int cx = (view.getLeft() + view.getRight()) / 2;
            int cy = (view.getTop() + view.getBottom()) / 2;

            // get the initial radius for the clipping circle
            int initialRadius = view.getWidth();

            // create the animation (the final radius is zero)
            ValueAnimator anim = ViewAnimationUtils.createCircularReveal(view, cx, cy, initialRadius, 0);

            // make the view invisible when the animation is done
            anim.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    view.setVisibility(View.INVISIBLE);
                }
            });

            // start the animation
            anim.start();
        }
    }

    public void revealOnClick(View view) {
        revealView(txtreveal);
        revealView(imgreveal);
    }
}
