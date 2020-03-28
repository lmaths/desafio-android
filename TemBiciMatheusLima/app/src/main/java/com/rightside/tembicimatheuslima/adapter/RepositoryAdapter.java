package com.rightside.tembicimatheuslima.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rightside.tembicimatheuslima.R;
import com.rightside.tembicimatheuslima.model.Repository;
import com.rightside.tembicimatheuslima.util.Utility;

import java.util.List;

public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryAdapter.RepositoryViewHolder> {

    private List<Repository> repositories;
    private Context context;

    public RepositoryAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RepositoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_repository, parent, false);
        return new RepositoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RepositoryViewHolder holder, int position) {
        Repository repository = repositories.get(position);
        holder.textViewRepositoryName.setText(repository.getName());
        holder.textViewRepositoryStars.setText(String.valueOf(repository.getStars()));
        holder.textViewRepositoryForks.setText(String.valueOf(repository.getForks()));
        holder.textViewRepositoryDescription.setText(repository.getDescription());
        holder.textViewRepositoryOwnerNickname.setText(repository.getCreator().getName());
        holder.textViewRepositoryDescription.setMaxLines(2);
        Utility.showCircleImage(context, holder.imageViewPictureRepositoryOwner, repository.getCreator().getProfilePictureUrl());

        holder.itemView.setOnClickListener(view -> {
            
        });

    }

    @Override
    public int getItemCount() {
        if (repositories == null) {
            return 0;
        }
        return repositories.size();
    }

    public void updateRepository(List<Repository> repositories) {
        this.repositories = repositories;
        notifyDataSetChanged();
    }

    class RepositoryViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewRepositoryName, textViewRepositoryDescription, textViewRepositoryForks, textViewRepositoryStars,
        textViewRepositoryOwnerNickname;
        private ImageView imageViewPictureRepositoryOwner;


        public RepositoryViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewRepositoryName = itemView.findViewById(R.id.textView_repositorio_nome);
            textViewRepositoryDescription = itemView.findViewById(R.id.textView_description);
            textViewRepositoryForks = itemView.findViewById(R.id.textView_forks);
            textViewRepositoryStars = itemView.findViewById(R.id.textView_stars);
            textViewRepositoryOwnerNickname = itemView.findViewById(R.id.textView_repository_owner_nickname);
            imageViewPictureRepositoryOwner = itemView.findViewById(R.id.imageView_picture_repository_owner);
        }
    }
}
