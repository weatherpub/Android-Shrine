package edu.sfsu.shrine.code.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import java.util.ArrayList;

import edu.sfsu.shrine.R;
import edu.sfsu.shrine.code.model.RandomUserModel;

/* RecyclerView Adapter
 * The adapter has two main jobs:
 * 1. To create each of the views that are visible within the recycler view.
 * 2. Bind each view to a piece of data.
 *
 * The RecyclerView needs to display a set of cards, each containing an image and caption.
 *
 * The ViewHolder is used to specify which views should be used for each data item.
 * 1. Define a nested class:
 *      public static class ViewHolder extends RecyclerView.ViewHolder {
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    ArrayList<RandomUserModel> randomUserModel;

    private Listener listener;

    // Remember to set the Listener to public!
    public interface Listener {
        public void onClick(int position);
    }

    public RecyclerViewAdapter(ArrayList<RandomUserModel> randomUserModel ) {
        this.randomUserModel = randomUserModel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        View itemView = holder.itemView;

        RandomUserModel item = randomUserModel.get(position);

        String picture = item.getPicture_medium();
        Picasso.get().load(item.getPicture_large()).resize(600, 0).centerCrop().into(holder.image);

        holder.name_first.setText(String.format("%s", item.getName_first()));

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("LOG", "-> onClick() [ " + position + " ]");
                if(listener != null) {
                    listener.onClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return randomUserModel.size();
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    // Static nested classes do not have access to other members of the enclosing class.
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView image;
        public TextView name_first;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.tv_url_to_image);
            name_first = itemView.findViewById(R.id.tv_name_first);
        }

        @Override
        public void onClick(View view) {
            Log.v("LOG", "onClicking the truth => ");
        }
    }
}