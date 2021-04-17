package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomRowAdapter extends RecyclerView.Adapter<CustomRowAdapter.ViewHolder> {

    private ArrayList<ToDo> localDataSet;

    private Context context;


    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        private int green;

        private int red;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            textView = (TextView) view.findViewById(R.id.textView);

            green = ContextCompat.getColor(view.getContext(), R.color.green);

            red = ContextCompat.getColor(view.getContext(), R.color.red);
        }

        public TextView getTextView() {
            return textView;
        }
        public int getGreenColor() { return green; }
        public int getRedColor() { return red; }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public CustomRowAdapter(ArrayList<ToDo> dataSet, Context context) {
        localDataSet = dataSet;
        this.context = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.todo_row_item, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        TextView textView = viewHolder.getTextView();
        // Get element from your dataset at this position and replace the
        // contents of the view with that element

        ToDo item = localDataSet.get(position);

        textView.setText(localDataSet.get(position).Name);

        if (localDataSet.get(position).IsDone) {
            viewHolder.getTextView().setTextColor(viewHolder.getRedColor());
        } else {
            viewHolder.getTextView().setTextColor(viewHolder.getGreenColor());
        }

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(view.getContext(), FormActivity.class);
                intent.putExtra("position", position);
                context.startActivity(intent);
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}