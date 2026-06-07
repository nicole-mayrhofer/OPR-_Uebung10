public class CompileVisitor implements ResourceVisitor <Void> {

    @Override
    public Void visit(SourceFile sourceFile) {
        if (sourceFile.getBinaryFile() == null) {
            BinaryFile bin = new BinaryFile (sourceFile.getSize()*2, sourceFile.getName() + ".binary", sourceFile.getParent(), sourceFile);
            sourceFile.getParent().addChild(bin);
            sourceFile.setBinaryFile(bin);
        }
        return null;
    }

    @Override
    public Void visit(Folder folder) {
        return null;
    }

    @Override
    public Void visit(BinaryFile binaryFile) {
        return null;
    }
}
