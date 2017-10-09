package com.trkaynak.mydatabase;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            SQLiteDatabase myDatabase=this.openOrCreateDatabase("database",MODE_PRIVATE,null);//Veritabanı dosyası oluşturuldu.
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS isimler (name VARCHAR, yas INT(2))");//Dosya içerisinde tablo oluşturuluyor.
         //   myDatabase.execSQL("INSERT INTO isimler (name,yas) VALUES ('James',50)");
           Cursor cursor=myDatabase.rawQuery("SELECT * FROM isimler",null);
            int nameIx=cursor.getColumnIndex("name");//name sütunu okuyor.
            int yasIx=cursor.getColumnIndex("yas");//yas sütununu okuyor

            cursor.moveToFirst();//cursor ilk değere alınıyor.baştan okuma olsun diye.

            while (cursor!=null){//cursor boşsatıra gelene kadar devam edecek

                System.out.println("Name: "+cursor.getString(nameIx));
                System.out.println("Yas: "+cursor.getInt(yasIx));
                cursor.moveToNext();//sonraki satıra geç
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }


    }
}
