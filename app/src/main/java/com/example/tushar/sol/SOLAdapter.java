package com.example.tushar.sol;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Tushar on 15-12-2016.
 */
public class SOLAdapter extends ArrayAdapter<SOL> {

    Context context;
    ArrayList<SOL> arrayList;

    public SOLAdapter(Context context, ArrayList<SOL> list) {
        super(context,0,list);
        this.context = context;
        this.arrayList = list;
    }

    public class ViewHolder {
        TextView roll;
        TextView tele;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = View.inflate(context, R.layout.adapterlayout, null);

            ViewHolder vh = new ViewHolder();

            vh.roll = (TextView) convertView.findViewById(R.id.text_roll);
            vh.tele = (TextView) convertView.findViewById(R.id.tele);


            convertView.setTag(vh);

        }

        ViewHolder vh = (ViewHolder) convertView.getTag();

        SOL c = arrayList.get(position);

        vh.roll.setText(c.getRoll());
        vh.tele.setText(c.getTele());




        return convertView;
    }





}
