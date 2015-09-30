package com.kopihao.drawer.tksm;

import com.view.plugin.tksm.TKSlideMenu;
import com.view.plugin.tksm.TKSlideMenuConfig;
import com.view.plugin.tksm.TKSlideMenuManager;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public abstract class Activity_Base extends FragmentActivity {

	Activity_Base curAct;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		curAct = this;
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onBackPressed() {
		return;
	}

	// ----------------------------------------
	// Custom Proj UI
	// ----------------------------------------
	private TKSlideMenuManager mgrTKSM;

	@Override
	public void setContentView(View v) {
		if (v == null) {
			setContentView(0);
			return;
		}
	}

	@Override
	public void setContentView(int pLayid) {
		super.setContentView(R.layout.lay_slidemenu_tangke);
		mgrTKSM = new TKSlideMenuManager(this, (TKSlideMenu) findViewById(R.id.tksm));
		mgrTKSM.setUI(R.layout.lay_app_template);
		mgrTKSM.setUI(R.layout.lay_app_lsm);
		mgrTKSM.setUI(R.layout.lay_app_rsm);

		// mgrTKSM.setUI(R.layout.lay_app_template, R.layout.lay_app_lsm,
		// R.layout.lay_app_rsm);

		mgrTKSM.configure(new TKSlideMenuConfig());

		if (pLayid != 0) {
			View vAppContent = findViewById(R.id.vAppContent);
			if (vAppContent == null) {
				final String MSG_INCOMPATIBLE = "<Layout Incompact>\n"
						+ "Not compatible to app template, anomalies expected";
				popShortToast(MSG_INCOMPATIBLE);
				return;
			}
			inflateUI(vAppContent, pLayid);
		}
		mgrTKSM.close();

	}

	// ----------------------------------------
	// Handle UI
	// ----------------------------------------

	public void inflateUI(View root, int layid) {
		getLayoutInflater().inflate(layid, (ViewGroup) root, true);
	}

	public void inflateUI(ViewGroup root, int layid) {
		getLayoutInflater().inflate(layid, root, true);
	}

	public void popShortToast(String message) {
		Toast.makeText(this, "" + message, Toast.LENGTH_SHORT).show();
	}

	public void popLongToast(String message) {
		Toast.makeText(this, "" + message, Toast.LENGTH_LONG).show();
	}
	// ----------------------------------------
	// I'm Awesome End
	// ----------------------------------------
}
