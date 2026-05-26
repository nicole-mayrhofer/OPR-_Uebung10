public interface ResourcesVisitor<R> {
    R visit(Folder folder);
    R visit(File file);
    R visit(SourceFile sourceFile);
    R visit(BinaryFile binaryFile);
}
