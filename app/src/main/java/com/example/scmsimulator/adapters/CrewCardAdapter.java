package com.example.scmsimulator.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.scmsimulator.R;
import com.example.scmsimulator.models.CrewMember;

import java.util.List;

public class CrewCardAdapter extends ArrayAdapter<CrewMember> {
    
    public CrewCardAdapter(Context context, List<CrewMember> crew) {
        super(context, 0, crew);
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_crew_card, parent, false);
        }
        
        ImageView portrait = convertView.findViewById(R.id.img_card_portrait);
        TextView nameText = convertView.findViewById(R.id.text_card_name);
        TextView levelText = convertView.findViewById(R.id.text_card_level);
        ProgressBar hpBar = convertView.findViewById(R.id.progress_card_hp);
        ProgressBar energyBar = convertView.findViewById(R.id.progress_card_energy);
        
        CrewMember crew = getItem(position);
        
        if (crew != null) {
            nameText.setText(crew.getName());
            levelText.setText("Lvl " + crew.getLevel() + " " + crew.getRole());
            
            hpBar.setMax(crew.getHealth()); // In a real game, this would be max health. Assuming 100 for now.
            // Let's safe-assume 100 as base until we set maxHealth getters.
            hpBar.setMax(100);
            hpBar.setProgress(crew.getHealth());
            
            energyBar.setMax(crew.getMaxEnergy());
            energyBar.setProgress(crew.getEnergy());
            
            if ("Engineer".equalsIgnoreCase(crew.getRole())) {
                portrait.setImageResource(R.drawable.img_engineer_standing);
            } else if ("Scientist".equalsIgnoreCase(crew.getRole())) {
                portrait.setImageResource(R.drawable.img_scientist_standing);
            } else if ("Soldier".equalsIgnoreCase(crew.getRole())) {
                portrait.setImageResource(R.drawable.img_soldier_standing);
            } else if ("Medic".equalsIgnoreCase(crew.getRole())) {
                portrait.setImageResource(R.drawable.img_medic_standing);
            } else {
                portrait.setImageResource(R.drawable.img_pilot_standing);
            }
        }
        
        return convertView;
    }
}
