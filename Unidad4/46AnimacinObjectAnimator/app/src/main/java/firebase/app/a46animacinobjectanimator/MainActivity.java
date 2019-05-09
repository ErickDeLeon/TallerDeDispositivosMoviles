package firebase.app.a46animacinobjectanimator;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private RelativeLayout canvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.faceIcon);
        canvas = findViewById(R.id.animationCanvas);
    }

    public void onButtonClick(View v) {

//        int screenHeight = canvas.getHeight();
//        int targetY = screenHeight - imageView.getHeight();

        ObjectAnimator animator = ObjectAnimator.ofFloat(
                imageView, "y", (canvas.getHeight()-500), 80)
                .setDuration(4000);
        animator.setInterpolator(new CycleInterpolator(2));
        animator.start();
    }

    public void onButton1Click(View v){
        ObjectAnimator animator = ObjectAnimator.ofFloat(
                imageView, "y", (canvas.getHeight()-150), 1)
                .setDuration(4000);
        animator.setInterpolator(new BounceInterpolator());
        animator.start();
    }

    public void onButton2Click(View v){
        ObjectAnimator animator = ObjectAnimator.ofFloat(
                imageView, "y", (canvas.getHeight()-150), 1)
                .setDuration(4000);
        animator.setInterpolator(new OvershootInterpolator());
        animator.start();
    }
}
