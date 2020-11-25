package com.example.seminarska_171074;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.seminarska_171074.R;
import android.os.Bundle;
import android.widget.ImageView;

public class CategoryActivity extends AppCompatActivity {

    String s1[],s2[];
    int[] images = {R.drawable.birthday,R.drawable.christmas,R.drawable.new_year,R.drawable.easter,R.drawable.thanksgiving,R.drawable.halloween,R.drawable.april_fools};

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.test);

//        setContentView(R.layout.my_row);
//        ImageView myImage=findViewById(R.id.myImage);
//        myImage.setImageResource(images[0]);



//        ImageView mImageView;
//        mImageView = (ImageView)findViewById(R.id.testtest);
//        mImageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_launcher_background));




        setContentView(R.layout.activity_category);

        recyclerView = findViewById(R.id.recyclerView);

        s1 = getResources().getStringArray(R.array.occasions);
        s2 = getResources().getStringArray(R.array.description);

        MyAdapter myAdapter = new MyAdapter(this,s1,s2,images);

        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



    }
}