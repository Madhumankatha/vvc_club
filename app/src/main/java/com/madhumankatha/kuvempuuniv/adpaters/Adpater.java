package com.madhumankatha.kuvempuuniv.adpaters;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.madhumankatha.kuvempuuniv.R;
import com.madhumankatha.kuvempuuniv.model.Event;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adpater extends RecyclerView.Adapter<Adpater.ViewHolder> {
    private List<Event> eventList;
    private Context context;

    public Adpater(List<Event> eventList, Context context) {
        this.eventList = eventList;
        this.context = context;
    }

    @NonNull
    @Override
    public Adpater.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.eventadpater,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adpater.ViewHolder holder, int position) {
        holder.tvTitle.setText(eventList.get(position).getTitle());
        holder.tvDate.setText(eventList.get(position).getDate());
        holder.tvAuhtor.setText(eventList.get(position).getAuthor());
        Picasso.get().load(eventList.get(position).getImg()).fit().into(holder.imgHeader);
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgHeader;
        private TextView tvTitle,tvDate,tvAuhtor;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgHeader = itemView.findViewById(R.id.imgEventImg);
            tvTitle = itemView.findViewById(R.id.tvEventTitle);
            tvDate = itemView.findViewById(R.id.tvEventDate);
            tvAuhtor = itemView.findViewById(R.id.tvEventAuthor);

            itemView.setOnClickListener(view -> {
                int pos = getAdapterPosition();
                if (pos >= 0 && pos < getItemCount()){
                    Bundle bundle = new Bundle();
                    Event event = eventList.get(pos);
                    bundle.putString("img",event.getImg());
                    bundle.putString("title",event.getTitle());
                    bundle.putString("author",event.getAuthor());
                    bundle.putString("date",event.getDate());
                    bundle.putString("desc",event.getDesc());

                    Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_eventDetailsFragment
                    ,bundle);
                }
            });
        }
    }
}
