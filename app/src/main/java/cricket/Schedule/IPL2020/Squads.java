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
        iplSquad.add(new squadHelper(R.drawable.mi,"MUMBAI INDIANS","Rohit Sharma (16 Cr), Ishan Kishan (15.25 Cr), Suryakumar Yadav (8 Cr), Dewald Brewis (3 Cr), Anmolpreet Singh (20 L), Kieron Pollard (6 Cr), N. Tilak Varma (1.7 Cr), Ramandeep Singh (20 L), Sanjay Yadav (50 L), Tim David (8.25 Cr), Fabian Allen (75 L), Daniel Sams (2.6 Cr), Aryan Juyal (20 L), Murugan Ashwin (1.6 Cr), Jofra Archer (8 Cr), Jasprit Bumrah (12 Cr), Basil Thampi (20L), Jaydev Unadkat (1.3 Cr), Rahul Buddhi (20 L), Mayank Markande (65 L), Tymal Mills (1.5 Cr), Riley Meredith (1 Cr), Mohd. Arshad Khan (20 L), Hrithik Shokeen (20 L), Arjun Tendulkar (30 L)"));
        iplSquad.add(new squadHelper(R.drawable.csk,"CHENNAI SUPER KINGS","Ruturaj Gaikwad (6 Cr), Robin Uthappa (2 Cr), Devon Conway (1 Cr), Moeen Ali (8 Cr), Ambati Rayudu (6.75 Cr), Subhranshu Senapati (20 L), N. Jagadeesan (20 L), MS Dhoni (12 Cr), Ravindra Jadeja (16 Cr), Shivam Dube (4 Cr), Dwayne Bravo (4.4 Cr), Rajvardhan Hangargekar (1.5 Cr), Dwaine Pretorius (50 L), Mitchell Santner (1.9 Cr), Adam Milne (1.9), Chris Jordan (3.6 Cr), Deepak Chahar (14 Cr), Maheesh Theekshana (70 L), K.M. Asif (20L), Tushar Deshpande (20L), Mukesh Choudhary (20 L), C.Hari Nishaanth (20 L), K.Bhagath Varma (20 L), Simarjeet Singh (20 L), Prashant Solanki (1.2 Cr)"));
        iplSquad.add(new squadHelper(R.drawable.rcb,"ROYAL CHALLENGERS BANGALORE","Virat Kohli (15 Cr), Faf du Plessis (7 Cr), Glenn Maxwell (11 Cr), Sherfane Rutherford (1 Cr), Dinesh Karthik (5.5 Cr), Anuj Rawat (3.4 Cr), Wanindu Hasaranga (10.75 Cr), Finn Allen (80 L), Mahipal Lomror (95 L), Shahbaz Ahamad (2.4 Cr), Aneeshwar Gautam (20 L), Karn Sharma (50 L), Harshal Patel (10.75 Cr), Mohammed Siraj (7 Cr), Josh Hazlewood (7.75 Cr), Jason Behrendorff (75 L), Akash Deep (20L), Suyash Prabhudessai (30 L), Chama Milind (25 L), Siddharth Kaul (75 L), Luvnith Sisodia (20 L), David Willey (2 Cr)"));
        iplSquad.add(new squadHelper(R.drawable.dc,"DELHI CAPITALS","David Warner (6.25 Cr), Prithvi Shaw (7.5 Cr), Rishabh Pant (16 Cr), Mandeep Singh (1.1 Cr), Rovman Powell (2.8 Cr), Tim Seifert (50 L), Ashwin Hebbar (20 L), Sarfaraz Khan (20L), Yash Dhull (50 L), KS Bharat (2 Cr), Ripal Patel (20 L), Mitchell Marsh (6.5 Cr), Axar Patel (9 Cr), Shardul Thakur (10.75 Cr), Lalit Yadav (65 L), Kuldeep Yadav (2 Cr), Kamlesh Nagarkoti (1.1 Cr), Pravin Dubey (50 L), Anrich Nortje (6.5 Cr), Chetan Sakariya (4.2 Cr), Khaleel Ahmed (5.25 Cr), Mustafizur Rahman (2 Cr), Lungi Ngidi (50 L), Vicky Ostwal (20 L)"));
        iplSquad.add(new squadHelper(R.drawable.rr,"RAJASTHAN ROYALS","Yashasvi Jaiswal (4 Cr), Devdutt Padikkal (7.75 Cr), Jos Buttler (10 Cr), Karun Nair (1.4 Cr), Sanju Samson (14 Cr), Shimron Hetmyer (8.5 Cr), Rassie Van Der Dussen (1 Cr), Daryl Mitchell (75 L), James Neesham (1.5 Cr), Riyan Parag (3.8 Cr), Dhruv Jurel (20 L), Ravichandran Ashwin (5 Cr), Shubham Garhwal (20 L), Trent Boult (8 Cr), Prasidh Krishna (10 Cr), Yuzvendra Chahal (6.5 Cr), KC Cariappa (30L), Navdeep Saini (2.6 Cr), Obed Mccoy (75 L), Anunay Singh (20 L), Kuldeep Sen (20 L), Tejas Baroka (20 L), Kuldip Yadav (20 L), Nathan Coulter-Nile (2 Cr)"));
        iplSquad.add(new squadHelper(R.drawable.kkr,"KOLKATA KNIGHT RIDERS","Alex Hales (1.5 Cr), Venkatesh Iyer (8 Cr), Shreyas Iyer (12.25 Cr), Nitish Rana (8 Cr), Sam Billings (2 Cr), Ajinkya Rahane (1 Cr), Rinku Singh (55 L), Sheldon Jackson (60L), Baba Indrajith (20 L), Abhijeet Tomar (40 L), Pratham Singh (20 L), Andre Russell (12 Cr), Mohammad Nabi (1 Cr), Anukul Roy (20 L), Chamika Karunaratne (50 L),Sunil Narine (6 Cr), Pat Cummins (7.25 Cr), Tim Southee (1.5 cr), Shivam Mavi (7.25 Cr), Varun Chakravarthy (8 Cr), Rasikh Dar (20 L), Ashok Sharma (55 L), Ramesh Kumar (20 L), Umesh Yadav (2 Cr), Aman Khan (20 L)"));
        iplSquad.add(new squadHelper(R.drawable.srh,"SUNRISERS HYDERABAD","Rahul Tripathi (8.5 Cr), Aiden Markram (2.6 Cr), Kane Williamson (14 Cr), Nicholas Pooran (10.75 Cr), Romario Shepherd (7.75 Cr), Glenn Phillips (1.5 Cr), Priyam Garg (20L), Abdul Samad (4 Cr), R Samarth (20 L), Vishnu Vinod (50 L), Washington Sundar (8.75 Cr), Abhishek Sharma (6.5 Cr), Shreyas Gopal (75L), Shashank Singh (20 L), Marco Jansen (4.2 Cr), Sean Abbott (2.4 Cr), Bhuvneshwar Kumar (4.2 Cr), Umran Malik (4 Cr), T Natarajan (4 Cr), Kartik Tyagi (4 Cr), Jagadeesha Suchith (20L), Saurabh Dubey (20 L), Fazalhaq Farooqi (50 L)"));
        iplSquad.add(new squadHelper(R.drawable.kxip,"PUNJAB KINGS","Mayank Agarwal (14 Crore), Shikhar Dhawan (8.25 Cr), Jonny Bairstow (6.75 Cr), Shahrukh Khan (9 Cr), Prabhsimran Singh (60L), Jitesh Sharma (20L), Atharva Taide (20 L), Liam Livingstone (11.5 Cr), Raj Angad Bawa (2 Cr), Rishi Dhawan (55 L), Odean Smith (6 Cr), Harpreet Brar (3.8 Cr), Writtick Chatterjee (20 L), Bhanuka Rajapaksa (50 L), Nathan Ellis (75 L), Benny Howell (40 L), Kagiso Rabada (9.25 Cr), Arshdeep Singh (4 Cr), Sandeep Sharma (50 L), Rahul Chahar (5.25 Cr), Ishan Porel (25L), Prerak Mankad (20 L), Vaibhav Arora (2 Cr), Baltej Dhanda (20 L), Ansh Patel (20 L)"));
        iplSquad.add(new squadHelper(R.drawable.lsg,"LUCKNOW SUPER GIANTS","KL Rahul (17 Cr), Quinton de Kock (6.75 Cr), Evin Lewis (2 Cr), Manan Vohra (20 L), Kyle Mayers (50 L), Manish Pandey (4.6 Cr), Deepak Hooda (5.75 Cr), Marcus Stoinis (9.2 Cr), Jason Holder (8.75 Cr), Krunal Pandya (8.25 Cr), Krishnappa Gowtham (90 L), Ayush Badoni (20 L), Karan Sharma (20 L), Dushmanta Chameera (2 Cr), Ravi Bishnoi (4 Cr), Shahbaz Nadeem (50 L), Mark Wood (7.5 Cr), Avesh Khan (10 Cr), Ankit Rajpoot (50L), Mohsin Khan (20 L), Mayank Yadav (20 L)"));
        iplSquad.add(new squadHelper(R.drawable.gt,"GUJARAT TITANS","Shubman Gill (8 Cr), Jason Roy (2 Cr), Abhinav Sadarangani (2.6 Cr), David Miller (3 Cr), Matthew Wade (2.4 Cr), Wriddhiman Saha (1.9 Cr), Hardik Pandya (15 Cr), Gurkeerat Singh (50 L), Rahul Tewatia (9 Cr), Vijay Shankar (1.5 Cr), Jayant Yadav (1.7 Cr), Rashid Khan (15 Cr), Mohammed Shami (6.25 Cr), Lockie Ferguson (10 Cr), Noor Ahmad (30L), R. Sai Kishore (3 Cr), Dominic Drakes (1.1 Cr), Darshan Nalkande (20 L), Yash Dayal (3.2 Cr), Alzarri Joseph (2.4 Cr), Pradeep Sangwan (20 L), Varun Aaron (50 L), B. Sai Sudharsan (20 L)"));

        adapter=new SquadAdapter(iplSquad);
        squadRecycler.setAdapter(adapter);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, 0);
    }
}