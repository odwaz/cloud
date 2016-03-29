package com.example.shoppingcart;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class shop_activity extends Activity {

	Button button;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shop_list);
	}

}