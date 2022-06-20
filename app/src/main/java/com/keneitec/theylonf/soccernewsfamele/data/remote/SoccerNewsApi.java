package com.keneitec.theylonf.soccernewsfamele.data.remote;

import com.keneitec.theylonf.soccernewsfamele.domain.News;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SoccerNewsApi {
    @GET("news.json")
    Call<List<News>> getNews();
}
