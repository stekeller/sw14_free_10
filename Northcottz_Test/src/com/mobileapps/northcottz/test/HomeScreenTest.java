package com.mobileapps.northcottz.test;

import com.mobileapps.northcottz.HomeScreen;
import com.mobileapps.northcottz.R;
import com.robotium.solo.Solo;

import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;

public class HomeScreenTest extends ActivityInstrumentationTestCase2<HomeScreen> {

	private Solo mySolo;
	
	public HomeScreenTest() {
		super(HomeScreen.class);
	}

	protected void setUp() throws Exception {
		Log.i("TEST", "SetUp");
		
		super.setUp();
				
		mySolo = new Solo(getInstrumentation(), getActivity());
		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	
	
	public void testButtons(){
//		mySolo.clickOnView(mySolo.getView());
		mySolo.clickOnView(mySolo.getView(R.id.buttonTwoPlayer));
		mySolo.clickOnView(mySolo.getView(R.id.buttonTwoPlayer));
		mySolo.clickOnView(mySolo.getView(R.id.buttonTwoPlayer));
		mySolo.clickOnView(mySolo.getView(R.id.buttonTwoPlayer));
		mySolo.clickOnView(mySolo.getView(R.id.buttonTwoPlayer));
		mySolo.clickOnView(mySolo.getView(R.id.buttonTwoPlayer));
//		mySolo.clickOnButton("buttonTwoPlayer");
//		mySolo.clickOnButton("buttonTwoPlayer");
//		mySolo.clickOnButton("buttonTwoPlayer");
//		mySolo.clickOnButton("buttonTwoPlayer");
		Log.d("hjkhgku", "jmkldsjQ");
	}
	
	public void testCheckBox(){
	}
	

}
