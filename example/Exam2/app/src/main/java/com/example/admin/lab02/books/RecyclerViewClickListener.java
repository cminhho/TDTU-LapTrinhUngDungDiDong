package com.example.admin.lab02.books;

import android.view.View;

/**
 * Created by Admin on 9/7/2019.
 */

public interface RecyclerViewClickListener {
    void onClick(View view, int position);

    void onLongClick(View view, int position);
}