package com.example.matteo.tesimatteo4;

import android.util.Log;
import android.widget.SeekBar;

/**
 * Created by Matteo on 24/01/2017.
 */

public class Fader implements SeekBar.OnSeekBarChangeListener{
    int numFader;
    int valFader;
    SeekBar barFader;
    String nomeFader;



    private static final int MINVALUE = 0;
    private static final int MAXVALUE = 255;

    public Fader(int numFader,  int valFader, String nomeFader) {
        this.numFader = numFader;
        this.valFader = valFader;
        this.nomeFader = nomeFader;
    }



    public int getNumFader() {
        return numFader;
    }


    public int getValFader() {
        return valFader;
    }

    public String getNomeFader() {
        return nomeFader;
    }

    public int getBarFader() {
        return barFader.getProgress();
    }



    @Override
    public void onProgressChanged(SeekBar seekBar, int valore, boolean b){
        Log.v("","" + seekBar);
        this.valFader = (valore);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {    }




/*    // gestisco il cambio di valore della Seekbar
    public void setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
        //@Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            if(fromUser){
                updateValue(seekBar.getProgress());
            }
        }

        //@Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        //@Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            updateValue(seekBar.getProgress());
        }
    });*/
}
