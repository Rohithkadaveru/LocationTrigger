package com.rohithkadaveru.locationtrigger;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by rkadaveru on 2/18/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    private LayoutInflater mLayoutInflator;
    private List<ItemModel> itemData = null;
    private Context mContext;
    private ClickListener mClickListener;

    public RecyclerViewAdapter(Context context, List<ItemModel> itemData) {
        mLayoutInflator = LayoutInflater.from(context);
        mContext = context;
        this.itemData = itemData;
    }

    public void setClickListener(ClickListener clickListener) {
        mClickListener = clickListener;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mLayoutInflator.inflate(R.layout.custom_row, parent, false);
        RecyclerViewHolder mRecyclerViewHolder = new RecyclerViewHolder(view);
        return mRecyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder mRecyclerViewHolder, final int position) {
        ItemModel currentItem = itemData.get(position);
        mRecyclerViewHolder.mLblTriggerAddress.setText(currentItem.address);
        mRecyclerViewHolder.mLblTriggerName.setText(currentItem.triggername);

        mRecyclerViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mClickListener != null) {
                    mClickListener.itemClicked(v, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemData.size();
    }

    protected class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView mLblTriggerName;
        private TextView mLblTriggerAddress;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            mLblTriggerName = (TextView) itemView.findViewById(R.id.tv_triggername);
            mLblTriggerAddress = (TextView) itemView.findViewById(R.id.tv_triggeraddress);
        }
    }

    public interface ClickListener {
        //override itemClicked
        void itemClicked(View view, int position);
    }

}
