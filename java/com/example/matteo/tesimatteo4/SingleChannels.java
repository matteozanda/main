package com.example.matteo.tesimatteo4;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SingleChannels extends AppCompatActivity {

    private List<Fader> myFaders = new ArrayList<Fader>();
    private static int numeroMaxFader = 48;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_channels);

        inizializzaBottoni();
        populateFaderList();
        populateListView();
        //registerClickCallback();
    }

    private void inizializzaBottoni(){
        Button btnSingleClear, btnSingleBO, btnSingleSave, btnSingleHL, btnSingleNext, btnSinglePrev;
        ImageButton menuBottone;

        // inizializzazione bottoni
        menuBottone = (ImageButton)findViewById(R.id.btnSingleMenu);
        btnSingleClear = (Button)findViewById(R.id.btnSingleClear);
        btnSingleBO = (Button)findViewById(R.id.btnSingleBO);
        btnSingleSave = (Button) findViewById(R.id.btnSingleSave);
        btnSingleHL = (Button) findViewById(R.id.btnSingleHL);
        btnSingleNext =(Button) findViewById(R.id.btnSingleNext);
        btnSinglePrev =(Button) findViewById(R.id.btnSinglePrev) ;



        btnSingleClear.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View view) {
                                              /*    for(int element:valoreFaders) {element = 0; };
                                                  for(TextView element:valFader) element.setText(0 + "%");
                                                 for(SeekBar element:fader) element.setProgress(0);
                                                  */}
                                          }
        );


        btnSingleBO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        menuBottone.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View arg0) {
                                               //definisco l'intenzione
                                               Intent openMenu = new Intent(SingleChannels.this, Menu.class);
                                               //richiamo l'activity
                                               startActivity(openMenu);
                                           }
                                       }
        );

        btnSingleHL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                CharSequence text = "Hi-Light in sviluppo";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
        btnSingleNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                CharSequence text = "Hi-Light in sviluppo";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });

        btnSinglePrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                CharSequence text = "Hi-Light in sviluppo";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
        btnSingleSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                CharSequence text = "Gestione Files in sviluppo";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
        btnSingleBO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                CharSequence text = "Comincio a dubitare della necessarietà di questo tasto ";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
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
    } */
    private class MyListAdapter extends ArrayAdapter<Fader> {
        // valori limite
        private static final int MINVALUE = 0;
        private static final int MAXVALUE = 255;
        private static final int valoreIniziale = 0;

        // questo valore rappresenta il valore  del modello della mia applicazione
        int valueModel = 0;

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
            final Fader currentFader = myFaders.get(position);

            /*// Fill the view
            ImageView imageView = (ImageView)itemView.findViewById(R.id.item_icon);
            imageView.setImageResource(currentFader.getIconID());*/

            // numero fader:
            TextView numFaderText = (TextView) itemView.findViewById(R.id.numFader);
            String valore = "" + (currentFader.getNumFader() + 1);
            numFaderText.setText(valore);

            // valore fader:
            TextView valoreFader = (TextView) itemView.findViewById(R.id.valFader);
            valore = currentFader.getValFader()+"%";
            valoreFader.setText(valore);

            // Nome fader:
            TextView condionText = (TextView) itemView.findViewById(R.id.nomeFader);
            valore = ""+currentFader.getNomeFader();
//            condionText.setText(valore);

            return itemView;
        }

/*
            currentFader.barFader.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    if (fromUser) {
                        //updateValue(seekBar.getProgress());

                    }
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    //updateValue(seekBar.getProgress());
                }
            });

*/

        /**********************************************************/
        /**
         * Aggiorna lo stato dell'interfaccia in base ai valori
         * contenuti nel modello
         * @param newValue il nuovo valore da inserire nel modello
         **/
/*
        //////// ORIGINALE
        private void updateValue(int newValue){
            newValue = newValue > MAXVALUE ? MAXVALUE : newValue;
            newValue = newValue < MINVALUE ? MINVALUE : newValue;
            // ora siamo sicuri che newValue sia nel range
            this.valueModel= newValue;
            this.valFader.setText("" + valueModel);
            if(this..getProgress() != valueModel - MINVALUE) {
                this.seekBar.setProgress(valueModel - MINVALUE);
            }

        }



           /////// MODIFICATO
            private void updateValue(int newValue){
                newValue = newValue > MAXVALUE ? MAXVALUE : newValue;
                newValue = newValue < MINVALUE ? MINVALUE : newValue;
                // ora siamo sicuri che newValue sia nel range
                this.valueModel= newValue;
                valoreFader.setText(valueModel+"%");

                if(currentFader.barFader.getProgress() != valueModel - MINVALUE) {
                    currentFader.barFader.setProgress(valueModel - MINVALUE);
                }
            }
            //this.updateValue(valoreIniziale);
        ***********************************************************/

    }
}

