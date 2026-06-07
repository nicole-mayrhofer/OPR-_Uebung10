import java.util.Objects;

public abstract class Resource {
    private final String name;
    private final Folder parent;

    public abstract <R> R accept(ResourceVisitor <R> visitor);


    public Resource(String name, Folder parent) {
        this.name = name;
        this.parent = parent;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Resource r)) return false;
        return Objects.equals(r.name, name) && Objects.equals(r.parent, parent);
    }

    public String getName () {
        return this.name;
    }

    public Folder getParent () {
        return this.parent;
    }

}

