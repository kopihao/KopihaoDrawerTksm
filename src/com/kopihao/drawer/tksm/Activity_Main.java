package com.kopihao.drawer.tksm;

import android.os.Bundle;

/**
 * This project demo drawer designed by Tang Ke <br>
 * And present a lazy(may not simpler, idk) way to use his library. <br>
 * Credit to
 * <a href="https://github.com/TangKe/SlideMenu"> https://github.com/TangKe/SlideMenu </a> <br>
 * <br>
 *
 * Left menu(hereinafter LSM) and Right menu(hereinafter RSM) <br>
 * is designed as view group type, FrameLayout. <br>
 *
 * You may customize lay_app_lsm, lay_app_rsm <br>
 * by <b> changing layout </b> (ListView, GridView, etc) <br>
 * OR <b>inflate custom layout/fragment </b> into it, <br>
 * according to your project requirement. <br>
 * <br>
 *
 * <p>
 * <u>Why TKSlideMenu?</u><br>
 * Competitive as jfeinstein10 SlidingMenu<br>
 * Left and right menu supported <br>
 * Left and right menu underlying below main content <br>
 * </p>
 *
 * @author Jasper
 *
 */
public class Activity_Main extends Activity_Base {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ac_main);
	}
}
