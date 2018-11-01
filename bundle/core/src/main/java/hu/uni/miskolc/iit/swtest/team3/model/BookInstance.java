package hu.uni.miskolc.iit.swtest.team3.model;

public class BookInstance {

    private int instanceId;
    private boolean available;
    private Book parent;

    public BookInstance(int instanceId, boolean available, Book parent) {
        this.instanceId = instanceId;
        this.available = available;
        this.parent = parent;
    }

    public int getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(int instanceId) {
        this.instanceId = instanceId;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Book getParent() {
        return parent;
    }

    public void setParent(Book parent) {
        this.parent = parent;
    }
}
