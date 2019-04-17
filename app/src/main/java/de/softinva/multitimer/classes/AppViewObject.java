package de.softinva.multitimer.classes;

public abstract class AppViewObject<T> {
    protected T obj;

    public AppViewObject(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

}
