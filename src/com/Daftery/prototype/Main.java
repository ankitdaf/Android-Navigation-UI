/*
 * License : 
 * This code is free for all to use and distribute as they please.
 */


package com.Daftery.prototype;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Main extends Activity {
	private LinearLayout ll;
	private Button show ;
	private ImageView iv;
	private Button node1;
	private boolean isshowingtree = false;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        show = (Button) findViewById(R.id.home);
        iv = (ImageView) findViewById(R.id.treeframe);
        ll = (LinearLayout) findViewById(R.id.restoftree);
        node1 = (Button) findViewById(R.id.node1);
        setshowaction(show);
        setnodeaction(node1);
    }

    private void setshowaction(Button show)
    {
    	show.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				
				/* Consider replacing this flag by using a ToggleButton
				 * instead of an ImageButton
				 */
				if(isshowingtree)
				{
				iv.setVisibility(ImageView.INVISIBLE);
				ll.setVisibility(LinearLayout.INVISIBLE);
				isshowingtree=false;
				}
				else
				{
					iv.setVisibility(ImageView.VISIBLE);
					ll.setVisibility(LinearLayout.VISIBLE);
					isshowingtree=true;
				}
			}
        });
    }

    private void setnodeaction(Button node)
    {
    	node.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent myIntent = new Intent(Main.this, Node1.class);
				Main.this.startActivity(myIntent);
			}
        });
    }


}
