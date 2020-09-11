package com.coursework.opencvtest.api;

import com.coursework.opencvtest.todo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    
    @GET("/todos")
    Call<List<todo>> getTodos();

    @GET("/todos/{id}")
    Call<todo> getTodo(@Path("id") int id);

    @GET("/todos")
    Call<List<todo>> getTodosUsingQuery(@Query("userId") int id, @Query("completed") boolean completed);

    @POST("/todos")
    Call<todo> postTodo(@Body todo Todo);



}
