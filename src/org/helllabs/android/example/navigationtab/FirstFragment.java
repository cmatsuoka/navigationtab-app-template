package org.helllabs.android.example.navigationtab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockListFragment;


public class FirstFragment extends SherlockListFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, 
			Bundle savedInstanceState) {
		
		ListItem[] items = {
				new ListItem("First item", "This is the first item"),
				new ListItem("Second item", "This is the second item"),
				new ListItem("Third item", "This is the third item")
		};

		setListAdapter(new ListAdapter(getActivity(), R.layout.list_item, items));
		
		return inflater.inflate(R.layout.first_fragment, container, false);    	
	}
}
