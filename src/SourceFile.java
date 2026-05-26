public class SourceFile extends File {
    BinaryFile binFile;

    public SourceFile(int size) {
        super(size);
    }

    public boolean hasBinfile (SourceFile scr) {
        if (binFile.getSize() != 0) return true;
        else return false;
    }
}
