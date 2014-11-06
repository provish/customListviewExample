package com.example.customlistview;

import java.util.ArrayList;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

public class CustomListViewAndroidExample extends Activity{
	
	ListView list;
	CustomAdapter adapter;
	public CustomListViewAndroidExample CustomListView = null;
	public ArrayList<ListModel> CustomListViewValuesArr = new ArrayList<ListModel>();
	
	

	

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_listview);
		
		CustomListView = this;
		
		setListData();
		
		Resources res = getResources();
		
		list= (ListView) findViewById(R.id.listView1);
		
		adapter = new CustomAdapter (CustomListView, CustomListViewValuesArr,  res);
		
		list.setAdapter(adapter);
		
		
	}





	private void setListData()
	
	{
		for(int i=0; i<11;i++)
		{
			final ListModel sched = new ListModel();
			
			/*** Add data to the model object****/
			
			sched.setName("Company" +i);
			sched.setImage("Image"+i);
			
			/**** Add object to the arrayList ******/
			
			CustomListViewValuesArr.add( sched );
		}
		
	}





	public void onItemClick(int mPosition) 
	{
		ListModel tempValues = ( ListModel ) CustomListViewValuesArr.get(mPosition);
		   
        Toast.makeText(CustomListView,""+tempValues.getName()+"Image:"+tempValues.getImage(),Toast.LENGTH_LONG).show();
	}

}
