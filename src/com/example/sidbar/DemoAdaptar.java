package com.example.sidbar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DemoAdaptar extends ArrayAdapter<People>{
	
	private Context mContext;
	private LayoutInflater mLayoutInflater;
	private final List<People> peoples = new ArrayList<People>();

	public DemoAdaptar(Context context, int textViewResourceId, List<People> objects) {
		super(context, textViewResourceId, objects);
		// TODO Auto-generated constructor stub
		mContext = context;
		mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	public View getView(int position, View convertView, ViewGroup parent){
		
		People people = (People) getItem(position);
		ViewHolder holder;
		if (convertView == null){
			holder = new ViewHolder();
			convertView = mLayoutInflater.inflate(R.layout.item, null);
			holder.hotelImage = (ImageView) convertView.findViewById(R.id.avatar);
			holder.hotelName = (TextView) convertView.findViewById(R.id.name);
			holder.hotelId = (TextView) convertView.findViewById(R.id.id);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		holder.hotelName.setText(people.getName());
		holder.hotelId.setText(people.getId());

		try{
		  Picasso.with(mContext).load(people.getAvatar()).resize(100, 100)
          .into(holder.hotelImage);
		}catch (Exception e){
			Log.d("PARSE", e.toString());
		}
		return convertView;	
	}
	
	static class ViewHolder
	  {
	    ImageView   hotelImage;
	    TextView    hotelId;
	    TextView    hotelName;
	  }
	
	
	

}
