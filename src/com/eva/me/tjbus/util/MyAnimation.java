package com.eva.me.tjbus.util;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;

public class MyAnimation {
	public static final long circleTime = 4000L;

	public static Animation getBusIconAnimation() {
		TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0f, 210.0f, 0.0f, 0.0f);
		localTranslateAnimation.setDuration(circleTime);
		localTranslateAnimation.setRepeatCount(-1);
		return localTranslateAnimation;
	}

	public static Animation getProgressBarAnimation(Context paramContext) {
		return AnimationUtils.loadAnimation(paramContext,com.eva.me.tjbus.R.anim.progress_change);
	}

	public static Animation getTicketBusIconAnimation() {
		TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0f, 160.0f, 0.0f, 0.0f);
		localTranslateAnimation.setDuration(circleTime);
		localTranslateAnimation.setRepeatCount(-1);
		return localTranslateAnimation;
	}
}