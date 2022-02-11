package com.maximapps.kalashnikovtesttask.ui.main.list;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.maximapps.kalashnikovtesttask.databinding.ListItemBinding;
import com.maximapps.kalashnikovtesttask.domain.models.Book;


import java.util.ArrayList;
import java.util.List;


public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.BookViewHolder> {
    private final List<Book> list = new ArrayList<>();
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onClick(int id);
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setData(List<Book> books) {
        list.clear();
        list.addAll(books);
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BookViewHolder(
                ListItemBinding.inflate(
                        LayoutInflater.from(parent.getContext()), parent, false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class BookViewHolder extends RecyclerView.ViewHolder {
        private final ListItemBinding binding;

        public BookViewHolder(@NonNull ListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Book book) {
            binding.bookTitle.setText(book.getName());
            binding.getRoot().setOnClickListener(view -> listener.onClick(book.getId()));
        }
    }
}
