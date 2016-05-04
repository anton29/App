package com.example.u1.button;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by U1 on 4/28/2016.
 */
public class AdapterContact extends ArrayAdapter<Contact> {
    private Activity activity;
    private ArrayList<Contact> lContact;
    private static LayoutInflater inflater = null;
    boolean[] checkBoxState;

    public AdapterContact (Activity activity, int textViewResourceId,ArrayList<Contact> _lContact) {
        super(activity, textViewResourceId, _lContact);
        try {
            this.activity = activity;
            this.lContact = _lContact;

            checkBoxState=new boolean[_lContact.size()];
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        } catch (Exception e) {

        }
    }

    public int getCount() {
        return lContact.size();
    }

    public Contact getItem(Contact position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public static class ViewHolder {
        public TextView display_name;
        public TextView display_number;
        CheckBox checkBox;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        final ViewHolder holder;
        try {
            if (convertView == null) {
                vi = inflater.inflate(R.layout.contact_layout, null);
                holder = new ViewHolder();

                holder.display_name = (TextView) vi.findViewById(R.id.display_name);
                holder.display_number = (TextView) vi.findViewById(R.id.display_number);
                holder.checkBox=(CheckBox) vi.findViewById(R.id.checkBox);


                vi.setTag(holder);
            } else {
                holder = (ViewHolder) vi.getTag();
            }



            holder.display_name.setText(lContact.get(position).name);
            holder.display_number.setText(lContact.get(position).phone);
            holder.checkBox.setChecked(checkBoxState[position]);


            //for managing the state of the boolean
            //array according to the state of the
            //CheckBox

            holder.checkBox.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    if(((CheckBox)v).isChecked()) {
                        checkBoxState[position] = true;
                        Log.v("msg",lContact.get(position).name + lContact.get(position).phone);
                    } else
                        checkBoxState[position]=false;

                }
            });


        } catch (Exception e) {


        }
        return vi;
    }
}
