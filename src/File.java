public abstract class File extends Resource {
    private final int size;

    protected File(int size, String name, Folder parent) {
        super(name, parent);
        if (size < 0) throw new IllegalArgumentException("File size can not be < 0!");
        if (name == null) throw new IllegalArgumentException("Invalid file name");
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }

    public abstract <R> R accept(ResourceVisitor <R> visitor);
}
