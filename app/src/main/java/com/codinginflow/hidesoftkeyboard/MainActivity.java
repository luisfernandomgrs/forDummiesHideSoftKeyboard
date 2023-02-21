package com.codinginflow.hidesoftkeyboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

	private TextView text_view_result;
	private EditText edit_text_input;
	private Button button_confirm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		text_view_result = findViewById(R.id.text_view_result);
		edit_text_input = findViewById(R.id.edit_text_input);
		button_confirm = findViewById(R.id.button_confirm);

		button_confirm.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				text_view_result.setText(edit_text_input.getText().toString().trim());
				edit_text_input.setText(null);
				closeKeyboard();
			}
		});
	}

	private void closeKeyboard() {
		View view = edit_text_input.getRootView();	//Force to get focus of Edit Text...
													// this.getCurrentFocus();
		if (view != null) {
			InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow( view.getWindowToken(), 0);
		}
	}
}