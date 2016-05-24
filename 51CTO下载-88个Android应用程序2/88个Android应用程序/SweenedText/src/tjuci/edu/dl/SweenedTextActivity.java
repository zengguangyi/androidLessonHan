package tjuci.edu.dl;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SweenedTextActivity extends Activity {
	Animation anim ;
	ImageView imageView;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        anim = AnimationUtils.loadAnimation(this, R.anim.myanim);
        imageView = (ImageView)findViewById(R.id.iv);
        imageView.startAnimation(anim);
    }
}