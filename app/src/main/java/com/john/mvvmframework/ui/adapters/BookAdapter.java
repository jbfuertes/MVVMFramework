package com.john.mvvmframework.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.john.mvvmframework.R;
import com.john.mvvmframework.model.ui_response.BookUiModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by john on 3/9/18.
 */

public class BookAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<BookUiModel.BookDate> bookDates;

    public BookAdapter(List<BookUiModel.BookDate> bookDates){
        this.bookDates = bookDates;

    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MainViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.row_book_dates,parent,false));
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return null==bookDates?0:bookDates.size();
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    public void setItemList(List<BookUiModel.BookDate> bookDates){
        this.bookDates = bookDates;
    }



    private class FailedViewHolder extends BaseViewHolder {

        FailedViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        protected void clear() {

        }
    }

    class MainViewHolder extends BaseViewHolder {

        @BindView(R.id.checkInTime)
        TextView checkInTime;

        @BindView(R.id.checkOutTime)
        TextView checkOutTime;

        @BindView(R.id.user)
        TextView user;

        MainViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        @Override
        protected void clear() {

        }

        @Override
        public void onBind(int position) {
            super.onBind(position);

            BookUiModel.BookDate bookDate = bookDates.get(position);

            user.setText(bookDate.user);

            checkInTime.setText(bookDate.bookTime);

            checkOutTime.setText(bookDate.checkOutTime);

        }
    }

}
