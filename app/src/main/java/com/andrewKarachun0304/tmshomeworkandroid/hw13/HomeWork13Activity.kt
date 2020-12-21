package com.andrewKarachun0304.tmshomeworkandroid.hw13

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andrewKarachun0304.tmshomeworkandroid.R
import com.andrewKarachun0304.tmshomeworkandroid.hw13.entity.Country
import com.andrewKarachun0304.tmshomeworkandroid.hw13.mappers.SummaryMapper
import com.andrewKarachun0304.tmshomeworkandroid.hw13.retrofit.CovidRetrofitFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class HomeWork13Activity : AppCompatActivity() {
    private lateinit var compositeDisposable: CompositeDisposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_work13)

        compositeDisposable = CompositeDisposable()
        val retrofit = CovidRetrofitFactory.getInstance()

        val disposable = retrofit.getSummaryDataAsync()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { summaryResponse ->
                summaryResponse.countries?.map { countryResponse ->
                        SummaryMapper.summaryMap(countryResponse)
                }
            }
            .subscribe({ countries ->
                parseDate(countries?.get(0)?.date)
                countries?.let { initRecyclerView(countries) }
            }, { ex ->
                Log.e("TAG", ex.localizedMessage.toString())
            })
        compositeDisposable.add(disposable)
    }

    private fun initRecyclerView(countryList: List<Country>) {
        val covidAdapter = CovidAdapter()
        val covidRecyclerView = findViewById<RecyclerView>(R.id.covid_recycler_view)
        covidRecyclerView.apply {
            adapter = covidAdapter
            layoutManager = LinearLayoutManager(this@HomeWork13Activity)
        }
        covidAdapter.updateList(countryList)
    }

    @SuppressLint("SetTextI18n")
    private fun parseDate(date: String?) {
        val pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'"
        val newDate = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val formatter = DateTimeFormatter.ofPattern(pattern)
            val localDate = LocalDate.parse(date, formatter)
            "${localDate.dayOfMonth}:${localDate.monthValue}:${localDate.year}"
        } else {
           TODO()
        }


        val dateTV = findViewById<TextView>(R.id.date_tv)
        dateTV.text = "Date update: $newDate"
    }

    override fun onStop() {
        super.onStop()
        compositeDisposable.dispose()
    }
}