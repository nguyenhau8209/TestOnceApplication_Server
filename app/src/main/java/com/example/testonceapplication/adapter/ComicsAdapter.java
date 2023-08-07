package com.example.testonceapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testonceapplication.R;
import com.example.testonceapplication.modal.Comic;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ComicsAdapter extends RecyclerView.Adapter<ComicsAdapter.ComicViewHolder> {
    private List<Comic> comics;

    public void setComics(List<Comic> comics) {
        this.comics = comics;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ComicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_comics_adapter, parent, false);
        return new ComicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ComicViewHolder holder, int position) {
        Comic comic = comics.get(position);
        holder.bind(comic);
    }

    @Override
    public int getItemCount() {
        return comics != null ? comics.size() : 0;
    }

    public static class ComicViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTextView;
        private TextView authorTextView;
        private TextView descriptionTextView;

        private ImageView imageView;

        public ComicViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            authorTextView = itemView.findViewById(R.id.authorTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
            imageView = itemView.findViewById(R.id.imageView);
        }

        public void bind(Comic comic) {
            titleTextView.setText(comic.getName());
            authorTextView.setText(comic.getActor());
            descriptionTextView.setText(comic.getContent());
            // Tải và hiển thị hình ảnh từ URL sử dụng Picasso
            Picasso.get().load(comic.getImages()).into(imageView);
        }
    }
}
