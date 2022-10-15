package org.bcit.comp2522.lectures.ll04;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A Depth-First Search Tree that can contain anything.
 *
 * @param <T> anything
 */
public class DFSTree<T> implements Iterable<T> {
  Node root;

  /**
   * Adds a node to the root; if root doesn't exist, instantiates root.
   *
   * @param n new Node to add
   */
  public void add(Node n) {
    if (root == null) {
      root = n;
    } else {
      root.addTo(root, n);
    }
  }

  /**
   * Calls the not-so-pretty print for nodes.
   *
   * @return string
   */
  @Override
  public String toString() {
    if (root == null) {
      return super.toString();
    } else {
      return String.format("%s \n %s", super.toString(), root.toString());
    }
  }

  /**
   * Calls the root's get function.
   *
   * @param t any type
   * @return the node which contains t
   */
  public Node<T> get(T t) {
    return root.get(t);
  }

  /**
   * Makes a new node that contains t.
   * @param t is any type
   */
  public void add(T t) {
    if (root == null) {
      root = new Node<T>(t, null);
    } else {
      Node temp = new Node<T>(t, root);
      root.addTo(root, temp);
    }
  }

  /**
   * Adds a value to the tree by making a new node and adding that as
   * a child of p.
   *
   * @param p parent node
   * @param t is any type
   * @return true if add was successful at any point down the tree.
   */
  public boolean addTo(Node p, T t) {
    Node temp = new Node<T>(t, p);
    if (root == null) {
      root = p;
    } else {
      return root.addTo(p, temp);
    }
    return true;
  }

  /**
   * Counts the depth of the tree.
   *
   * @return int dept of tree
   */
  public int getDepth() {
    if (root == null) {
      return 0;
    } else {
      return root.getDepth();
    }
  }

  /**
   * Adds a child node to the parent anywhere in the tree.
   *
   * @param p parent node
   * @param c child node
   * @return true if added anywhere in the tree.
   */
  public boolean addTo(Node p, Node c) {
    if (root == null) {
      root = p;
    }
    return root.addTo(p, c);
  }

  /**
   * Returns an iterator over elements of type {@code T}.
   *
   * @return an Iterator.
   */
  @Override
  public Iterator<T> iterator() {
    return new DFSIterator(this.root);
  }

  class DFSIterator implements Iterator<T> {
    Node next;

    public DFSIterator(Node root) {
      this.next = root;
    }

    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {
      if (next != null) {
        return true;
      }
      return false;
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public T next() {
      T temp = (T) next.getVal();
      next = next.anyNext(next);
      return temp;
    }
  }
}
