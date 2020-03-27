package com.rightside.tembicimatheuslima;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.rightside.tembicimatheuslima.adapter.RepositoryAdapter;
import com.rightside.tembicimatheuslima.model.Repository;
import com.rightside.tembicimatheuslima.viewmodel.ViewModelRepositorys;

import java.util.List;

public class PrincipalActivity extends AppCompatActivity {
    private ViewModelRepositorys viewModelRepositorys;
    private RepositoryAdapter repositoryAdapter;
    private List<Repository> repositorios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        RecyclerView recyclerView = findViewById(R.id.recyclerview_repositorios);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        repositoryAdapter = new RepositoryAdapter();
        recyclerView.setAdapter(repositoryAdapter);

        viewModelRepositorys = ViewModelProviders.of(this).get(ViewModelRepositorys.class);
        viewModelRepositorys.getResposta(1).observe(this, response ->{
            repositorios = response.getItens();
            repositoryAdapter.updateRepository(repositorios);
        });


    }
}
