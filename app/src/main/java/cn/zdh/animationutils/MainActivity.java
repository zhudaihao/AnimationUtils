package cn.zdh.animationutils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import static android.view.animation.AnimationUtils.loadAnimation;


/**
 * 补间动画
 * <p>
 * 注意几个动画连续的（就是anim里面的文件是set包裹几个动画，直接转换为Animation 例如：Animation animation = AnimationUtils.loadAnimation）
 */

public class MainActivity extends AppCompatActivity {
    private Button bt;
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt = (Button) findViewById(R.id.bt);
        iv = (ImageView) findViewById(R.id.iv);
    }

    /**
     * 平移动画
     */
    public void anim1(View v) {
        //XML+Java代码
        TranslateAnimation translateAnimation = (TranslateAnimation) loadAnimation(this, R.anim.anim_translate);
        bt.startAnimation(translateAnimation);

        //Java代码
        //setJava();
    }

    private void setJava() {
        TranslateAnimation translateAnimation1 = new TranslateAnimation(TranslateAnimation.ABSOLUTE, -bt.getWidth(), TranslateAnimation.ABSOLUTE, bt.getWidth() * 2f, TranslateAnimation.RELATIVE_TO_SELF, 0f, TranslateAnimation.RELATIVE_TO_SELF, 0);
        //设置动画持续时长
        translateAnimation1.setDuration(1000);
        //设置动画结束之后的状态是否是动画的最终状态，true，表示是保持动画结束时的最终状态
        translateAnimation1.setFillAfter(false);
        //设置动画结束之后的状态是否是动画开始时的状态，true，表示是保持动画开始时的状态
        translateAnimation1.setFillBefore(true);
        //设置动画的重复模式：反转REVERSE和重新开始RESTART
        translateAnimation1.setRepeatMode(ScaleAnimation.REVERSE);
        //设置动画播放次数
        translateAnimation1.setRepeatCount(1);
        //开始动画
        bt.startAnimation(translateAnimation1);
    }


    /**
     * 缩放动画
     */
    public void anim2(View v) {
        ScaleAnimation scaleAnimation = (ScaleAnimation) loadAnimation(this, R.anim.anim_scale);
        iv.startAnimation(scaleAnimation);


    }

    /**
     * 旋转动画
     */
    public void anim3(View v) {
        RotateAnimation rotateAnimation = (RotateAnimation) AnimationUtils.loadAnimation(this, R.anim.anim_rotate);
        iv.startAnimation(rotateAnimation);
    }

    /**
     * 透明度动画
     */
    public void anim4(View v) {
        AlphaAnimation alphaAnimation = (AlphaAnimation) loadAnimation(this, R.anim.anim_alphe);
        iv.startAnimation(alphaAnimation);

    }


    /**
     * 组合动画
     * 注意几个动画连续的（就是anim里面的文件是set包裹几个动画，直接转换为Animation 例如：Animation animation = AnimationUtils.loadAnimation）
     */
    public void anim5(View v) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.set_anim);
        iv.startAnimation(animation);

    }
}
