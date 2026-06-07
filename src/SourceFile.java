public class SourceFile extends File {
    private BinaryFile binFile;


    protected SourceFile(int size, String name, Folder parent) {
        super(size, name, parent);
    }

    public BinaryFile getBinaryFile() {
        return this.binFile;
    }

    public void setBinaryFile(BinaryFile binFile) {
        this.binFile = binFile;
    }


    @Override
    public <R> R accept(ResourceVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
