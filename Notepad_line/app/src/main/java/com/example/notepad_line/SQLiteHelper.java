package com.example.notepad_line;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SQLiteHelper {

    private static final String dbName = "myMemo1";
    private static final String tableName = "ImageTable";
    private static final String memotable = "MemoTable1";
    private static final String imagetable = "ImageTable";
    private static final int dbVersion = 1;

    private OpenHelper opener;
    private SQLiteDatabase db;
    private Context context;

    public SQLiteHelper(Context context){
        this.context = context;
        this.opener = new OpenHelper(context, dbName,null,dbVersion);
        db = opener.getWritableDatabase();
    }

    private class OpenHelper extends SQLiteOpenHelper {
        public OpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int Version) {
            super(context, name, factory, Version);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            String create = "CREATE TABLE "+ memotable + "("+
                    "seq integer PRIMARY KEY AUTOINCREMENT,"+
                    "maintext text," +
                    "subtext text," +
                    "titletext text," +
                    "isdone integer)";
            sqLiteDatabase.execSQL(create);

            String imageTable = "CREATE TABLE "+ imagetable + "("+
                    "seq integer PRIMARY KEY AUTOINCREMENT,"+
                    "maintext text," +
                    "subtext text," +
                    "titletext text," +
                    "isdone integer)";
            sqLiteDatabase.execSQL(imageTable);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+ memotable);
            onCreate(db);
        }
    }
    public void insertMeme(Memo memo){
        String sql = "INSERT INTO "+ memotable +" VALUES(NULL,'"+memo.getMaintext()+"','"+memo.getDatetext()+"','"+memo.getTitletext()+"',"+memo.getIsdone()+");";
        db.execSQL(sql);
    }

    public void deleteMeme(int position){
        String sql = "DELETE FROM "+ memotable +" WHERE seq = "+position+";";
        db.execSQL(sql);
    }

    public ArrayList<Memo> selectAll(){
        String sql = "SELECT * FROM "+ memotable;
        ArrayList<Memo> list = new ArrayList<>();
        Cursor results = db.rawQuery(sql, null);
        results.moveToFirst();

        while(!results.isAfterLast()){
            Memo memo = new Memo(results.getInt(0), results.getString(1), results.getString(2), results.getString(3), results.getInt(4));
            list.add(memo);
            results.moveToNext();
        }
        results.close();
        return list;
    }

}
