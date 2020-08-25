package com.madhumankatha.kuvempuuniv.viewmodels;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.madhumankatha.kuvempuuniv.model.Event;
import com.madhumankatha.kuvempuuniv.retrofit.AppApi;
import com.madhumankatha.kuvempuuniv.retrofit.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AppViewModel extends ViewModel {

    private MutableLiveData<List<Event>> eventsList;
    private MutableLiveData<List<Event>> earticleList;
    private MutableLiveData<List<Event>> eqbookList;
    private MutableLiveData<List<Event>> edocumentList;
    private MutableLiveData<List<Event>> ebooksList;
    private AppApi appApi = RetrofitService.createService(AppApi.class);
    private Context context;

    public LiveData<List<Event>> getEventsList(){
        if (eventsList == null){
            eventsList = new MutableLiveData<List<Event>>();
            loadEventsList();
        }
        return eventsList;
    }

    public LiveData<List<Event>> getEArticlesList(){
        if (earticleList == null){
            earticleList = new MutableLiveData<List<Event>>();
            loadEArticlesList();
        }
        return earticleList;
    }

    public LiveData<List<Event>> getEQBookList(){
        if (eqbookList == null){
            eqbookList = new MutableLiveData<List<Event>>();
            loadEQBookList();
        }
        return eqbookList;
    }

    public LiveData<List<Event>> getEBookList(){
        if (ebooksList == null){
            ebooksList = new MutableLiveData<List<Event>>();
            loadEBookList();
        }
        return ebooksList;
    }

    public LiveData<List<Event>> getEDocumentsList(){
        if (edocumentList == null){
            edocumentList = new MutableLiveData<List<Event>>();
            loadEDocument();
        }
        return edocumentList;
    }

    private void loadEventsList(){
        appApi.getEventsList().enqueue(new Callback<List<Event>>() {
            @Override
            public void onResponse(Call<List<Event>> call, Response<List<Event>> response) {
                if (response.isSuccessful()){
                    eventsList.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Event>> call, Throwable t) {
                //Toast.makeText(context, "Check Internet!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadEArticlesList(){
        appApi.getEArticles().enqueue(new Callback<List<Event>>() {
            @Override
            public void onResponse(Call<List<Event>> call, Response<List<Event>> response) {
                if (response.isSuccessful()){
                    earticleList.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Event>> call, Throwable t) {
                //Toast.makeText(context, "Check Internet!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadEQBookList(){
        appApi.getEQBook().enqueue(new Callback<List<Event>>() {
            @Override
            public void onResponse(Call<List<Event>> call, Response<List<Event>> response) {
                if (response.isSuccessful()){
                    eqbookList.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Event>> call, Throwable t) {
                //Toast.makeText(context, "Check Internet!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadEBookList(){
        appApi.getEbooksList().enqueue(new Callback<List<Event>>() {
            @Override
            public void onResponse(Call<List<Event>> call, Response<List<Event>> response) {
                if (response.isSuccessful()){
                    ebooksList.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Event>> call, Throwable t) {
                //Toast.makeText(context, "Check Internet!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadEDocument(){
        appApi.getDocumentsList().enqueue(new Callback<List<Event>>() {
            @Override
            public void onResponse(Call<List<Event>> call, Response<List<Event>> response) {
                if (response.isSuccessful()){
                    edocumentList.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Event>> call, Throwable t) {
                //Toast.makeText(context, "Check Internet!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
