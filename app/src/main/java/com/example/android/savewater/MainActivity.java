package com.example.android.savewater;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.activity_main);

    }
    /*
     * This Method navigate to OtherUse activity that display a list of other uses of water
     */
    public void otherWaterUses(View v)
    {
        Intent intent = new Intent(MainActivity.this,OtherUse.class);
        startActivity(intent);

    }
    /*
    * This Method navigate to CriticalSaveWater activity that display an information about why it is critical to save water
    */
    public void criticalSaveWater(View v)
    {
        Intent intent = new Intent(MainActivity.this,CriticalSaveWater.class);
        startActivity(intent);
    }

    /*
   * This Method display a popupMenu that shows category that allows a user to touch on one item
   * per time and navigate to the appropriate activity based on the selected category
   */
    public void savingWaterTips(View button)
    {
        PopupMenu popup = new PopupMenu(this,button);
        popup.getMenuInflater().inflate(R.menu.tips_menu, popup.getMenu());

        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item)
            {

                if (item.getItemId() == R.id.kitchen) {
                    Intent intentKitchen = new Intent(MainActivity.this, kitchen_tips.class);
                    startActivity(intentKitchen);
                    return true;
                } else if (item.getItemId() == R.id.bathroom) {
                    Intent intentBath = new Intent(MainActivity.this, BathLaundry.class);
                    startActivity(intentBath);
                    return true;
                } else if (item.getItemId() == R.id.work) {
                    Intent intentWork = new Intent(MainActivity.this, work.class);
                    startActivity(intentWork);
                    return true;
                } else if (item.getItemId() == R.id.outdoor) {
                    Intent intentOutdoor = new Intent(MainActivity.this,outdoors.class);
                    startActivity(intentOutdoor);
                    return true;
                }

                return true;
            }
        });

        popup.show();
    }

}
