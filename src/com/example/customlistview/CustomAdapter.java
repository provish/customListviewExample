package com.example.customlistview;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter implements OnClickListener{

	 @Override
	public void onClick(DialogInterface dialog, int which) {
		// TODO Auto-generated method stub
		
	}


	private Activity activity;
     private ArrayList data;
     private static LayoutInflater inflater=null;
     public Resources res;
     ListModel tempValues=null;
     int i=0;
     
     /******* CustomAdapter Constructor **********/
     
     public CustomAdapter(Activity a, ArrayList d, Resources resLocal)
     {
    	 /****** Take Passed Value *******/
    	 
    	 activity = a;
    	 data=d;
    	 res=resLocal;
    	 
    	 /******** Layout Inflator *********/
    	 
    	 inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    	 
     }
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		if(data.size()<=0)
			return 1;
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	
	public static class ViewHolder
	{
		public TextView text;
		public ImageView image;
		
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View vi = convertView;
		ViewHolder holder;
		
		if(convertView == null)
		{
			vi = inflater.inflate(R.layout.single_row_looks,null);
			
			holder = new ViewHolder();
			holder.text = (TextView) vi.findViewById(R.id.textView1);
			holder.image = (ImageView) vi.findViewById(R.id.imageView1);
			
			vi.setTag(holder);
			
		}
		else
			holder = (ViewHolder)vi.getTag();
		
		if(data.size()<=0)
		{
			holder.text.setText("No data");
		}
		else 
		{
			
			tempValues = null;
			tempValues = (ListModel) data.get(position);
			
			 holder.text.setText( tempValues.getName() );
             holder.image.setImageResource(res.getIdentifier("com.example.customlistview:drawable/"+tempValues.getImage(),null, null));
             
             vi.setOnClickListener(new OnItemClickListener(position));
		}
		
		return vi;
	}
	
	
	private class OnItemClickListener implements android.view.View.OnClickListener 
	{
		private int mPosition;
		
		public OnItemClickListener(int position) 
		{
			// TODO Auto-generated constructor stub
			mPosition = position;
		}

		@Override
		public void onClick(View agr0) 
		{
			
			 CustomListViewAndroidExample sct = (CustomListViewAndroidExample)activity;
			 
             /****  Call  onItemClick Method inside CustomListViewAndroidExample Class ( See Below )****/

                sct.onItemClick(mPosition);
			
		}

		

	
		
	}

	
	
	

}
