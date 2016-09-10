package com.fc.newsupdate.ui.adapter;

import com.fc.newsupdate.R;
import com.fc.newsupdate.model.enity.SubType;
import com.fc.newsupdate.ui.base.MyBaseAdapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class NewsTypeAdapter extends MyBaseAdapter<SubType>{

	private int selectedPosition;
	
	public NewsTypeAdapter(Context context) {
		super(context);
	}

	@Override
	public View getMyView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder = null;
		
		if(convertView == null) {
			convertView = inflater.inflate(R.layout.item_list_newstype, null);
			viewHolder = new ViewHolder(convertView);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		String group = myList.get(position).getSubgroup();
		viewHolder.tv_newstype_type.setText(group);
		if(selectedPosition == position) {
			viewHolder.tv_newstype_type.setTextColor(Color.RED);
		} else {
			viewHolder.tv_newstype_type.setTextColor(Color.BLACK);
		}
		return convertView;
	}
	
	public void setSelectedPosition(int position) {
		this.selectedPosition = position;
	}
	
	public class ViewHolder {
		TextView tv_newstype_type;
		
		public ViewHolder(View view) {
			tv_newstype_type = (TextView) view.findViewById(R.id.tv_newstype_type);
		}
	}
}
