package com.maruf.cmedtask2.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.maruf.cmedtask2.CharactersDetails;
import com.maruf.cmedtask2.R;
import com.maruf.cmedtask2.model.CharactersModel;

import java.util.List;

public class CharactersListAdapter  extends RecyclerView.Adapter<CharactersListAdapter.myviewholder>{
    List<CharactersModel> characterslist;
    Context context;

    public CharactersListAdapter(List<CharactersModel> list) {
        this.characterslist = list;
    }

    public void updatecharacterslist(List<CharactersModel> list) {
        this.characterslist = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowdesign,parent,false);
        context = parent.getContext();
        return new myviewholder(view);

    }


    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.title.setText(characterslist.get(position).getFull_name());
        holder.fatherNameView.setText("Father Name: " + characterslist.get(position).getFather_name());
        Glide.with(holder.title.getContext()).load("https://bdclean.winkytech.com/resources/user/profile_pic/"+characterslist.get(position).getProfile_photo()).into(holder.img);


        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name= characterslist.get(position).getFull_name();
                String fatherName = "Father Name: " + characterslist.get(position).getFather_name();
                String img = characterslist.get(position).getProfile_photo();

                Intent intent = new Intent(context, CharactersDetails.class);
                intent.putExtra("name", name);
                intent.putExtra("fatherName", fatherName);
                intent.putExtra("img", img);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        if(this.characterslist!=null)
            return this.characterslist.size();
        else
            return 0;
    }

    public class myviewholder extends RecyclerView.ViewHolder
    {
        TextView title;
        TextView fatherNameView;
        ImageView img;
        LinearLayout linearLayout;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.titleView);
            fatherNameView=itemView.findViewById(R.id.fatherNameView);
            img=itemView.findViewById(R.id.imageView);
            linearLayout=itemView.findViewById(R.id.ll);
        }
    }
}
