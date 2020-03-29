package com.rightside.tembicimatheuslima;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.rightside.tembicimatheuslima.adapter.PullRequestAdapter;
import com.rightside.tembicimatheuslima.adapter.RepositoryAdapter;
import com.rightside.tembicimatheuslima.model.Pull;
import com.rightside.tembicimatheuslima.model.Repository;
import com.rightside.tembicimatheuslima.util.Utility;
import com.rightside.tembicimatheuslima.viewmodel.ViewModelRepositorys;

import java.util.ArrayList;
import java.util.List;

public class PullRequestActivity extends AppCompatActivity {

    private ViewModelRepositorys viewModelRepositorysPullRequests;
    private PullRequestAdapter pullRequestAdapter;
    private List<Pull> pullRequests;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_request);
        RecyclerView recyclerView = findViewById(R.id.recyclerview_pull_requests);
        SearchView searchViewFindPullRequest = findViewById(R.id.searchView_find_pull_request);
        pullRequestAdapter = new PullRequestAdapter(this);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(pullRequestAdapter);
        searchViewFindPullRequest.setQueryHint("Buscar Pull Request");
        viewModelRepositorysPullRequests = ViewModelProviders.of(this).get(ViewModelRepositorys.class);
        Intent intent = getIntent();
        String ownerName = intent.getStringExtra("ownerName");
        String repoName = intent.getStringExtra("repositoryName");

        viewModelRepositorysPullRequests.getPullRequests(ownerName, repoName).observe(this, pulls -> {
            if(pulls == null) {
                Utility.showAlert("Ops", "Esse repositório não possui pull request em aberto" , PullRequestActivity.this, PullRequestActivity.this);
            } else  {
                this.pullRequests = pulls;
                pullRequestAdapter.updatePullRequests(pulls);
            }
        });

        searchViewFindPullRequest.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                findṔullRequest(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                findṔullRequest(newText);
                return false;
            }
        });


    }


    private void findṔullRequest(String text) {
        if(pullRequests.size() > 0 && !text.isEmpty()) {
            List<Pull> pullSearch = new ArrayList<>();
            for(Pull pull : pullRequests){
                if(pull.contain(text)){
                    pullSearch.add(pull);
                }
            }
            pullRequestAdapter.updatePullRequests(pullSearch);
        }else if(text.isEmpty()){
            pullRequestAdapter.updatePullRequests(pullRequests);
        }
    }

}
