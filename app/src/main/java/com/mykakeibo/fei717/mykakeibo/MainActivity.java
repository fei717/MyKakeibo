package com.mykakeibo.fei717.mykakeibo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

/**
 * 変数名 命名規則（暫定）
 *
 * st~	: String型
 * i~	: int型
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
	TextView	tv_price;		// 金額表示用
	RadioGroup	rg_inex;		// 収支切替ラジオボタン
	Calendar	calendar;		// 時間取得用
	String		stPrice;		// 入力金額保持用（記録ボタン押下後初期化
	String		stSign;			// 収支（＋or―）

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// 金額表示用テキストボックス
		tv_price = (TextView) findViewById(R.id.textView_price);
		stPrice = "0";

		// 入力ボタン
		// todo ボタン入力系も専用のメソッド作って↓を省略？
		Button bt_0 = (Button) findViewById(R.id.button_0);
		bt_0.setOnClickListener(this);
		Button bt_00 = (Button) findViewById(R.id.button_00);
		bt_00.setOnClickListener(this);
		Button bt_1 = (Button) findViewById(R.id.button_1);
		bt_1.setOnClickListener(this);
		Button bt_2 = (Button) findViewById(R.id.button_2);
		bt_2.setOnClickListener(this);
		Button bt_3 = (Button) findViewById(R.id.button_3);
		bt_3.setOnClickListener(this);
		Button bt_4 = (Button) findViewById(R.id.button_4);
		bt_4.setOnClickListener(this);
		Button bt_5 = (Button) findViewById(R.id.button_5);
		bt_5.setOnClickListener(this);
		Button bt_6 = (Button) findViewById(R.id.button_6);
		bt_6.setOnClickListener(this);
		Button bt_7 = (Button) findViewById(R.id.button_7);
		bt_7.setOnClickListener(this);
		Button bt_8 = (Button) findViewById(R.id.button_8);
		bt_8.setOnClickListener(this);
		Button bt_9 = (Button) findViewById(R.id.button_9);
		bt_9.setOnClickListener(this);

		// 収支切替ボタン
		rg_inex = (RadioGroup) findViewById(R.id.radioGroup_inex);

		// 時間取得
		calendar = Calendar.getInstance();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		Button bt = (Button)v;

		// 入力ボタン判定
		switch(bt.getId()) {
		case R.id.button_1 :	// １～９
		case R.id.button_2 :
		case R.id.button_3 :
		case R.id.button_4 :
		case R.id.button_5 :
		case R.id.button_6 :
		case R.id.button_7 :
		case R.id.button_8 :
		case R.id.button_9 :
			if(!(stPrice.equals("0"))) {						// 金額が入力済なら(not 0円)
				stPrice = stPrice + bt.getText().toString();	// 　入力数値を追加
			} else {											// 未入力なら(0円)
				stPrice = bt.getText().toString();				// 　入力数値を設定
			}
			tv_price.setText(stPrice);	// 金額を表示
			break;
		case R.id.button_0 :	// ０or００
		case R.id.button_00 :
			if(!(stPrice.equals("0"))) {	// 入力金額が0じゃなかったら0or00を追加
				stPrice = stPrice + bt.getText().toString();
			}
			tv_price.setText(stPrice);	// 金額を表示
			break;
		}
	}

	/**
	 * 金額、収支データ記録
	 * （「記録」ボタンが押下された際にコールされる）
	 *
	 * @param v
	 */
	public void addData(View v) {
		int iRecordPrice = Integer.parseInt(stPrice);    // DBor内部ストレージ記録用

		if (iRecordPrice == 0) {        // 未入力
			Toast.makeText(this, "金額を入力して下さい", Toast.LENGTH_SHORT).show();
		} else {
			// 収支ボタン取得
			int iIncomExpen = rg_inex.getCheckedRadioButtonId();
			// 収支判定
			if (iIncomExpen == R.id.radioButton_income) {    // 収入
				stSign = "+";
			} else {                                        // 支出
				stSign = "-";
			}
			stPrice = "0";                // 記録後、0円に設定
			tv_price.setText(stPrice);    // 金額（0円）を表示

			// 記録処理
			// todo DBへの記録
		}
	}
}
