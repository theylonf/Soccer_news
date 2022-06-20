package com.keneitec.theylonf.soccernewsfamele.ui.favorites;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.keneitec.theylonf.soccernewsfamele.data.SoccerNewsRepository;
import com.keneitec.theylonf.soccernewsfamele.domain.News;

import java.util.List;

public class FavoritesViewModel extends ViewModel {
    public FavoritesViewModel() {

    }

    public LiveData<List<News>> loadFavoriteNews() {
        return SoccerNewsRepository.getInstance().getLocalDb().newsDao().loadFavoriteNews();
    }

    public void saveNews(News news) {
        AsyncTask.execute(() -> SoccerNewsRepository.getInstance().getLocalDb().newsDao().save(news));
    }
}