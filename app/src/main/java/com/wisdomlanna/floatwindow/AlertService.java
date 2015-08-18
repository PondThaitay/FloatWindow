package com.wisdomlanna.floatwindow;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import wei.mark.standout.StandOutWindow;
import wei.mark.standout.ui.Window;

/**
 * Created by Bank on 18/8/2558.
 */
public class AlertService extends StandOutWindow {
	int Windowid;

	@Override
	public String getAppName() {
		return "Test";
	}

	@Override
	public int getAppIcon() {
		return R.mipmap.ic_launcher;
	}

	@Override
	public void createAndAttachView(int id, FrameLayout frame) {
		this.Windowid = id;
		LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
		View v = inflater.inflate(R.layout.noti, frame, true);
		v.findViewById(R.id.exit2).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				close(Windowid);
			}
		});
		v.findViewById(R.id.exit1).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(AlertService.this, "toast", Toast.LENGTH_SHORT).show();
			}
		});
	}

	@Override
	public StandOutLayoutParams getParams(int id, Window window) {
		return new StandOutLayoutParams(id, 250, 300,
				StandOutLayoutParams.CENTER, StandOutLayoutParams.CENTER);
	}

	@Override
	public String getPersistentNotificationMessage(int id) {
		return "NOTI MESSAGE";
	}

	//	@Override
//	public int getFlags(int id) {
//		return super.getFlags(id) | StandOutFlags.FLAG_BODY_MOVE_ENABLE
//				| StandOutFlags.FLAG_WINDOW_FOCUSABLE_DISABLE;
//	}
}
