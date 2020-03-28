package com.rightside.tembicimatheuslima.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.rightside.tembicimatheuslima.model.Pull;
import com.rightside.tembicimatheuslima.model.Response;
import com.rightside.tembicimatheuslima.ws.SetupREST;

import java.util.List;

public class ViewModelRepositorys extends AndroidViewModel {
    private SetupREST setupREST;

    public ViewModelRepositorys(@NonNull Application application) {
        super(application);
        setupREST = new SetupREST();
    }

    public MutableLiveData<Response> getResponse(int page) {
        return setupREST.getResponse(page);
    }

    public MutableLiveData<List<Pull>> getPullRequests(String ownerName, String repoName) {
        return setupREST.getPullRequest(ownerName, repoName);
    }


}
