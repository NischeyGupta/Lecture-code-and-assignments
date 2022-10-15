package org.bcit.comp2522.lectures.ll02.warmup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
  ProcessingWindow window;
  Rectangle r1, r2, r3;
  Square s1;
  ArrayList<Shape> shapes;

  @BeforeEach
  void setup() {
    window = new ProcessingWindow();
    shapes = new ArrayList<Shape>();
    r1 = new Rectangle(window, 100f,  100f, 50f, 25f);
    r2 = new Rectangle(window, 100f,  100f, 50f, 25f);
    r3 = new Rectangle(window, 100f,  100f, 50f, 25f);
    s1 = new Square(window,100f, 100f, 25f);
    shapes.add(r1);
    shapes.add(r2);
    shapes.add(r3);
    shapes.add(s1);
   }

  @Test
  @DisplayName("Trivial test.")
  void selfEqualsTest() {

  }

  @Test
  @DisplayName("Liskov test.")
  void liskovTest() {
    r1.setWidth(75f);
    s1.setWidth(75f);
    for (Shape s : shapes) {
      if (s instanceof Rectangle) {
       assertEquals(25f, ((Rectangle) s).getHeight());
      }
    }
  }

}