public class BinaryFile extends File {
    private SourceFile srcFile;

    protected BinaryFile(int size, String name, Folder parent, SourceFile srcFile) {
        super(size, name, parent);
        if (srcFile == null) throw new IllegalArgumentException("No source file found");
        this.srcFile = srcFile;
    }

    public SourceFile getSource() {
        return this.srcFile;
    }

    public void setSource(SourceFile srcFile) {
        this.srcFile = srcFile;
    }

    @Override
    public <R> R accept(ResourceVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
