package cricket.Schedule.IPL2020;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class iplAdapter extends RecyclerView.Adapter<iplAdapter.iplViewHolder> {

    private final ArrayList<helperClass> iplList;

    public iplAdapter(ArrayList<helperClass> iplList, int filterBy) {


        if (filterBy == 0)
            this.iplList = iplList;
        else {

            this.iplList = new ArrayList<>();
            this.iplList.clear();

            for (int i = 0; i < iplList.size(); i++) {
                helperClass filter = iplList.get(i);

                if (filter.getLogo1() == filterBy || filter.getLogo2() == filterBy)
                    this.iplList.add(new helperClass(filter.getLogo1(), filter.getLogo2(), filter.getType(), filter.getDate(), filter.getTime(),filter.getVenue()));

            }
        }

    }

    @NonNull
    @Override
    public iplViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);

        return new iplViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull iplViewHolder holder, int position) {

        helperClass iplHelperClass = iplList.get(position);

        holder.team1.setImageResource(iplHelperClass.getLogo1());
        holder.team2.setImageResource(iplHelperClass.getLogo2());
        holder.type.setText(iplHelperClass.getType());
        holder.date.setText("Date: " + iplHelperClass.getDate());
        holder.time.setText("Time: " + iplHelperClass.getTime());
        holder.venue.setText("Venue: "+iplHelperClass.getVenue());

    }

    @Override
    public int getItemCount() {
        return iplList.size();
    }

    public static class iplViewHolder extends RecyclerView.ViewHolder {

        final ImageView team1, team2;
        final TextView type, date, time,venue;

        public iplViewHolder(@NonNull View itemView) {
            super(itemView);
            team1 = itemView.findViewById(R.id.logo1);
            team2 = itemView.findViewById(R.id.logo2);
            type = itemView.findViewById(R.id.type);
            date = itemView.findViewById(R.id.date);
            time = itemView.findViewById(R.id.time);
            venue = itemView.findViewById(R.id.venue);
        }
    }
}
