package com.example.appitemview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    ArrayList<Avenger> list = new ArrayList<Avenger>();
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv);

        // parameterized ma je rite 3 pass karela a j rite ama akarvana
        list.add(new Avenger(R.drawable.captain,"Captain America","Shield"));
        list.add(new Avenger(R.drawable.hawkeye,"Hawk Eye","Bow"));
        list.add(new Avenger(R.drawable.hulk,"Hulk","Gama Radiation"));
        list.add(new Avenger(R.drawable.ironman,"Iron Man","Suit"));
        list.add(new Avenger(R.drawable.loki,"Loki","Dark Magic"));
        list.add(new Avenger(R.drawable.spiderman,"Spider Man","Web"));
        list.add(new Avenger(R.drawable.thor,"Thor","Hammer"));
        list.add(new Avenger(R.drawable.widow,"Black Widow","karate"));


        CustomAdapter adapter = new CustomAdapter(this,R.layout.design,list);   //arrayadapter no child adapter custom adapter banay didhu

        lv.setAdapter(adapter); // lv par set karva
    }
}