package org.helllabs.android.example.navigationtab;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;


public class MainActivity extends SherlockFragmentActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);

		// setup action bar for tabs
		ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		//actionBar.setDisplayShowTitleEnabled(false);

		Tab tab = actionBar.newTab().setText("Tab 1");
		tab.setTabListener(new TabListener<FirstFragment>(this, "tab1", FirstFragment.class));
		actionBar.addTab(tab);

		tab = actionBar.newTab().setText("Tab 2");
		tab.setTabListener(new TabListener<SecondFragment>(this, "tab2", SecondFragment.class));
		actionBar.addTab(tab);
	}

	// Menu

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getSupportMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}
	
	public static class TabListener<T extends Fragment> implements ActionBar.TabListener  {
		private Fragment fragment;
		private final Activity activity;
		private final String tag;
		private final Class<T> clz;

		public TabListener(Activity activity, String tag, Class<T> clz) {
			this.activity = activity;
			this.tag = tag;
			this.clz = clz;
		}

		@Override
		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			// Check if the fragment is already initialized
			if (fragment == null) {
				// If not, instantiate and add it to the activity
				fragment = Fragment.instantiate(activity, clz.getName());
				ft.add(android.R.id.content, fragment, tag);
			} else {
				// If it exists, simply attach it in order to show it
				ft.attach(fragment);
			}
		}

		@Override
		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			if (fragment != null) {
				// Detach the fragment, because another one is being attached
				ft.detach(fragment);
			}
		}

		@Override
		public void onTabReselected(Tab tab, FragmentTransaction ft) {
			// User selected the already selected tab. Usually do nothing.
		}
	}

}
