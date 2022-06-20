package com.keneitec.theylonf.soccernewsfamele.data;

import androidx.room.Room;

import com.keneitec.theylonf.soccernewsfamele.App;
import com.keneitec.theylonf.soccernewsfamele.data.local.SoccerNewsDb;
import com.keneitec.theylonf.soccernewsfamele.data.remote.SoccerNewsApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SoccerNewsRepository {
    private static final String REMOTE_URL = "https://digitalinnovationone.github.io/soccer-news-api/";
    private static final String DB_NAME = "soccer-news";

    private SoccerNewsApi remoteApi;
    private SoccerNewsDb localDb;

    public SoccerNewsApi getRemoteApi() {
        return remoteApi;
    }

    public SoccerNewsDb getLocalDb() {
        return localDb;
    }

    private SoccerNewsRepository () {
        remoteApi = new Retrofit.Builder()
                .baseUrl(REMOTE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(SoccerNewsApi.class);

        localDb = Room.databaseBuilder(App.getInstance(), SoccerNewsDb.class, DB_NAME).build();
    }

    public static SoccerNewsRepository getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final SoccerNewsRepository INSTANCE = new SoccerNewsRepository();
    }
}
