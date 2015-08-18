package com.wisdomlanna.floatwindow;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void showDialog(View v) {
//		StandOutWindow.show(this,AlertService.class,10);
		startService(new Intent(this, Alert2Service.class));
	}
}
