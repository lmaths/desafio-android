package com.rightside.tembicimatheuslima;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ProgressBar;

import com.rightside.tembicimatheuslima.adapter.RepositoryAdapter;
import com.rightside.tembicimatheuslima.model.Repository;
import com.rightside.tembicimatheuslima.viewmodel.ViewModelRepositorys;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PrincipalActivity extends AppCompatActivity {
    private ViewModelRepositorys viewModelRepositorys;
    private RepositoryAdapter repositoryAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private Boolean scrolando = false;
    private List<Repository> repositorios;
    private int currentItens, totalItens, scrollOutItens;
    private static int firstItemVisible;
    private ProgressBar progressBarLoading;
    private int pag = 1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        recyclerView = findViewById(R.id.recyclerview_repositorios);
        SearchView searchViewFindRepository = findViewById(R.id.searchView_find_repository);
        Toolbar toolbar = findViewById(R.id.toolbar_principal);
        repositoryAdapter = new RepositoryAdapter(PrincipalActivity.this);
        viewModelRepositorys = ViewModelProviders.of(this).get(ViewModelRepositorys.class);
        linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(repositoryAdapter);
        progressBarLoading = findViewById(R.id.progressBar_loading_repositories);
        firstItemVisible = linearLayoutManager.findFirstVisibleItemPosition();
        toolbar.setTitle("Repositórios:");
        toolbar.setTitleTextColor(Color.WHITE);
        searchViewFindRepository.setQueryHint("Buscar Repositório: ");

        if(savedInstanceState != null) {
            repositorios = (List<Repository>) savedInstanceState.getSerializable("repositorios");
        } else {
            repositorios = new ArrayList<>();

            if(recyclerView.getAdapter().getItemCount() == 0 ){
                fetchData(pag);
            }
        }

        searchViewFindRepository.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                findRepository(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                findRepository(newText);
                return false;
            }
        });



        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    scrolando = true;
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                currentItens = linearLayoutManager.getChildCount();
                totalItens = linearLayoutManager.getItemCount();
                scrollOutItens = linearLayoutManager.findFirstVisibleItemPosition();

                if(scrolando && ( currentItens + scrollOutItens == totalItens)) {
                    scrolando = false;
                    fetchData(pag);
                }
            }
        });

    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("repositorios", (Serializable) repositorios);
    }

    private void fetchData(int page) {
        progressBarLoading.setVisibility(View.VISIBLE);
        recyclerView.setNestedScrollingEnabled(false);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                viewModelRepositorys.getResponse(page).observe(PrincipalActivity.this, response -> {
                    for (Repository repository : response.getItens()) {
                        repositorios.add(repository);
                    }
                    repositoryAdapter.updateRepository(repositorios);
                    progressBarLoading.setVisibility(View.GONE);
                });

               pag = pag + 1;

            }
        }, 5000);

    }


    private void findRepository(String text) {
        if(repositorios.size() > 0 && !text.isEmpty()) {
            List<Repository> repositorySearch = new ArrayList<>();
            for(Repository repository : repositorios){
                if(repository.contain(text)){
                    repositorySearch.add(repository);
                }
            }
            repositoryAdapter.updateRepository(repositorySearch);
        }else if(text.isEmpty()){
            repositoryAdapter.updateRepository(repositorios);
        }
    }


}
