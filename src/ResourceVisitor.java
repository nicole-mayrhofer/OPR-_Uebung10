public interface ResourceVisitor<R> {
    R visit(Folder folder);
    R visit(SourceFile sourceFile);
    R visit(BinaryFile binaryFile);
}
