package org.bcit.comp2522.lectures.ll02.warmup;

import processing.core.PApplet;

import java.util.ArrayList;

public class ProcessingWindow extends PApplet {
  ArrayList<Shape> shapes;

  public ProcessingWindow() {
    this.shapes = new ArrayList<Shape>();
  }

  public void settings() {
    size(500, 500);
  }

  public void draw() {
    strokeWeight(1f);
    for (Shape shape : this.shapes) {
      shape.draw();
    }
  }
  public void addShape(Shape s) {
    this.shapes.add(s);
  }
}