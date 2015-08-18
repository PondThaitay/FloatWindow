package com.wisdomlanna.floatwindow;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by Bank on 18/8/2558.
 */
public class Alert2Service extends Service {
	WindowManager windowManager;
	View v;

	@Nullable
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		v = LayoutInflater.from(this).inflate(R.layout.noti, null);
		windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
		WindowManager.LayoutParams params = params = new WindowManager.LayoutParams(
				WindowManager.LayoutParams.MATCH_PARENT,
				WindowManager.LayoutParams.MATCH_PARENT,
				WindowManager.LayoutParams.TYPE_PHONE,
				WindowManager.LayoutParams.FLAG_FULLSCREEN
				//WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
				,
				PixelFormat.TRANSLUCENT);
		windowManager.addView(v, params);
		v.findViewById(R.id.exit2).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				stopSelf();
			}
		});
		v.setAlpha(0);
		v.post(new Runnable() {
			@Override
			public void run() {
				ObjectAnimator.ofFloat(v, "alpha", 1f).setDuration(1000).start();
			}
		});
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		ObjectAnimator anim = ObjectAnimator.ofFloat(v, "alpha", 0f).setDuration(1000);
		anim.addListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationEnd(Animator animation) {
				super.onAnimationEnd(animation);
				windowManager.removeView(v);
			}
		});
		anim.start();

	}
}
