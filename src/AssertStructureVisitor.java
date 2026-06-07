import java.util.ArrayList;
import java.util.List;

public class AssertStructureVisitor implements ResourceVisitor <Boolean> {

    private List<Resource> visited = new ArrayList<Resource>();
    private boolean isRoot = false;

    @Override
    public Boolean visit(Folder folder) {
        if (visited.contains(folder)) {
            throw new AssertionException ("Folder already visited", folder);
        }
        visited.add(folder);

        for (Resource child : folder.getChildren()) {
            if (!child.getParent().equals(folder)) {
                throw new AssertionException ("Parent inconsistent", child);
            }
        }

        if (folder.getParent() == null) {
            if (isRoot) {
                throw new AssertionException("Multiple root folders found", folder);
            }
            isRoot = true;
        }

        return true;
    }


    @Override
    public Boolean visit(SourceFile sourceFile) {
        if (visited.contains(sourceFile)) {
            throw new AssertionException("SourceFile already visited", sourceFile);
        }
        visited.add(sourceFile);

        if (sourceFile.getParent() == null) {
            throw new AssertionException("SourceFile has no parent", sourceFile);
        }

        return true;
    }


    @Override
    public Boolean visit(BinaryFile binaryFile) {
        if (visited.contains(binaryFile)) {
            throw new AssertionException("BinaryFile already visited", binaryFile);
        }
        visited.add(binaryFile);

        if (binaryFile.getParent() == null) {
            throw new AssertionException("BinaryFile has no parent", binaryFile);
        }

        if (binaryFile.getSource() == null) {
            throw new AssertionException("BinaryFile has no source", binaryFile);
        }
        if (!binaryFile.getSource().getParent().equals(binaryFile.getParent())) {
            throw new AssertionException("BinaryFile and SourceFile not in same folder", binaryFile);
        }
        return true;
    }
}
