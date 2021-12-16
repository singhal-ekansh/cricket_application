package cricket.Schedule.IPL2020;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class pointsTableAdapter extends RecyclerView.Adapter<pointsTableAdapter.pointsViewHolder> {

    private final ArrayList<pointsModelClass> pointsList;

    public pointsTableAdapter(ArrayList<pointsModelClass> pointsList) {
        this.pointsList = pointsList;
    }

    @NonNull
    @Override
    public pointsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.points_card, parent, false);

        return new pointsTableAdapter.pointsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull pointsViewHolder holder, int position) {

        pointsModelClass modelClass = pointsList.get(position);

        holder.posView.setText(modelClass.getPosition());
        holder.nameView.setText(modelClass.getName());
        holder.playedView.setText(modelClass.getPlayed());
        holder.winView.setText(modelClass.getWin());
        holder.lostView.setText(modelClass.getLost());
        holder.nrrView.setText(modelClass.getNrr());
        holder.ptsView.setText(modelClass.getPoints());
    }

    @Override
    public int getItemCount() {
        return pointsList.size();
    }

    public static class pointsViewHolder extends RecyclerView.ViewHolder {

        final TextView posView;
        final TextView nameView;
        final TextView playedView;
        final TextView winView;
        final TextView lostView;
        final TextView nrrView;
        final TextView ptsView;

        public pointsViewHolder(@NonNull View itemView) {
            super(itemView);
            posView = itemView.findViewById(R.id.positionText);
            nameView = itemView.findViewById(R.id.nameText);
            playedView = itemView.findViewById(R.id.playText);
            winView = itemView.findViewById(R.id.winText);
            lostView = itemView.findViewById(R.id.lostText);
            nrrView = itemView.findViewById(R.id.nrrText);
            ptsView = itemView.findViewById(R.id.ptsText);

        }
    }
}
