package com.yalin.viewdraghelperstudy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getItems()));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Item item = (Item) adapterView.getItemAtPosition(i);
                Intent intent = new Intent(MainActivity.this, item.activity);
                startActivity(intent);
            }
        });

    }

    private static List<Item> getItems() {
        return Arrays.asList(
                new Item("Horizontal", HorizontalActivity.class),
                new Item("Vertical", VerticalActivity.class),
                new Item("Youtube", YoutubeActivity.class)
        );
    }

    private static class Item {
        String title;
        Class activity;

        public Item(String title, Class activity) {
            this.title = title;
            this.activity = activity;
        }

        @Override
        public String toString() {
            return title;
        }
    }
}
