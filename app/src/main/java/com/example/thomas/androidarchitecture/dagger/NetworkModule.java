package com.example.thomas.androidarchitecture.dagger;

import com.example.thomas.androidarchitecture.network.GithubWebService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class NetworkModule {

    private final String GITHUB_BASE_URL = "https://api.github.com/";

    @Provides
    @Singleton
    GithubWebService provideGithubWebService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GITHUB_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(GithubWebService.class);
    }


}
