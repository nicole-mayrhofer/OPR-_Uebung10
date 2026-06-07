public class AssertionException extends RuntimeException {
    private final Resource resource;

    public AssertionException(String message, Resource resource) {
        super(message);
        this.resource = resource;
    }
    public Resource getResource() {
        return resource;
    }
}