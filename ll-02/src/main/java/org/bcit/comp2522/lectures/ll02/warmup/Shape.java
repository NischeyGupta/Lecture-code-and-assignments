package org.bcit.comp2522.lectures.ll02.warmup;

public abstract class Shape {
  protected ProcessingWindow window;
  protected float xpos;
  protected float ypos;

  public Shape(ProcessingWindow window, float xpos, float ypos) {
    this.window = window;
    this.xpos = xpos;
    this.ypos = ypos;
  }

  public abstract void draw();

  public float getX() {
    return xpos;
  }
  public float getY() {
    return ypos;
  }

  public void setX(float x) {
    this.xpos = x;
  }
  public void setY(float y) {
    this.ypos = y;
  }

  public boolean equals(Shape b) {
    boolean sameClass = this.getClass().getSimpleName().equals(b.getClass().getSimpleName());
    boolean sameX = this.xpos == b.xpos;
    boolean sameY = this.ypos == b.ypos;
    return sameX && sameY && sameClass;
  }

  public int hashCode() {
    return (int) (this.xpos + this.ypos);
  }

  public String toString() {
    String classname = this.getClass().getSimpleName();
    return String.format("%s X:%f; Y:%f", classname, this.xpos, this.ypos);
  }
}
