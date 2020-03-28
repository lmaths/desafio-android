package com.rightside.tembicimatheuslima.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rightside.tembicimatheuslima.R;
import com.rightside.tembicimatheuslima.model.Repository;

import java.util.List;

public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryAdapter.RepositoryViewHolder> {

    private List<Repository> repositorios;

    public RepositoryAdapter() {
    }

    @NonNull
    @Override
    public RepositoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_repository, parent, false);
        return new RepositoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RepositoryViewHolder holder, int position) {
        holder.textViewRepositorioNome.setText(repositorios.get(position).getName());
    }

    @Override
    public int getItemCount() {
        if (repositorios == null) {
            return 0;
        }
        return repositorios.size();
    }

    public void updateRepository(List<Repository> repositorios) {
        this.repositorios = repositorios;
        notifyDataSetChanged();
    }

    class RepositoryViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewRepositorioNome;

        public RepositoryViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewRepositorioNome = itemView.findViewById(R.id.textView_repositorio_nome);
        }
    }
}
