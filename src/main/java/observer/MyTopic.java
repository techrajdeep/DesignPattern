package observer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyTopic implements Subject{
    private String message;//state
    private boolean isChanged; // we can have queue instead of message and isChanged
    private List<Observer> observers;
    private final Object MUTEX=new Object();

    public MyTopic() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void register(Observer obj) {
        if(obj == null) throw new NullPointerException("Null Observer");
        synchronized (MUTEX){
            if(!this.observers.contains(obj)){
                this.observers.add(obj);
            }
        }
    }

    @Override
    public void unregister(Observer obj) {
        if(obj == null) throw new NullPointerException("Null Observer");
        synchronized (MUTEX){
            if(this.observers.contains(obj)){
                this.observers.remove(obj);
            }
        }
    }

    @Override
    public void notifyObservers() {
            List<Observer> localObservers= Collections.EMPTY_LIST;
            synchronized (MUTEX){
                if(!this.isChanged)
                    return;
                localObservers=new ArrayList<>(observers);
                this.isChanged=false;
            }
        for(Observer observer:localObservers)
            observer.update();
    }

    @Override
    public Object getUpdate() {
        return this.message;
    }
    private void setChanged(){
        synchronized (MUTEX){
            this.isChanged=true;
        }
    }

    //method to post message to the topic
    public void postMessage(String msg){
        System.out.println("Message Posted to Topic:"+msg);
        this.message=msg;
        setChanged();
        notifyObservers();
    }

    // We can do something to clear the message after sending
}
