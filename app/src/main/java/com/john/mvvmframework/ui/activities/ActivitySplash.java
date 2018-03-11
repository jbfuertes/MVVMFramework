package com.john.mvvmframework.ui.activities;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.jakewharton.rxbinding2.view.RxView;
import com.jakewharton.rxbinding2.widget.RxTextView;
import com.john.mvvmframework.R;
import com.john.mvvmframework.model.ui_request.BookEvent;
import com.john.mvvmframework.model.ui_request.CheckTimeEvent;
import com.john.mvvmframework.model.ui_request.SubmitEvent;
import com.john.mvvmframework.ui.adapters.BookAdapter;
import com.john.mvvmframework.ui.views.SplashView;
import com.john.mvvmframework.utils.AppConstants;
import com.john.mvvmframework.utils.TimeUtils;
import com.john.mvvmframework.view_model.SplashHandler;

import java.util.ArrayList;
import java.util.Calendar;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import timber.log.Timber;


public class ActivitySplash extends BaseActivity implements SplashView {


    @Inject
    SplashHandler handler;

    @BindView(R.id.reserveBtn)
    Button reserveBtn;

    @BindView(R.id.reserveTime)
    TextView reserveTime;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.checkOutTime)
    TextView checkOutTime;

    @BindView(R.id.user)
    EditText user;

    private BookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO:
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        getActivityComponent().inject(this);

        setUp();
    }


    @Override
    protected void setUp() {
        textViewSetUp();
        recyclerViewSetUp();
        getCompositeDisposable().add(mergeEvent()
                .compose(handler.bookEvent())
                .subscribe(model -> {
                    if (model.errorMessage!=null){
                        showMessage(model.errorMessage);
                    }

                    reserveBtn.setEnabled(!model.inProgress&&model.errorMessage==null);

                    adapter.setItemList(model.bookDates);

                    adapter.notifyDataSetChanged();

                    progressBar.setVisibility(model.inProgress? View.VISIBLE:View.GONE);


                }));
    }

    private void textViewSetUp(){
        getCompositeDisposable().add(RxView.clicks(reserveTime)
                .subscribe(__ -> showDatePicker(reserveTime)));

        getCompositeDisposable().add(RxView.clicks(checkOutTime)
                .subscribe(__ -> showDatePicker(checkOutTime)));

    }

    private void showDatePicker(TextView textView){
        final Calendar c = Calendar.getInstance();
        int yr = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int min = c.get(Calendar.MINUTE);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                (view, year, monthOfYear, dayOfMonth) -> {
                    TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                            (view1, hourOfDay, minute) ->
                                    textView.setText(TimeUtils.getDate(
                                            AppConstants.DATE_FORMAT_3,
                                            year,
                                            monthOfYear,
                                            dayOfMonth,
                                            hourOfDay,
                                            minute)), hour, min, false);
                    timePickerDialog.show();
                }, yr, month, day);
        datePickerDialog.show();
    }

    private void showTimePicker(TextView textView){
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int min = c.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                (view1, hourOfDay, minute) ->
                        textView.setText(TimeUtils.getTime(
                                AppConstants.DATE_FORMAT_7,
                                hourOfDay,
                                minute)),
                hour, min, true);
        timePickerDialog.show();
    }

    private void recyclerViewSetUp(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new BookAdapter(new ArrayList<>());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }

    private Observable<BookEvent> mergeEvent(){
        return Observable.merge(
                checkTimeEvent(),
                submitEvent());
    }

    private Observable<CheckTimeEvent> checkTimeEvent(){
        return Observable.combineLatest(
                RxTextView.textChanges(reserveTime)
                        .skipInitialValue()
                        .filter(s -> !s.toString().isEmpty()),
                RxTextView.textChanges(checkOutTime)
                        .skipInitialValue()
                        .filter(s -> !s.toString().isEmpty()),
                (s,s1) -> new CheckTimeEvent(s.toString(),s1.toString()));

    }

    private Observable<SubmitEvent> submitEvent(){
        return RxView.clicks(reserveBtn)
                .map(__ -> new SubmitEvent(
                        reserveTime.getText().toString(),
                        checkOutTime.getText().toString(),
                        user.getText().toString()));
    }


}
