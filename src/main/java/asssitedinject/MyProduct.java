package asssitedinject;

import com.google.inject.assistedinject.Assisted;

import javax.inject.Inject;

public class MyProduct {

    private final String name;
    private final MyCollaborator collaborator;

    @Inject
    MyProduct(@Assisted final String name, final MyCollaborator collaborator) {
        this.name = name;
        this.collaborator = collaborator;
    }

    public String greetings() {
        return collaborator.sayHello() + ", " + name;
    }
}
