package com.madhumankatha.kuvempuuniv.adpaters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.madhumankatha.kuvempuuniv.R;
import com.madhumankatha.kuvempuuniv.model.Event;

import java.util.List;

public class DocsAdpater extends RecyclerView.Adapter<DocsAdpater.ViewHolder> {
    private List<Event> docsList;
    private Context context;

    public DocsAdpater(List<Event> docsList, Context context) {
        this.docsList = docsList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.documents_adpater,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvTitle.setText(docsList.get(position).getTitle());
        holder.tvAuthor.setText(docsList.get(position).getAuthor());
        holder.tvDate.setText(docsList.get(position).getDate());
        holder.tvCategory.setText(docsList.get(position).getCategory());
    }

    @Override
    public int getItemCount() {
        return docsList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private   TextView tvTitle,tvCategory,tvDate,tvAuthor;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.docsTvTitle);
            tvAuthor = itemView.findViewById(R.id.docsTvAuthor);
            tvDate = itemView.findViewById(R.id.docsTvDate);
            tvCategory = itemView.findViewById(R.id.docsTvCategory);

            itemView.setOnClickListener(view -> {
                int pos = getAdapterPosition();
                if (pos >=0 && pos <= getItemCount()){
                    Event docs = docsList.get(pos);
                    Bundle bundle = new Bundle();

                    bundle.putString("title",docs.getTitle());
                    bundle.putString("pdf",docs.getPdf());

                    Navigation.findNavController(view).navigate(R.id.action_docsFragment_to_docsDetailsFragment
                    ,bundle);
                }
            });
        }
    }
}
