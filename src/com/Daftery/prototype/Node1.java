/*
 * License : 
 * This code is free for all to use and distribute as they please.
 */

package com.Daftery.prototype;

import java.io.File;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class Node1 extends Activity {
	private Button child1;
	/* These buttons haven't been used, link them*/
	private Button child2;
	private Button child3;
	private Button child4;
	/* Unused buttons end here*/
	private Button leaf1;
	private Button leaf2;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.child1);
        child1= (Button) findViewById(R.id.child1);
        leaf1 = (Button) findViewById(R.id.leaf1);
        leaf2 = (Button) findViewById(R.id.leaf2);
        setchild1action(child1);
        setleaf1action(leaf1);
        setleaf2action(leaf2);
    }

    private void setchild1action(Button school)
    {
    	school.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if(((ImageView) findViewById(R.id.child1subframe)).getVisibility() == ImageView.INVISIBLE)
				{((ImageView) findViewById(R.id.child1subframe)).setVisibility(ImageView.VISIBLE);
				leaf1.setVisibility(Button.VISIBLE);
				leaf2.setVisibility(Button.VISIBLE);
				}
				else
				{
					((ImageView) findViewById(R.id.child1subframe)).setVisibility(ImageView.INVISIBLE);
					leaf1.setVisibility(Button.INVISIBLE);
					leaf2.setVisibility(Button.INVISIBLE);
				}
			}
        });
    }

    private void setleaf1action(Button leaf1)
    {
    	leaf1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				File file = new File("/mnt/sdcard/leaf1.pdf");

                if (file.exists()) {
                	Toast.makeText(getApplicationContext(), "Found",Toast.LENGTH_SHORT).show();
                    Uri path = Uri.fromFile(file);
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setDataAndType(path, "application/pdf");
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                    try {
                        startActivity(intent);
                    } 
                    catch (ActivityNotFoundException e) {
                        Toast.makeText(getApplicationContext(), "No Application Available to View PDF",Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                	Toast.makeText(getApplicationContext(), "Not Found",Toast.LENGTH_SHORT).show();	
                }

			}
			
    	});
    	}

    private void setleaf2action(Button leaf2)
    {
    	leaf2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				File file = new File("/mnt/sdcard/leaf2.pdf");

                if (file.exists()) {
                	Toast.makeText(getApplicationContext(), "Found",Toast.LENGTH_SHORT).show();
                    Uri path = Uri.fromFile(file);
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setDataAndType(path, "application/pdf");
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                    try {
                        startActivity(intent);
                    } 
                    catch (ActivityNotFoundException e) {
                        Toast.makeText(getApplicationContext(), "No Application Available to View PDF",Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                	Toast.makeText(getApplicationContext(), "Not Found",Toast.LENGTH_SHORT).show();	
                }

			}
			
    	});
    	}

    
}
