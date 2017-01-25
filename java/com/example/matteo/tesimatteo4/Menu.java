package com.example.matteo.tesimatteo4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        Button buttonMenuSingle = (Button) findViewById(R.id.btnMenuSingle);
        buttonMenuSingle.setOnClickListener(new View.OnClickListener(){
                                                @Override
                                                public void onClick(View arg0){
                                                    Intent menuToSingle = new Intent(Menu.this, SingleChannels.class);
                                                    startActivity(menuToSingle);
                                                }
                                            }
        );

        Button buttonMenuScenes = (Button) findViewById(R.id.btnMenuScenes);
        buttonMenuScenes.setOnClickListener(new View.OnClickListener(){
                                                @Override
                                                public void onClick(View arg0){
//                                                    Intent menuToScenes = new Intent(Menu.this, Scenes.class);
//                                                    startActivity(menuToScenes);
                                                }
                                            }
        );

        Button buttonMenuStack = (Button) findViewById(R.id.btnMenuStack);
        buttonMenuStack.setOnClickListener(new View.OnClickListener(){
                                               @Override
                                               public void onClick(View arg0){
 //                                                  Intent menuToStack = new Intent(Menu.this, Stack.class);
//                                                   startActivity(menuToStack);
                                               }
                                           }
        );

        Button buttonMenuSave = (Button) findViewById(R.id.btnMenuSave);
        buttonMenuSave.setOnClickListener(new View.OnClickListener(){
                                              @Override
                                              public void onClick(View arg0){
 //                                                 Intent menuToSave = new Intent(Menu.this, SaveShow.class);
 //                                                 startActivity(menuToSave);
                                              }
                                          }
        );

        Button buttonMenuLoad = (Button) findViewById(R.id.btnMenuLoad);
        buttonMenuLoad.setOnClickListener(new View.OnClickListener(){
                                              @Override
                                              public void onClick(View arg0){
  //                                                Intent menuToLoad = new Intent(Menu.this, LoadShow.class);
  //                                                startActivity(menuToLoad);
                                              }
                                          }
        );


    }
}



