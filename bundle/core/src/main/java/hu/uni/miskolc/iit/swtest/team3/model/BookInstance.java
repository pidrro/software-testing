package hu.uni.miskolc.iit.swtest.team3.model;

public class BookInstance {

    private int instanceId;
    private boolean avaliable;

    public BookInstance(int instanceId, boolean avaliable) {
        this.instanceId = instanceId;
        this.avaliable = avaliable;
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
}
