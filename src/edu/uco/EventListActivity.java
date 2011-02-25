package edu.uco;

import java.util.ArrayList;
import java.util.Calendar;

import android.app.Dialog;
import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.TextView;
 
public class EventListActivity extends ListActivity {
	EventListAdapter mAdapter; 
	
	static final int DIALOG_PAUSED_ID = 0;
	private int currentListItem;
	private Event e;
	
	private OnItemClickListener aClick = new OnItemClickListener(){
       
		
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			e = (Event) mAdapter.getItem(arg2);
			currentListItem = arg2;
			showDialog(DIALOG_PAUSED_ID);
		}	
	};

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_main);
        
        getListView().setEmptyView(findViewById (R.id.empty));
        getListView().setOnItemClickListener(aClick);
        
        mAdapter = new EventListAdapter (this);
        setListAdapter(mAdapter);
    }
    
    protected Dialog onCreateDialog(int id) {    
    	final Dialog dialog;
    	//Event e = (Event) mAdapter.getItem(currentListItem);
    	switch(id){
    	case DIALOG_PAUSED_ID:
    		dialog = new Dialog(this);

        	dialog.setContentView(R.layout.custom_dialoge);
        	dialog.setTitle("Info");

            final Calendar c = e.getDate();      
            int mYear = c.get(Calendar.YEAR);      
            int mMonth = c.get(Calendar.MONTH);       
            int mDay = c.get(Calendar.DAY_OF_MONTH);
            int mHour = c.get(Calendar.HOUR_OF_DAY);
            int mMinute = c.get(Calendar.MINUTE);
            String minuteString = Integer.toString(mMinute);
            if (minuteString.length()== 1)
           	 minuteString = "0" + minuteString;
            String s = mMonth + "/" + mDay + "/" + mYear + " " + mHour + ":" + minuteString;
        	
        	TextView text0 = (TextView) dialog.findViewById(R.id.date);
        	text0.setText(s);
        	
        	TextView text1 = (TextView) dialog.findViewById(R.id.location);
        	text1.setText(e.getLocation());
        	
        	TextView text2 = (TextView) dialog.findViewById(R.id.cost);
        	text2.setText(Double.toString(e.getCost()));
        	
        	TextView text3 = (TextView) dialog.findViewById(R.id.sponsor);
        	text3.setText(e.getSponsor());
        	
        	TextView text4 = (TextView) dialog.findViewById(R.id.eventdescription);
        	text4.setText(e.getEventdescription());
        	      	 
        	final Button addImageCancelButton = (Button) dialog.findViewById(R.id.ImageCancelButton);
 	        addImageCancelButton.setOnClickListener(new View.OnClickListener() {
 	            public void onClick(View v) {
 	                dialog.cancel();
 	            }
 	        });
 	        return dialog;
 	          	
        	
    	default:
    		dialog = null;
    		return dialog;
    	}	
    }
    
    @Override
    protected void onPrepareDialog(final int id, final Dialog dialog)  {
    	switch(id){
    	case DIALOG_PAUSED_ID:
 

        	dialog.setContentView(R.layout.custom_dialoge);
        	dialog.setTitle("Info");

            final Calendar c = e.getDate();      
            int mYear = c.get(Calendar.YEAR);      
            int mMonth = c.get(Calendar.MONTH);       
            int mDay = c.get(Calendar.DAY_OF_MONTH);
            int mHour = c.get(Calendar.HOUR_OF_DAY);
            int mMinute = c.get(Calendar.MINUTE);
            String minuteString = Integer.toString(mMinute);
            if (minuteString.length()== 1)
           	 minuteString = "0" + minuteString;
            String s = mMonth + "/" + mDay + "/" + mYear + " " + mHour + ":" + minuteString;
        	
        	TextView text0 = (TextView) dialog.findViewById(R.id.date);
        	text0.setText(s);
        	
        	TextView text1 = (TextView) dialog.findViewById(R.id.location);
        	text1.setText(e.getLocation());
        	
        	TextView text2 = (TextView) dialog.findViewById(R.id.cost);
        	text2.setText(Double.toString(e.getCost()));
        	
        	TextView text3 = (TextView) dialog.findViewById(R.id.sponsor);
        	text3.setText(e.getSponsor());
        	
        	TextView text4 = (TextView) dialog.findViewById(R.id.eventdescription);
        	text4.setText(e.getEventdescription());
        	      	 
        	final Button addImageCancelButton = (Button) dialog.findViewById(R.id.ImageCancelButton);
 	        addImageCancelButton.setOnClickListener(new View.OnClickListener() {
 	            public void onClick(View v) {
 	                dialog.cancel();
 	            }
 	        });
 	        break;
    	}    	
    }
  
    	
    }
    		
