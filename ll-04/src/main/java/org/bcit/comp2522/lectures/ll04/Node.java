package org.bcit.comp2522.lectures.ll04;

import java.util.ArrayList;

public class Node<T> {
  private ArrayList<Node> children;
  private Node parent;
  private T val;

  /**
   * Constructor for Node.
   *
   * @param t is any type
   */
  public Node(T t, Node parent) {
    this.parent = parent;
    this.val = t;
    this.children = new ArrayList<Node>();
  }

  /**
   * Gets the node if it contains the value t.
   *
   * @param t any type
   * @return this node or null
   */
  public Node get(T t) {
    if (this.val == t) {
      return this;
    } else {
      for (Node n : children) {
        if (n.get(t) != null) {
          return n.get(t);
        }
      }
    }
    return null;
  }

  public ArrayList<Node> getChildren() {
    return children;
  }

  /**
   * Not-so-pretty printed one-liner for tree structure.
   *
   * @return string
   */
  @Override
  public String toString() {
    String acc = "";
    for (Node n : children) {
      acc = acc + n.toString();
    }
    return String.format("%s: [%s] ", this.val.toString(), acc);
  }

  public Node getParent() {
    return parent;
  }

  public Node nextChild(Node c) {
    return children.get(children.indexOf(c) + 1);
  }

  public Node anyNext(Node c) {
    if (this.hasNextChild(c)) {
      return nextChild(c);
    } else {
      if (parent != null) {
        return parent.anyNext(this);
      } else {
        return null;
      }
    }
  }

  /**
   * Return the node that is next in the DFS search. Follows the same
   * logic as hasNextChild.
   *
   * @param c the child node to check the position of
   * @return the next Node or null if none
   */
  public Node getNextChild(Node c) {
    if (this.hasNextChild(c)) {
      if (c == null) {
        return children.get(0);
      }
      else {
        return children.get(children.indexOf(c) + 1);
      }
    }
    return null;
  }

  /**
   * Gets the next child in the list of children.
   * If n is null and there exist children, get the first.
   *
   * @param n Node or null
   * @return true if there is a valid next child
   */
  private boolean hasNextChild(Node n) {
    if (n == null && children.size() > 0 ) {
      return true;
    }
    int i = children.indexOf(n);
    if (children.size() - 1 > i) {
      return true;
    }
    else {
      return false;
    }
  }

  /**
   * Returns true if there are any children of this node.
   *
   * @return true if children array is non-empty.
   */
  public boolean hasChild() {
    if (children.size() > 0) {
      return true;
    }
    return false;
  }

  /**
   * Returns the depth of the tree from here and below.
   *
   * @return integer
   */
  public int getDepth() {
    int acc = 1;
    int max = 0;
    if (children.size() == 0) {
      return acc;
    } else {
      for (Node n : children) {
        max = Math.max(max, n.getDepth());
      }
    }
    return acc + max;
  }

  /**
   * Gets the current value stored in this node.
   *
   * @return T is any
   */
  public T getVal() {
    return this.val;
  }

  /**
   * Adds a node to the ArrayList of nodes.
   *
   * @param child
   */
  private void add(Node child) {
    children.add(child);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Node) {
      if (((Node) obj).getVal() == this.getVal()) {
        return true;
      }
    }
    return false;
  }

  /**
   * Adds the child node c to parent p if p is this node.
   *
   * @param p parent node
   * @param c child node
   * @return
   */
  public boolean addTo(Node p, Node c) {
    if (this.equals(p)) {
      this.add(c);
      return true;
    } else {
      for (Node n : children) {
        if (n.addTo(p, c)) {
          return true;
        }
      }
      return false;
    }
  }
}
