package com.madhumankatha.kuvempuuniv.retrofit;

import com.madhumankatha.kuvempuuniv.model.Event;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AppApi {

    @GET("/app/events.php")
    Call<List<Event>> getEventsList();

    @GET("/app/documents.php")
    Call<List<Event>> getDocumentsList();

    @GET("/app/ebooks.php")
    Call<List<Event>> getEbooksList();

    @GET("/app/earticles.php")
    Call<List<Event>> getEArticles();

    @GET("/app/eqbook.php")
    Call<List<Event>> getEQBook();
}
