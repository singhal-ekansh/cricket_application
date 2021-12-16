package cricket.Schedule.IPL2020;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StatsAdapter extends RecyclerView.Adapter<StatsAdapter.statsViewHolder> {

    private  List<topRunsModel> topRunsModels;
    private  List<topWicketsModel> topWicketsModels;

    public StatsAdapter(List<topRunsModel> topRunsModels, List<topWicketsModel> topWicketsModels) {
        this.topRunsModels = topRunsModels;
        this.topWicketsModels = topWicketsModels;
    }

    @NonNull
    @Override
    public statsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.stats_card, parent, false);

        return new StatsAdapter.statsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull statsViewHolder holder, int position) {
        if (topRunsModels != null) {
            topRunsModel model = topRunsModels.get(position);
            holder.pos.setText(model.getPos());
            holder.player.setText(model.getPlayer());
            holder.team.setText(model.getTeam());
            holder.played.setText(model.getPlayed());
            holder.value.setText(model.getRuns());
        } else {
            topWicketsModel model = topWicketsModels.get(position);
            holder.pos.setText(model.getPos());
            holder.player.setText(model.getPlayer());
            holder.team.setText(model.getTeam());
            holder.played.setText(model.getPlayed());
            holder.value.setText(model.getWickets());
        }
    }

    @Override
    public int getItemCount() {
        if (topRunsModels != null)
            return topRunsModels.size();
        else
            return topWicketsModels.size();
    }


    public static class statsViewHolder extends RecyclerView.ViewHolder {

        TextView pos, player, team, played, value;

        public statsViewHolder(@NonNull View itemView) {
            super(itemView);
            pos = itemView.findViewById(R.id.statPos);
            player = itemView.findViewById(R.id.statPlayer);
            team = itemView.findViewById(R.id.statTeam);
            played = itemView.findViewById(R.id.statPlayed);
            value = itemView.findViewById(R.id.statValue);
        }
    }
}
