package cricket.Schedule.IPL2020;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SquadAdapter extends RecyclerView.Adapter<SquadAdapter.squadViewHolder> {
    ArrayList<squadHelper> iplSquad;

    public SquadAdapter(ArrayList<squadHelper> iplSquad) {
        this.iplSquad = iplSquad;
    }

    @NonNull
    @Override
    public squadViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.squad_card, parent, false);
        return new SquadAdapter.squadViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull squadViewHolder holder, int position) {
        squadHelper helper = iplSquad.get(position);
        holder.imageView.setImageResource(helper.getImgId());
        holder.textViewName.setText(helper.getSquadName());
        holder.textViewSquad.setText(helper.getTeamSquad());
    }

    @Override
    public int getItemCount() {
        return iplSquad.size();
    }

    public static class squadViewHolder extends RecyclerView.ViewHolder {
        final ImageView imageView;
        final TextView textViewName;
        final TextView textViewSquad;

        public squadViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.squadImg);
            textViewName = itemView.findViewById(R.id.squadName);
            textViewSquad = itemView.findViewById(R.id.squadValue);
        }
    }
}
