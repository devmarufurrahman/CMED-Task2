package com.maruf.cmedtask2;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.maruf.cmedtask2.adapters.CharactersListAdapter;
import com.maruf.cmedtask2.model.CharactersModel;
import com.maruf.cmedtask2.viewmodels.CharactersListViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recview;
    List<CharactersModel> movielist;
    CharactersListViewModel listViewModel;
    CharactersListAdapter adapter;
    TextView noresfound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recview=findViewById(R.id.recview);
        noresfound=findViewById(R.id.noresult);

        recview.setLayoutManager(new LinearLayoutManager(this));
        recview.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        adapter=new CharactersListAdapter(movielist);
        recview.setAdapter(adapter);

        listViewModel= new ViewModelProvider(this).get(CharactersListViewModel.class);
        listViewModel.getCharacterslistObserver().observe(this, new Observer<List<CharactersModel>>() {
            @Override
            public void onChanged(List<CharactersModel> CharactersModels) {
                if(CharactersModels!=null) {
                    movielist= CharactersModels;
                    adapter.updatecharacterslist(CharactersModels);
                    noresfound.setVisibility(View.GONE);
                }
                if(CharactersModels==null)
                {
                    recview.setVisibility(View.GONE);
                    noresfound.setVisibility(View.VISIBLE);
                }
            }
        });
        listViewModel.makeApiCall();


    }


}