package com.rightside.tembicimatheuslima.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rightside.tembicimatheuslima.R;
import com.rightside.tembicimatheuslima.model.Pull;

import org.w3c.dom.Text;

import java.util.List;

public class PullRequestAdapter extends RecyclerView.Adapter<PullRequestAdapter.MyViewHolder> {
    private Context context;
    private List<Pull> pullRequests;

    public PullRequestAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_pull_request, parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textViewPullRequestName.setText(pullRequests.get(position).getName());
        Log.d("pull", pullRequests.get(position).getName());
        holder.textViewPullRequestBody.setText(pullRequests.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        if(pullRequests == null) {
            return 0;
        }
        return pullRequests.size();
    }

    public void updatePullRequests(List<Pull> pullRequests) {
        this.pullRequests = pullRequests;
        notifyDataSetChanged();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewPullRequestName, textViewPullRequestBody;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewPullRequestBody = itemView.findViewById(R.id.textView_pull_request_body);
            textViewPullRequestName = itemView.findViewById(R.id.textView_pull_request_name);
        }
    }

}
