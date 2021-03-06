package az.siftoshka.habitube.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.imageview.ShapeableImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import az.siftoshka.habitube.R;
import az.siftoshka.habitube.entities.personcredits.Crew;
import az.siftoshka.habitube.utils.ImageLoader;

public class CrewPersonAdapter extends RecyclerView.Adapter<CrewPersonAdapter.CrewHolder> {

    public interface CrewItemClickListener {
        void onPostClicked(int id);
    }

    private List<Crew> crewList;
    private CrewItemClickListener clickListener;

    public CrewPersonAdapter(@NonNull CrewItemClickListener clickListener) {
        this.crewList = new ArrayList<>();
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public CrewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_credits, parent, false);
        return new CrewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CrewHolder holder, final int position) {
        final Crew post = this.crewList.get(position);
        ImageLoader.loadPersons(holder.itemView, post.getPosterPath(), holder.posterImage);
        if (post.getTitle() != null) {
            holder.posterTitle.setText(post.getTitle());
        } else {
            holder.posterTitle.setText(post.getName());
        }
        holder.posterDate.setText(post.getJob());

        holder.posterLayout.setOnClickListener(v -> {
            clickListener.onPostClicked(post.getId());
        });
    }

    @Override
    public void onViewRecycled(@NonNull CrewHolder holder) {
        holder.posterTitle.setText(null);
        holder.posterDate.setText(null);
        holder.posterLayout.setOnClickListener(null);
    }

    @Override
    public int getItemCount() {
        return crewList == null ? 0 : crewList.size();
    }

    public void addAllPersons(List<Crew> crew) {
        Collections.sort(crew, (o1, o2) -> o1.getJob().compareTo(o2.getJob()));
        this.crewList.clear();
        this.crewList.addAll(crew);
        notifyDataSetChanged();
    }

    static class CrewHolder extends RecyclerView.ViewHolder {

        LinearLayout posterLayout;
        ShapeableImageView posterImage;
        TextView posterTitle, posterDate;

        CrewHolder(@NonNull View itemView) {
            super(itemView);
            this.posterLayout = itemView.findViewById(R.id.item_layout_search);
            this.posterImage = itemView.findViewById(R.id.poster_image_search);
            this.posterTitle = itemView.findViewById(R.id.poster_main_text_search);
            this.posterDate = itemView.findViewById(R.id.poster_main_date_search);
        }
    }
}