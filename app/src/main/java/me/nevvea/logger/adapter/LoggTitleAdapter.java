package me.nevvea.logger.adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

import me.nevvea.logger.R;
import me.nevvea.logger.bean.LoggTitle;
import me.nevvea.logger.util.Utilities;

/**
 * Created by Anna on 6/20/16.
 */
public class LoggTitleAdapter extends BaseAbstractRecycleCursorAdapter<RecyclerView.ViewHolder> {
    private final LayoutInflater mLayoutInflater;

    public LoggTitleAdapter(Context context) {
        super(context, null);
        mLayoutInflater = LayoutInflater.from(context);
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, Cursor cursor) {
        LoggTitle loggItem = LoggTitle.fromCursor(cursor);
        ((LoggTitleViewHolder) holder).mTVLoggMonth.setText(Utilities.getMonth(loggItem.month));
        ((LoggTitleViewHolder) holder).mTVLoggDay.setText(loggItem.day + "");
        ((LoggTitleViewHolder) holder).mTVLoggSum.setText(loggItem.title);

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LoggTitleViewHolder(mLayoutInflater.inflate(R.layout.item_logg_titles, parent, false), this);
    }

    public static class LoggTitleViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_logg_month)
        TextView mTVLoggMonth;
        @BindView(R.id.item_logg_day)
        TextView mTVLoggDay;
        @BindView(R.id.item_logg_summary)
        TextView mTVLoggSum;

        LoggTitleAdapter mAdapter;

        public LoggTitleViewHolder(View itemView, LoggTitleAdapter adapter) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mAdapter = adapter;
        }
    }
}
