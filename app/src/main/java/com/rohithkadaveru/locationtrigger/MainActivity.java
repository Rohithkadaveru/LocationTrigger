package com.rohithkadaveru.locationtrigger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView myRecyclerView;
    private RecyclerViewAdapter myRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myRecyclerView = (RecyclerView) findViewById(R.id.list);
        myRecyclerViewAdapter = new RecyclerViewAdapter(this, getData());
        myRecyclerView.setAdapter(myRecyclerViewAdapter);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    /**
     * Retrieve data from source
     *
     * @return List of Item data
     */
    public List<ItemModel> getData() {

        //TODO retrieve data from DB/JSON/sharedpref

        List<ItemModel> itemData = new ArrayList<>();
        String[] names = {"1", "2", "3", "4", "5"};
        String[] address = {"1", "2", "3", "4", "5"};

        for (int i = 0; i < names.length; i++) {

            ItemModel currentitem = new ItemModel();

            currentitem.address = address[i];
            currentitem.triggername = names[i];
            itemData.add(currentitem);

        }
        return itemData;
    }

}
