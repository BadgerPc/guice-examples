package privatemodule;

import com.google.inject.AbstractModule;
import com.google.inject.PrivateModule;

/**
 * check https://github.com/google/guice/wiki/FrequentlyAskedQuestions
 */
public class MyPrivateModules extends AbstractModule {
    @Override
    protected void configure() {
        install(new PrivateModule() {
            @Override
            protected void configure() {
                // bind MyService annotated as English to MyService PRIVATELY
                bind(MyService.class).annotatedWith(English.class).to(MyService.class);

                // expose MyService annotated as English GLOBALLY. this fulfills injection point (1)
                expose(MyService.class).annotatedWith(English.class);

                // bind MyStrategy to EnglishStrategy PRIVATELY
                bind(MyStrategy.class).to(EnglishStrategy.class);
            }
        });
        install(new PrivateModule() {
            @Override
            protected void configure() {
                // bind MyService annotated as Japanese to MyService PRIVATELY
                bind(MyService.class).annotatedWith(Japanese.class).to(MyService.class);

                // expose MyService annotated as Japanese GLOBALLY. this fulfills injection point (2)
                expose(MyService.class).annotatedWith(Japanese.class);

                // bind MyStrategy to JapaneseStrategy PRIVATELY
                bind(MyStrategy.class).to(JapaneseStrategy.class);
            }
        });
    }
}
