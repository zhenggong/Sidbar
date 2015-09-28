package com.example.sidbar;

import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends FragmentActivity {
	
	private DrawerLayout mDrawerLayout;
	private PeopleListFragment mPeopleListFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);		
		setupSideNavigationDrawer();
		
		//ホテルリスト表示/////
		mPeopleListFragment = PeopleListFragment.newInstance();
		mPeopleListFragment.setCallback(new PeopleListFragment.Callback() {
		      @Override
		      public void onShowComplete() {
		      }
		    });;
		    final android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		    transaction.replace(R.id.content_frame, mPeopleListFragment);
		    transaction.show(mPeopleListFragment);
		    try {
		        transaction.commit();
		      } catch (Exception e) {
		        Log.e("FragmentTransaction", e.getLocalizedMessage());
		      }

	}

	private void setupSideNavigationDrawer() {
		// TODO Auto-generated method stub
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
}
