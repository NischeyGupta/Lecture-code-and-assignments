package org.bcit.comp2522.lectures.ll02.warmup;

public class Rectangle extends Shape {
  private float width;
  private float height;

  public Rectangle(ProcessingWindow window, float xpos, float ypos, float width, float height) {
    super(window, xpos, ypos);
    this.width = width;
    this.height = height;
  }

  public float getWidth() {
    return width;
  }
  public float getHeight() {
    return height;
  }
  public void setWidth(float w) {
    this.width = w;
  }
  public void setHeight(float h) {
    this.height = h;
  }

  public float area() {
    return this.width * this.height;
  }

  public void draw() {
    window.rect(this.xpos, this.ypos, this.width, this.height);
  }
}
