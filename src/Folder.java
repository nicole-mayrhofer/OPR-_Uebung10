import java.util.List;

public abstract class Folder extends Resources {
    List<Resources> child;

    @Override
    public <R> R accept(ResourcesVisitor<R> visitor) {
        return visitor.visit(this);
    }

    public Folder(String name, Folder parent) {
        super(name, parent);
    }
}
