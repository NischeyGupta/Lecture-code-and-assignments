package org.bcit.comp2522.lectures.sl05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PublisherTest {
  Publisher publisher;

  @BeforeEach
  void setup() {
    publisher = new Publisher();
  }

  @Test
  void registerObserver() {
    Subscriber subscriber = new Subscriber();
    publisher.registerObserver(subscriber);
    assertEquals(1, publisher.observers.size());
  }

  @Test
  void unregisterObserver() {
    Subscriber subscriber = new Subscriber();
    publisher.registerObserver(subscriber);
    publisher.unregisterObserver(subscriber);
    assertEquals(0, publisher.observers.size());
  }

  @Test
  void notifyObservers() {
    for (int i = 0; i < 4; i++) {
      publisher.registerObserver(new Subscriber());
    }
    publisher.notifyObservers("Hello!");
    for (Subscriber sub : publisher.observers) {
      assertEquals("Hello!", sub.lastMsg);
    }
    publisher.notifyObservers("World!");
    for (Subscriber sub : publisher.observers) {
      assertEquals("World!", sub.lastMsg);
    }
  }
}