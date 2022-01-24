package cricket.Schedule.IPL2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Squads extends AppCompatActivity {
    RecyclerView squadRecycler;
    ArrayList<squadHelper> iplSquad;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_squads);

        squadRecycler = findViewById(R.id.squadRecycler);
      //  squadRecycler.setHasFixedSize(true);
        squadRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

        iplSquad = new ArrayList<>();
        iplSquad.add(new squadHelper(R.drawable.mi,"MUMBAI INDIANS","Rohit Sharma(captain),Suryakumar Yadav,Kieron Pollard,Jasprit Bumrah"));
        iplSquad.add(new squadHelper(R.drawable.csk,"CHENNAI SUPER KINGS","MS Dhoni,Ravindra Jadeja,Ruturaj Gaikwad,Moeen Ali"));
        iplSquad.add(new squadHelper(R.drawable.rcb,"ROYAL CHALLENGERS BANGALORE","Virat Kohli,Glenn Maxwell,Mohammed Siraj"));
        iplSquad.add(new squadHelper(R.drawable.dc,"DELHI CAPITALS","Prithvi Shaw,Rishabh Pant,Axar Patel,Anrich Nortje"));
        iplSquad.add(new squadHelper(R.drawable.rr,"RAJASTHAN ROYALS","Yashasvi Jaiswal,Sanju Samson,Jos Butler"));
        iplSquad.add(new squadHelper(R.drawable.kkr,"KOLKATA KNIGHT RIDERS","Andre Russell,Venkatesh Iyer,Sunil Narine,Varun Chakravarty"));
        iplSquad.add(new squadHelper(R.drawable.srh,"SUNRISERS HYDERABAD","Kane Williamson(captain),Abdul Samad,Umran Malik"));
        iplSquad.add(new squadHelper(R.drawable.kxip,"PUNJAB KINGS","Mayank Agarwal,Arshdeep Singh"));
        iplSquad.add(new squadHelper(R.drawable.tba,"LUCKNOW","KL Rahul(captain),Marcus Stoinis,Ravi Bishnoi"));
        iplSquad.add(new squadHelper(R.drawable.tba,"AHMEDABAD","Hardik Pandya,Shubman Gill,Rashid Khan"));

        adapter=new SquadAdapter(iplSquad);
        squadRecycler.setAdapter(adapter);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, 0);
    }
}