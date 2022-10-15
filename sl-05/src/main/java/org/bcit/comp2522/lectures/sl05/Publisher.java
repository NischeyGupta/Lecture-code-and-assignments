package org.bcit.comp2522.lectures.sl05;

import java.util.ArrayList;

public class Publisher extends AbstractObservable {

  public Publisher() {
    this.observers = new ArrayList<Subscriber>();
  }

  @Override
  public void registerObserver(Subscriber observer) {
    this.observers.add(observer);
  }

  @Override
  public void unregisterObserver(Subscriber observer) {
    this.observers.remove(observer);
  }

  @Override
  public void notifyObservers(String msg) {
    for (Subscriber sub : this.observers) {
      sub.update(msg);
    }
  }
}
