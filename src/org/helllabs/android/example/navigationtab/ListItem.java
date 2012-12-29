package org.helllabs.android.example.navigationtab;

import android.os.Parcel;
import android.os.Parcelable;


public class ListItem implements Parcelable, Comparable<ListItem> {

	private String name;
	private String description;

	public ListItem(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public ListItem(Parcel in) {
		name = in.readString();
		description = in.readString();
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
	

	// Parcelable methods

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel out, int flags) {
		out.writeString(name);
		out.writeString(description);
	}

	public static final Creator<ListItem> CREATOR = new Parcelable.Creator<ListItem>() {
		public ListItem createFromParcel(Parcel in) {
			return new ListItem(in);
		}

		public ListItem[] newArray(int size) {
			return new ListItem[size];
		}
	};

	// Comparable methods

	@Override
	public int compareTo(ListItem item) {
		return this.name.compareTo(item.name);
	}
}
