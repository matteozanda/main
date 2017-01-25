package com.example.matteo.tesimatteo4;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SingleChannels extends AppCompatActivity {

    private List<Fader> myFaders = new ArrayList<Fader>();
    private static int numeroMaxFader = 400;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_channels);

        populateFaderList();
        populateListView();
        //registerClickCallback();
    }

    private void populateFaderList(){
        for (int i =0; i<numeroMaxFader; i++){
            myFaders.add(new Fader(i, 0, ""));
        }
    }


    private void populateListView() {
        ArrayAdapter<Fader> adapter = new MyListAdapter();
        ListView list = (ListView) findViewById(R.id.listaFader);
        list.setAdapter(adapter);
    }
/*
    private void registerClickCallback() {
        ListView list = (ListView) findViewById(R.id.carsListView);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked,
                                    int position, long id) {

                Fader clickedCar = myCars.get(position);
                String message = "You clicked position " + position
                        + " Which is Fader make " + clickedCar.getMake();
                Toast.makeText(SingleChannels.this, message, Toast.LENGTH_LONG).show();
            }
        });
    }
*/
    private class MyListAdapter extends ArrayAdapter<Fader> {
        public MyListAdapter() {
            super(SingleChannels.this, R.layout.single_fader, myFaders);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Make sure we have a view to work with (may have been given null)
            View itemView = convertView;
            if (itemView == null) {
                itemView = getLayoutInflater().inflate(R.layout.single_fader, parent, false);
            }

            // Find the Fader to work with.
            Fader currentFader = myFaders.get(position);

            /*// Fill the view
            ImageView imageView = (ImageView)itemView.findViewById(R.id.item_icon);
            imageView.setImageResource(currentFader.getIconID());*/

            // numero fader:
           TextView numFaderText = (TextView) itemView.findViewById(R.id.numFader);
            String valore = ""+(currentFader.getNumFader()+1);
            numFaderText.setText(valore);

            // valore fader:
            TextView yearText = (TextView) itemView.findViewById(R.id.valFader);
            valore = ""+currentFader.getValFader();
            yearText.setText(valore);

            // Nome fader:
            TextView condionText = (TextView) itemView.findViewById(R.id.nomeFader);
            valore = ""+currentFader.getNomeFader();
//            condionText.setText(valore);

            return itemView;
        }
    }
}

