package org.bcit.comp2522.lectures.sl05;

public class Main {
  public static void main(String[] args) {
    Publisher publisher = new Publisher();
    for (int i = 0; i < 4; i++) {
      publisher.registerObserver(new Subscriber());
    }
    publisher.notifyObservers("Hello!");
    publisher.notifyObservers("World!");
  }
}