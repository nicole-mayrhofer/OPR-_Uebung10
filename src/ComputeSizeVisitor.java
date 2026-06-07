public class ComputeSizeVisitor implements ResourceVisitor<Integer>{

    private boolean includeBinary;
    private int totalSize = 0;

    public ComputeSizeVisitor(boolean includeBinary) {
        this.includeBinary = includeBinary;
    }

    @Override
    public Integer visit(Folder folder) {
        return totalSize;
    }

    @Override
    public Integer visit(SourceFile sourceFile) {
        totalSize += sourceFile.getSize();
        return totalSize;
    }

    @Override
    public Integer visit(BinaryFile binaryFile) {
        if (includeBinary) {
            totalSize += binaryFile.getSize();
        }
        return totalSize;
    }

    public int getTotalSize() {
        return totalSize;
    }

}
