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

	public SqliteDataBaseHelper(Context context, String dbname, int version) {
		super(context, dbname, null, version);
		//第一引数は、データベースを所有するコンテキストオブジェクトを指定。
		//第二引数は、DBファイル名。保存場所。
		//data/data/<パッケージ名>/database/<ファイル名>に保存される。
		//nullにすると、メモリ内に保存される。
		//第三引数は、不明。とりあえずnull。
		//第四引数は、DBのバージョンで、作成するときに指定。今は1。
		//データベース管理のために使うらしい。
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "";			// データベースの作成
		sql += "create table "+ DB_TABLE+ " (";
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
