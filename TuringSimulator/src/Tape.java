public class Tape {
  Node curr, first, last;
  public Tape() {
    this.curr = new Node(0);
    this.curr.l = this.curr.r = null;
    this.first = this.last = this.curr;
  }
  public Tape(String input) {
    this();
    Node init = this.curr;
    for (int i = 0; i < input.length(); i++) {
      this.set(Character.getNumericValue(input.charAt(i)));
      this.right();
    }
    this.curr = init;
  }
  
  public void left() {
    if (this.curr.l == null) {
      this.curr.l = new Node(0);
      this.curr.l.r = this.curr;
      this.first = this.curr.l;
    }
    this.curr = this.curr.l;
  }
  public void right() {
    if (this.curr.r == null) {
      this.curr.r = new Node(0);
      this.curr.r.l = this.curr;
      this.last = this.curr.r;
    }
    this.curr = this.curr.r;
  }
  public int get() {
    return this.curr.i;
  }
  public void set(int i) {
    this.curr.i = i;
  }
  public boolean hasRight() {
    return this.curr.r != null;
  }
  public void reset() {
    this.curr = this.first;
  }
  
  
  private class Node {
    public int i;
    public Node l, r;
    public Node(int i) {
      this.i = i;
      this.l = this.r = null;
    }
  }
}
