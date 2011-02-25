package edu.uco;

import java.util.ArrayList;
import java.util.Calendar;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class EventListAdapter extends BaseAdapter {
    private ArrayList<Event> events = new ArrayList<Event>();
    private Context mContext;
    
    
    
    public EventListAdapter (Context c) {
    	mContext = c;
    	events = getEvents();
    }
    
    public ArrayList<Event> getEvents(){
    	ArrayList<Event> events = new ArrayList<Event>();
    	Calendar c1 = Calendar.getInstance();
    	Calendar c2 = Calendar.getInstance();
    	Calendar c3 = Calendar.getInstance();
    	Calendar c4 = Calendar.getInstance();
    	Event e1 = new Event();
    	e1.setEventtitle("Brain Camp");
    	c1.set(2010, 7, 28, 9, 00);
    	e1.setDate(c1);
    	e1.setLocation("Howell Hall");
    	e1.setCost(0.00);
    	e1.setEventdescription("8 research projects, new friends, lounge time, 2 hour lunch, and VOLLEYBALL");
    	e1.setSponsor("STEP");
    	Event e2 = new Event();
      	e2.setEventtitle("Toga Party");
      	c2.set(2010, 8, 23, 11, 00);
    	e2.setDate(c2);
    	e2.setLocation("Murgaugh Hall Lounge");
    	e2.setCost(3.00);
    	e2.setEventdescription("Party, Invitation ONLY");
    	e2.setSponsor("Greek Life");
    	Event e3 = new Event ();
    	e3.setEventtitle("Underwater Basket Weaving");
    	c3.set(2010,8, 2, 5, 00);
    	e3.setDate(c3);
    	e3.setLocation("Edmond YMCA");
    	e3.setCost(5.00);
    	e3.setEventdescription("Basket weaving underwater");
    	e3.setSponsor("B.W.C. Basket Weaving Club");
    	Event e4 = new Event ();
    	e4.setEventtitle("Football Game");
    	c4.set(2010,8, 27, 7, 00);
    	e4.setDate(c4);
    	e4.setLocation("UCO Football Stadium");
    	e4.setCost(28.00);
    	e4.setEventdescription("Rivalry, Biggest game of the season");
    	e4.setSponsor("UCO Athletics");
        events.add(e1);
        events.add(e2);
        events.add(e3);
        events.add(e4);
    	
    	return events;
    	
    }
    


	public int getCount() {
		// TODO Auto-generated method stub
		return events.size();
	}

	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return events.get(position);
	}

	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	 public View getView(int position, View convertView, ViewGroup parent) {

     	final View v = ((Activity)mContext).getLayoutInflater ().inflate(R.layout.row, null);

             Event e = events.get(position);
             if (e != null) {
                     TextView tt = (TextView) v.findViewById(R.id.toptext);
                     TextView mt = (TextView) v.findViewById(R.id.middletext);
                     TextView bt = (TextView) v.findViewById(R.id.bottomtext);
                    
                     ImageView iv = (ImageView) v.findViewById (R.id.icon);
                     String icon1 = e.getEventtitle ();
                     if (icon1.equals("Brain Camp"))
                    	 iv.setImageResource(R.drawable.braincamp);
                     else if(icon1.equals("Toga Party"))
                    	 iv.setImageResource(R.drawable.toga);
                     else if (icon1.equals("Underwater Basket Weaving"))
                    	 iv.setImageResource(R.drawable.ubw);
                     else if (icon1.equals("Football Game"))
                    	 iv.setImageResource(R.drawable.football);
                     else
                    	 iv.setImageResource(R.drawable.icon);
                     
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
                     if (tt != null) {
                           tt.setText("Name: "+e.getEventtitle());                            }
                     if(bt != null){
                           bt.setText("Time:" + s);              
                     }
                     if (mt != null) {
                     	mt.setText("Location: " + e.getLocation());
                     }
             }
             return v;
     }
}
