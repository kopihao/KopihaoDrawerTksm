package com.view.plugin.tksm;

/**
 * Enhancement to easy configuration of TKSlideMenu
 * @author Jasper
 */
import android.view.animation.Interpolator;

public class TKSlideMenuConfig {
	private Interpolator interpolator = TKSlideMenu.DEFAULT_INTERPOLATOR;
	private boolean lockLeft = false;
	private boolean lockRight = false;
	private boolean slideContent = true;
	private int slideSensitivity = 0;
	private int shadowLeft = 8;
	private int shadowRight = 8;

	public Interpolator getInterpolator() {
		return interpolator;
	}

	public boolean isLockLeft() {
		return lockLeft;
	}

	public boolean isLockRight() {
		return lockRight;
	}

	public boolean isSlideContent() {
		return slideContent;
	}

	public int getSlideSensitivity() {
		return slideSensitivity;
	}

	public int getShadowLeft() {
		return shadowLeft;
	}

	public int getShadowRight() {
		return shadowRight;
	}

	public TKSlideMenuConfig setInterpolator(Interpolator interpolator) {
		this.interpolator = interpolator;
		return this;
	}

	public TKSlideMenuConfig setLockLeft(boolean lockLeft) {
		this.lockLeft = lockLeft;
		return this;

	}

	public TKSlideMenuConfig setLockRight(boolean lockRight) {
		this.lockRight = lockRight;
		return this;

	}

	public TKSlideMenuConfig setSlideContent(boolean slideContent) {
		this.slideContent = slideContent;
		return this;

	}

	public TKSlideMenuConfig setSlideSensitivity(int slideSensitivity) {
		this.slideSensitivity = slideSensitivity;
		return this;

	}

	public TKSlideMenuConfig setShadowLeft(int shadowLeft) {
		this.shadowLeft = shadowLeft;
		return this;

	}

	public TKSlideMenuConfig setShadowRight(int shadowRight) {
		this.shadowRight = shadowRight;
		return this;
	}

}
