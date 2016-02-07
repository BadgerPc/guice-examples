package asssitedinject;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;

public class MyAssistedInjectModule extends AbstractModule {
    @Override
    protected void configure() {
        install(new FactoryModuleBuilder().build(MyFactory.class));
    }
}
