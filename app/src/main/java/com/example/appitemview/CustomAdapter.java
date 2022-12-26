package com.example.appitemview;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Avenger>
{
    Context context; //for reference to the activity
    int resource; // for design of list
    ArrayList<Avenger> list; // for particular information

    // constructor
    CustomAdapter(Context context,int resource,ArrayList<Avenger> list){
        super(context,resource,list); // super will call parents class
        // data save karva mate
        this.context = context;
        this.resource = resource;
        this.list = list;
    }

    //getView() method will be called automatically by ArrayAdapter class as per number of records in list
    //as we have passed list as parameter in super(context,resource,list);

    @Override
    public View getView(final int position, View convetView, ViewGroup parent){
        View view = null;

        //position ni value jetli var call karse a rite badlase

        //non-activity class ma design pakdva
        LayoutInflater inflater = LayoutInflater.from(context);

        view = inflater.inflate(resource,null,false);

        ImageView iv = view.findViewById(R.id.imageView);
        TextView tvName = view.findViewById(R.id.textViewName);
        TextView tvWeapon = view.findViewById(R.id.textViewWeap);
        Button btDel = view.findViewById(R.id.buttonDelete);

        Avenger av = list.get(position); // peli vaar pelo record am jetli vaar call thase atli vaar alag alag recor dapse

        btDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //delete mate
                showDialog(position); // dialog box ne call karse
            }
        });

        iv.setImageDrawable(context.getResources().getDrawable(av.getImage())); // img lidhi
        tvName.setText(av.getName());
        tvWeapon.setText(av.getWeapon());

        return view;
    }

    //dialog box mate
    void showDialog(int position){
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);

        dialog.setTitle("Are you sure, you want to Delete this item ?"); // message

        //yes nu button and ana par click kare atle method call thase
        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                //it removes data from arraylist only
                list.remove(position); // a khali list mathi thase ani effect list view (front end) ma nai ave ana mate method call karvi pade
                notifyDataSetChanged();//it actually removes deleted record from listview
            }
        });

        dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog alt = dialog.create(); // create karse
        dialog.show(); //show thase
    }

}


//pojo
//arraylist ma data store karya
//design tayyar kati list view mate
//custom adapter
