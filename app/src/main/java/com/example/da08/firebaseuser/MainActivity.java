package com.example.da08.firebaseuser;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.da08.firebaseuser.domain.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ListViewAdapter adapter;

    FirebaseDatabase database;
    DatabaseReference userRef;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        adapter = new ListViewAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        database = FirebaseDatabase.getInstance();
        // root 노드인 user를 래퍼런스로 사용  (user라는 것부터 데이터 검색이나 저장을 하겠다는 의미)
        userRef = database.getReference("user");
        // 이벤트 리스너 담기
        userRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<User> data = new ArrayList<User>();
                for(DataSnapshot item : dataSnapshot.getChildren()){  // getChildren 키,값 하나하나의 배열로 가져옴
                    String key = item.getKey();
                    Log.i("Firebase","key "+key);
                    User user = item.getValue(User.class);
                    data.add(user);
                }
                refreshData(data);
            }

            @Override
            public void onCancelled(DatabaseError error) {
            }
        });

    }


    // firebase의 valueEventListener에서 호출
    public void refreshData(List<User> data){
        adapter.setData(data);
        adapter.notifyDataSetChanged();
    }
}


