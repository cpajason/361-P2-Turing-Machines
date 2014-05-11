/**
 * This is the Tape class for the Turing Machine simulator used in Machine.java
 * It is basically a simple linked list, with some additional functionality 
 * added, to support Turing machines.
 * 
 * @author Jason Allen
 * @author Nathan Henninger
 * @author Matt Weaver
 *
 */
public class Tape {
  Cell curr, first, last;

  // Constructor for an empty tape
  public Tape() {
    this.curr = new Cell(0);
    this.curr.l = this.curr.r = null;
    this.first = this.last = this.curr;
  }
  /** Constructor for a tape with initial input
   * @param input - the initial input on the tape
   */
  public Tape(String input) {
    this();
    Cell init = this.curr;
    for (int i = 0; i < input.length(); i++) {
      this.set(Character.getNumericValue(input.charAt(i)));
      this.right();
    }
    this.curr = init;
  }
  
  /** Move the tape to the left
   */
  public void left() {
    if (this.curr.l == null) {
      this.curr.l = new Cell(0);
      this.curr.l.r = this.curr;
      this.first = this.curr.l;
    }
    this.curr = this.curr.l;
  }
  
  /** Move the tape to the right
   */
  public void right() {
    if (this.curr.r == null) {
      this.curr.r = new Cell(0);
      this.curr.r.l = this.curr;
      this.last = this.curr.r;
    }
    this.curr = this.curr.r;
  }
  
  /** Get the contents of the tape at the current position
   * @return the contents of the tape at the current position
   */
  public int get() {
    return this.curr.i;
  }
  
  /** Set the value for the contents of the tape at the current position
   * @param i - the value to set the current position on the tape to.
   */
  public void set(int i) {
    this.curr.i = i;
  }
  
  /** Print the contents of the tape to stdout
   * 
   */
  public void print() {
    //int score = 0;
    Cell currNode = this.first;
    while (currNode != null) {
      System.out.print(currNode.i);
      currNode = currNode.r;
    }
    //System.out.println("score: " + score);
  }
  
  
  /** Internal class representing the cells on the tape
   * @author mhweaver
   *
   */
  private class Cell {
    public int i;
    public Cell l, r;
    public Cell(int i) {
      this.i = i;
      this.l = this.r = null;
    }
  }
}
