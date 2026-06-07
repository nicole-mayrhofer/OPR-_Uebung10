import java.util.ArrayList;
import java.util.List;

public class Folder extends Resource {
    private List<Resource> children;


    public Folder(String name, Folder parent) {
        super(name, parent);
        this.children = new ArrayList<>();
    }

    public void addChild (Resource child) {
        children.add(child);
    }

    public List<Resource> getChildren () {
        return this.children;
    }

    @Override
    public <R> R accept(ResourceVisitor<R> visitor) {
        R all = visitor.visit(this);
        for (Resource child : children) {
            child.accept(visitor);
        }
        return all;
    }

}
