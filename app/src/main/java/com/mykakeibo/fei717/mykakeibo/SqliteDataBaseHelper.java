package com.mykakeibo.fei717.mykakeibo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqliteDataBaseHelper extends SQLiteOpenHelper {
	public static final String DB_TABLE = "RecTable";
	public static final String DB_COLUMN_ID = "_id";
	public static final String DB_COLUMN_DATE = "Date";
	public static final String DB_COLUMN_SIGN = "SIGN";
	public static final String DB_COLUMN_PRICE = "PRICE";

	public SqliteDataBaseHelper(Context context) {
		super(context, "RecordDataDB", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "";			// データベースの作成
		sql += "create table "+ DB_TABLE+ " ( ";
		sql += DB_COLUMN_ID+ " integer primary key autoincrement,";
		sql += DB_COLUMN_DATE+ " text,";
		sql += DB_COLUMN_SIGN+ " text,";
		sql += DB_COLUMN_PRICE+ " integer";
		sql += ")";
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}
}
