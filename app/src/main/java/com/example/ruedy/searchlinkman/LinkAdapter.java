package com.example.ruedy.searchlinkman;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.attr.y;

/**
 * Created by ruedy on 2017/3/13.
 */
public class LinkAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;//上下文
    private LayoutInflater inflater;
    private ArrayList<Person> persons;//人类
    private int index = -1;


    public LinkAdapter(Context mContext, ArrayList<Person> persons) {
        this.mContext = mContext;
        this.persons = persons;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LinkHolder(inflater.inflate(R.layout.linkview, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Person person = persons.get(position);
        String substring = person.getPinyin().substring(0, 1);//这里字母自行拓展

        LinkHolder holder1 = (LinkHolder) holder;

        if (position == 0) {
            holder1.tvTop.setVisibility(View.VISIBLE);
        } else {

            String pinYinq = persons.get(position - 1).getPinyin().substring(0, 1);//这里字母自行拓展
            if (pinYinq.equals(substring)) {
                holder1.tvTop.setVisibility(View.GONE);
            } else {
                holder1.tvTop.setVisibility(View.VISIBLE);
            }

        }

        holder1.tvTop.setText(substring);
        holder1.tvName.setText(person.getName());

    }

    @Override
    public int getItemCount() {
        return persons == null ? 0 : persons.size();
    }

    public void settextvisible(String word) {



    }

    public class LinkHolder extends RecyclerView.ViewHolder {
        private final TextView tvTop;
        private final TextView tvName;

        public LinkHolder(View itemView) {
            super(itemView);
            tvTop = ((TextView) itemView.findViewById(R.id.tv_top));
            tvName = ((TextView) itemView.findViewById(R.id.tv_name));
        }
    }
}
