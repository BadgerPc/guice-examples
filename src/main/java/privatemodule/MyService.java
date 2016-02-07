package privatemodule;

import javax.inject.Inject;

public class MyService {
    private final MyStrategy myStrategy;

    @Inject
    MyService(final MyStrategy myStrategy) {
        this.myStrategy = myStrategy;
    }

    public String greetings() {
        return myStrategy.sayHello();
    }
}
