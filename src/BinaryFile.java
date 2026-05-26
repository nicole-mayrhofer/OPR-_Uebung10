public class BinaryFile extends File {
    SourceFile srcfile;

    public BinaryFile(int size, SourceFile srcfile) {
        if (srcfile == null) throw new RuntimeException ("no SourceFile found");
        super(size);
    }
}
