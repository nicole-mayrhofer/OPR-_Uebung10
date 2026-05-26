public abstract class Resources implements ResourcesVisitor {
    String name;
    Folder parent;
    public abstract <R> R accept(ResourcesVisitor <R> visitor);


    public Resources(String name, Folder parent) {
        this.name = name;
        this.parent = parent;
    }

    public boolean isEqual(Resources resources) {
        if (resources.name == name && resources.parent == parent) {
            return true;
        }
        return false;
    }
}

