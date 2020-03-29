package com.rightside.tembicimatheuslima.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rightside.tembicimatheuslima.R;
import com.rightside.tembicimatheuslima.model.Pull;
import com.rightside.tembicimatheuslima.model.User;
import com.rightside.tembicimatheuslima.util.Utility;

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
        Pull pull = pullRequests.get(position);
        holder.textViewPullRequestName.setText(pull.getName());
        holder.textViewPullRequestBody.setText(pull.getBody());
        holder.textViewPullRequestBody.setMaxLines(2);
        holder.textViewPullRequestDate.setText(Utility.formatDate(pull.getDate()));
        holder.textViewPullRequestUserName.setText(pull.getUser().getName());
        Utility.showCircleImage(context, holder.imageViewPullRequestUserProfilePicture, pull.getUser().getProfilePictureUrl());

        holder.itemView.setOnClickListener(view -> {
            String url = pull.getRepositoryUrl();
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            context.startActivity(i);
        });
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
        private TextView textViewPullRequestName, textViewPullRequestBody, textViewPullRequestDate, textViewPullRequestUserName;
        private ImageView imageViewPullRequestUserProfilePicture;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewPullRequestBody = itemView.findViewById(R.id.textView_pull_request_body);
            textViewPullRequestDate = itemView.findViewById(R.id.textView_pull_request_date);
            textViewPullRequestName = itemView.findViewById(R.id.textView_pull_request_name);
            textViewPullRequestUserName = itemView.findViewById(R.id.textView_pull_request_user_name);
            imageViewPullRequestUserProfilePicture = itemView.findViewById(R.id.imageView_picture_pull_request_user);
        }
    }

}
