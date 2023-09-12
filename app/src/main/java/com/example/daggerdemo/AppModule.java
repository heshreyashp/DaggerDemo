package com.example.daggerdemo;
import dagger.Module;
import dagger.Provides;
import android.content.Context;

@Module
public class AppModule {
    private final Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    Context provideContext() {
        return context;
    }
}
