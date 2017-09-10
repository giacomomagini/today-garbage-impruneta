package garu.chesibuttastaseraadimpruneta.app.dagger;

import com.google.gson.Gson;

import dagger.Module;
import dagger.Provides;

/**
 * Created by garu on 08/09/17.
 */

@Module
public class CommonsModule {

    @Provides
    public Gson provideGson(){
        return new Gson();
    }

}
