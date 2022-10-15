package org.bcit.comp2522.lectures.sl05;

import java.util.ArrayList;

public abstract class AbstractObservable {
  ArrayList<Subscriber> observers;
  public abstract void registerObserver(Subscriber observer);
  public abstract void unregisterObserver(Subscriber observer);
  public abstract void notifyObservers(String msg);
}
