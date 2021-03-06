package com.example.a33consumowebrecycler;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class CardListAdapter extends RecyclerView.Adapter<CardListAdapter.MyViewHolder> {

    private Context context;
    private List<Item> list;

    public CardListAdapter(Context context, List<Item> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_list_item, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int i) {

        final Item item = list.get(i);
        myViewHolder.nombreAlumno.setText(item.getName());
        myViewHolder.noControl.setText(item.getNoControl());
        myViewHolder.cel.setText(item.getCel());
        myViewHolder.carrera.setText(item.getCarrera());
        myViewHolder.u3.setText(item.getU3());

        int intU1 = Integer.parseInt(myViewHolder.cel.getText().toString());
        int intU2 = Integer.parseInt(myViewHolder.carrera.getText().toString());
        int intU3 = Integer.parseInt(myViewHolder.u3.getText().toString());

        color(intU1, intU2, intU3, myViewHolder);

//        myViewHolder.imagen.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Snackbar snackbar = Snackbar.make(myViewHolder.frameLayout, "Eliminar a: "+myViewHolder.noControl.getText().toString(), -15);
//                snackbar.setAction("ELIMINAR", new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        removeItem(i);
//                    }
//                });
//                snackbar.setActionTextColor(Color.WHITE);
//                snackbar.show();
//            }
//        });

    }

    private void color(int intU1, int intU2, int intU3, MyViewHolder myViewHolder) {

        if (intU1 >= 70 && intU2 >= 70 && intU3 >= 70){
            myViewHolder.viewForeground.setBackgroundColor(Color.parseColor("#FF4CAF50")); //Verde
        }else{
            if (intU1 < 70 && intU2 < 70 && intU3 <70){
                myViewHolder.viewForeground.setBackgroundColor(Color.parseColor("#F2826A")); //

            }else {
                myViewHolder.viewForeground.setBackgroundColor(Color.parseColor("#FFFFEB3B")); //Amarillo
            }
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void removeItem(int posicion){
        list.remove(posicion);
        notifyItemRemoved(posicion);
        notifyItemRangeChanged(posicion, list.size());
    }

    public void restoreItem(Item item, int posicion){
        list.add(posicion, item);
        notifyItemInserted(posicion);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView nombreAlumno, noControl, cel,  carrera, u3;
        public ImageView imagen;
        public RelativeLayout viewBackgroud, viewForeground;
        public FrameLayout frameLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            frameLayout = itemView.findViewById(R.id.frame);
            nombreAlumno = itemView.findViewById(R.id.nombreAlumno);
            noControl = itemView.findViewById(R.id.noControl);
            cel = itemView.findViewById(R.id.cel);
            carrera = itemView.findViewById(R.id.carrera);
            u3 = itemView.findViewById(R.id.u3);
            imagen = itemView.findViewById(R.id.thumbnail);
            viewBackgroud = itemView.findViewById(R.id.view_background);
            viewForeground = itemView.findViewById(R.id.view_foreground);
        }
    }

}
