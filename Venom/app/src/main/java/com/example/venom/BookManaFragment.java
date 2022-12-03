package com.example.venom;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.venom.book.Book;
import com.example.venom.book.BookAdapter;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class BookManaFragment extends Fragment{

    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    BookAdapter bookAdapter;
    ArrayList<Book> bookArrayList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book_management, container, false );
        return view;


    }


}
