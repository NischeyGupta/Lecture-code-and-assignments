package org.bcit.comp2522.lectures.ll02.warmup;

/**
 * The square class is a subclass of Shape and takes the abstract draw()
 * method from the superclass.
 */
public class Square extends Shape {
  float size;

  /**
   * Constructor for making a square object.
   *
   * @param window is the processing window
   * @param xpos is the x-position of the square
   * @param ypos is the y-position of the square
   * @param size is the side length of the square
   */

  public Square(ProcessingWindow window, float xpos, float ypos, float size) {
    super(window, xpos, ypos);
    this.size = size;
  }

  public void setHeight(float height) {
    this.size = height;
  }


  public void setWidth(float width) {
    this.size = width;
  }

  public void draw() {
    window.rect(this.xpos, this.ypos, this.size, this.size);
  }
}
