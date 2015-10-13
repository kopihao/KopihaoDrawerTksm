package com.view.plugin.tksm;

import android.app.Activity;

public class TKSlideMenuManager {

	private TKSlideMenu curSM;
	private Activity curAct;

	public TKSlideMenuManager(Activity pAct, TKSlideMenu pSM) {
		curSM = pSM;
		curAct = pAct;
	}

	public void configure(TKSlideMenuConfig pConfig) {
		if (null == curSM) {
			return;
		}
		curSM.configure(new TKSlideMenuConfig());
	}

	public void setUI(int pLayid) {
		if (null == curSM) {
			return;
		}
		curAct.getLayoutInflater().inflate(pLayid, curSM, true);
	}

	public void setUI(int pContent, int pLeft, int pRight) {
		if (null == curSM) {
			return;
		}
		curAct.getLayoutInflater().inflate(pContent, curSM, true);
		curAct.getLayoutInflater().inflate(pLeft, curSM, true);
		curAct.getLayoutInflater().inflate(pRight, curSM, true);
	}

	public void openRight() {
		if (null == curSM) {
			return;
		}
		curSM.open(true, true);
	}

	public void openLeft() {
		if (null == curSM) {
			return;
		}
		curSM.open(false, true);
	}

	public void openMain() {
		if (null == curSM) {
			return;
		}
		curSM.close(true);
	}

}
