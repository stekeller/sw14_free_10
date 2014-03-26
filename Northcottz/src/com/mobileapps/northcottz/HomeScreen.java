package com.mobileapps.northcottz;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

public class HomeScreen extends Activity implements OnClickListener{
	
	private Button buttonSinglePlayer;
	private Button buttonTwoPlayer;
	private Button buttonTutorial;
	
	private TextView textView;
	
	private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        
        buttonSinglePlayer = (Button) this.findViewById(R.id.buttonSinglePlayer);
        buttonTwoPlayer = (Button) this.findViewById(R.id.buttonTwoPlayer);
        buttonTutorial = (Button) this.findViewById(R.id.buttonTutorial);
        textView = (TextView) this.findViewById(R.id.textView1);
        
        buttonSinglePlayer.setOnClickListener(this);
        buttonTwoPlayer.setOnClickListener(this);
        buttonTutorial.setOnClickListener(this);
        
        //test
        counter = 0;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_screen, menu);
        return true;
    }


	@Override
	public void onClick(View v) {
		
		//Button clicked = (Button) v;
		
		if ( counter % 2 == 0 )
			textView.setText("Hui Buh");
		else
			textView.setText("Muh Kuh");
		
		counter += 1;
		
		
	}
    
    
    
}
