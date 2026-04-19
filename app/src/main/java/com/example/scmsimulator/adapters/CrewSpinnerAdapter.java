package com.example.scmsimulator.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.scmsimulator.R;
import com.example.scmsimulator.models.CrewMember;
import java.util.List;

public class CrewSpinnerAdapter extends ArrayAdapter<CrewMember> {
    
    public CrewSpinnerAdapter(Context context, List<CrewMember> crew) {
        super(context, 0, crew);
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return initView(position, convertView, parent);
    }
    
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return initView(position, convertView, parent);
    }
    
    private View initView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_crew_spinner, parent, false);
        }
        
        ImageView portrait = convertView.findViewById(R.id.img_spinner_portrait);
        TextView nameText = convertView.findViewById(R.id.text_spinner_name);
        TextView detailsText = convertView.findViewById(R.id.text_spinner_details);
        
        CrewMember crew = getItem(position);
        
        if (crew == null) {
            portrait.setVisibility(View.GONE);
            nameText.setText("-- None --");
            detailsText.setText("");
            detailsText.setVisibility(View.GONE);
        } else {
            portrait.setVisibility(View.VISIBLE);
            detailsText.setVisibility(View.VISIBLE);
            nameText.setText(crew.getName());
            detailsText.setText(crew.getRole() + " - Lvl " + crew.getLevel() + " - HP: " + crew.getHealth());
            
            if ("Engineer".equalsIgnoreCase(crew.getRole())) {
                portrait.setImageResource(R.drawable.img_engineer_standing);
            } else if ("Scientist".equalsIgnoreCase(crew.getRole())) {
                portrait.setImageResource(R.drawable.img_scientist_standing);
            } else if ("Soldier".equalsIgnoreCase(crew.getRole())) {
                portrait.setImageResource(R.drawable.img_soldier_standing);
            } else if ("Medic".equalsIgnoreCase(crew.getRole())) {
                portrait.setImageResource(R.drawable.img_medic_standing);
            } else {
                // Default or Pilot
                portrait.setImageResource(R.drawable.img_pilot_standing);
            }
        }
        
        return convertView;
    }
}
