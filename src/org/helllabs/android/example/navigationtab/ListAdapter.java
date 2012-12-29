package org.helllabs.android.example.navigationtab;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class ListAdapter extends ArrayAdapter<ListItem> {
	private Context context;
	private int textViewResourceId;
	private ListItem[] objects;

	public ListAdapter(Context context, int textViewResourceId, ListItem[] objects) {
		super(context, textViewResourceId, objects);
		this.context = context;
		this.textViewResourceId = textViewResourceId;
		this.objects = objects;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = ((Activity) context).getLayoutInflater();
		View view = inflater.inflate(textViewResourceId, parent, false);

		ListItem item = objects[position];

		TextView nameText = (TextView) view.findViewById(R.id.name);
		nameText.setText(item.getName());

		TextView descriptionText = (TextView) view.findViewById(R.id.description);
		descriptionText.setText(item.getDescription());

		return view;
	}
}
