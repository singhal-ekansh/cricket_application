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
        iplSquad.add(new squadHelper(R.drawable.ind,"INDIA Test","Virat Kohli (Captain), Rohit Sharma, KL Rahul, Mayank Agarwal, Shubman Gill, Cheteshwar Pujara, Ajinkya Rahane/Hanuma Vihari, Shreyas Iyer, R Ashwin, Ravindra Jadeja, Shardul Thakur, Rishabh Pant, Wriddhiman Saha, Jasprit Bumrah, Mohammed Shami, Mohammed Siraj, Umesh Yadav, Prasidh Krishna/Ishant Sharma"));
        iplSquad.add(new squadHelper(R.drawable.eng,"England Ashes","Joe Root (Captain), Ben Stokes, James Anderson, Jonathan Bairstow, Dom Bess, Stuart Broad, Rory Burns, Jos Buttler, Zak Crawley, Haseeb Hameed, Dan Lawrence, Jack Leach, Dawid Malan, Craig Overton, Ollie Pope, Ollie Robinson, Chris Woakes, Mark Wood"));
        iplSquad.add(new squadHelper(R.drawable.aus,"Australia Ashes","Alex Carey (wk), Pat Cummins (c), Cameron Green, Marcus Harris, Josh Hazlewood, Travis Head, Usman Khawaja, Marnus Labuschagne, Nathan Lyon, Michael Neser, Jhye Richardson, Steve Smith (vc), Mitchell Starc, Mitchell Swepson, David Warner"));
        iplSquad.add(new squadHelper(R.drawable.sa,"South Africa Test","Dean Elgar (captain), Temba Bavuma (vice-captain), Quinton de Kock (wicketkeeper), Kagiso Rabada, Sarel Erwee, Beuran Hendricks, George Linde, Keshav Maharaj, Lungi Ngidi, Aiden Markram, Wiaan Mulder, Anrich Nortje, Keegan Petersen, Rassie van der Dussen, Kyle Verreynne, Marco Jansen, Glenton Stuurman, Prenelan Subrayen, Sisanda Magala, Ryan Rickelton, Duanne Olivier"));

        adapter=new SquadAdapter(iplSquad);
        squadRecycler.setAdapter(adapter);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, 0);
    }
}