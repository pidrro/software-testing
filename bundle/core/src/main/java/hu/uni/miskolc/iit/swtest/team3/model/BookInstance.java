package hu.uni.miskolc.iit.swtest.team3.model;

public class BookInstance {

    private int instanceId;
    private boolean avaliable;
    private Book parent;

    public BookInstance(int instanceId, boolean avaliable, Book parent) {
        this.instanceId = instanceId;
        this.avaliable = avaliable;
        this.parent = parent;
    }

    public int getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(int instanceId) {
        this.instanceId = instanceId;
    }

    public boolean isAvaliable() {
        return avaliable;
    }

    public void setAvaliable(boolean avaliable) {
        this.avaliable = avaliable;
    }

    public Book getParent() {
        return parent;
    }

    public void setParent(Book parent) {
        this.parent = parent;
    }
}
