package com.mobileapps.northcottz;

import com.mobileapps.northcottz.views.BoardGraphic;

import android.support.v4.app.Fragment;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.os.Build;

public class PlayScreenActivity extends Activity {
	GridView gridView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new BoardGraphic(this));
//		setContentView(R.layout.activity_play_screen);
		
		
//		gridView = (GridView) findViewById(R.id.gridview); 
//		gridView.setAdapter(new ImageAdapter(this));
//		gridView.setOnItemClickListener(
//				new OnItemClickListener() {
//					public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
//			            Toast.makeText(getApplicationContext(), "" + position, Toast.LENGTH_SHORT).show();
//			        }
//		   		}
//		   );
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.play_screen, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_play_screen,
					container, false);
			return rootView;
		}
	}
	
	public class ImageAdapter extends BaseAdapter{
		private Context mContext;
		
		public ImageAdapter(Context c) {
			mContext = c;
		}

		@Override
		public int getCount() {
			return 1;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView imageView;
	        if (convertView == null) {  // if it's not recycled, initialize some attributes
	            imageView = new ImageView(mContext);
	            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
	            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
	            imageView.setPadding(8, 8, 8, 8);
	        } else {
	            imageView = (ImageView) convertView;
	        }

	        imageView.setImageResource(mThumbIds[position]);
	        return imageView;
		}
		// references to our images
	    private Integer[] mThumbIds = {
	            R.drawable.sample_0, R.drawable.sample_1,
	            R.drawable.sample_2, R.drawable.sample_3
	    };
		
	}

}
