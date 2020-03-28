package com.rightside.tembicimatheuslima;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.rightside.tembicimatheuslima.adapter.PullRequestAdapter;
import com.rightside.tembicimatheuslima.adapter.RepositoryAdapter;
import com.rightside.tembicimatheuslima.viewmodel.ViewModelRepositorys;

public class PullRequestActivity extends AppCompatActivity {

    private ViewModelRepositorys viewModelRepositorysPullRequests;
    private PullRequestAdapter pullRequestAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_request);
        Toolbar toolbar = findViewById(R.id.toolbar);
        RecyclerView recyclerView = findViewById(R.id.recyclerview_pull_requests);
        pullRequestAdapter = new PullRequestAdapter(this);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(pullRequestAdapter);
        viewModelRepositorysPullRequests = ViewModelProviders.of(this).get(ViewModelRepositorys.class);
        Intent intent = getIntent();

        String ownerName = intent.getStringExtra("ownerName");
        String repoName = intent.getStringExtra("repositoryName");

        Log.d("pull", ownerName + " " + repoName);

        viewModelRepositorysPullRequests.getPullRequests(ownerName, repoName).observe(this, pulls -> {
            pullRequestAdapter.updatePullRequests(pulls);
        });


    }
}
