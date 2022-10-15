package org.bcit.comp2522.lectures.ll02.warmup;

import processing.core.PApplet;

public class Main {
  public static void main(String[] args) {
    ProcessingWindow window = new ProcessingWindow();

    Square s1 = new Square(window, 300f, 300f, 50f);
    window.addShape(s1);

    Rectangle r1 = new Rectangle(window, 100f,  100f, 50f, 25f);
    Rectangle r2 = new Rectangle(window, 100f, 100f, 50f, 10f);
    window.addShape(r1);
    window.addShape(r2);

    String[] processingArgs = {"ProcessingWindow"};
    PApplet.runSketch(processingArgs, window);
  }
}