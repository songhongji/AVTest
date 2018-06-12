package com.example.songhongji.avtest;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.songhongji.avtest.picture.PictureActivity;

import java.util.ArrayList;
import java.util.List;

public class AVListAdapter extends RecyclerView.Adapter<AVListAdapter.AVViewHolder> {

    private static List<String> names = new ArrayList<>();

    static {
        names.add(Constants.PICTURE);
        names.add(Constants.VIDEO);
        names.add(Constants.AUDIO);
    }

    @NonNull
    @Override
    public AVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_av_list, parent, false);
        return new AVViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AVViewHolder holder, int position) {
        String name = names.get(position);

        if (TextUtils.isEmpty(name)) {
            return;
        }

        if (holder.nameTv == null) {
            return;
        }

        holder.nameTv.setText(name);
        bindActions(name, holder.nameTv);
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    static class AVViewHolder extends RecyclerView.ViewHolder {

        TextView nameTv;

        public AVViewHolder(View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.name_item_tv);
        }
    }


    private void bindActions(@NonNull final String name, @NonNull final TextView textView) {
        switch (name) {
            case Constants.PICTURE:
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(textView.getContext(), PictureActivity.class);
                        textView.getContext().startActivity(intent);
                    }
                });
                break;
            case Constants.VIDEO:
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(textView.getContext(), name, Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case Constants.AUDIO:

                break;
            default:
                break;
        }
    }
}
