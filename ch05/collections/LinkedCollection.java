//---------------------------------------------------------------------------
// LinkedCollection.java          by Dale/Joyce/Weems/Anderson               Chapter 5
//
// Implements the CollectionInterface using a linked collection.
// Null elements are not allowed. Duplicate elements are allowed.
// One constructor is provided, one that creates an empty collection.
//---------------------------------------------------------------------------

package ch05.collections;

import support.LLNode;

public class LinkedCollection<T> implements CollectionInterface<T> {
  protected LLNode<T> head; // head of the linked list
  protected int numElements = 0; // number of elements in this collection

  // set by find method
  protected boolean found; // true if target found, else false
  protected LLNode<T> location; // node containing target, if found
  protected LLNode<T> previous; // node preceding location

  public LinkedCollection() {
    numElements = 0;
    head = null;
  }

  public boolean add(T element)
  // Adds element to this collection.
  {
    LLNode<T> newNode = new LLNode<T>(element);
    newNode.setLink(head);
    head = newNode;
    numElements++;
    return true;
  }

  protected void find(T target)
  // Searches the collection for an occurence of an element e such that
  // e.equals(target). If successful, sets instance variables
  // found to true, location to node containing e, and previous
  // to the node that links to location. If not successful, sets
  // found to false.
  {
    location = head;
    found = false;

    while (location != null) {
      if (location.getInfo().equals(target)) // if they match
      {
        found = true;
        return;
      } else {
        previous = location;
        location = location.getLink();
      }
    }
  }

  public int size()
  // Returns the number of elements on this collection.
  {
    return numElements;
  }

  public boolean contains(T target)
  // Returns true if this collection contains an element e such that
  // e.equals(target); otherwise, returns false.
  {
    find(target);
    return found;
  }

  public boolean remove(T target)
  // Removes an element e from this collection such that e.equals(target)
  // and returns true; if no such element exists, returns false.
  {
    find(target);
    if (found) {
      if (head == location)
        head = head.getLink(); // remove first node
      else
        previous.setLink(location.getLink()); // remove node at location

      numElements--;
    }
    return found;
  }

  public T get(T target)
  // Returns an element e from this collection such that e.equals(target);
  // if no such element exists, returns null.
  {
    find(target);
    if (found)
      return location.getInfo();
    else
      return null;
  }

  public boolean isEmpty()
  // Returns true if this collection is empty; otherwise, returns false.
  {
    return (numElements == 0);
  }

  public boolean isFull()
  // Returns true if this collection is full; otherwise, returns false.
  {
    return false; // Linked implementation is never full
  }

  @Override
  public String toString() {
    // Returns a string representation of this collection.
    StringBuilder sb = new StringBuilder();
    // HomeWork Notes:
    // start at the head node of the collection and loop through
    // until we get to the last node.
    // at each loop we want to append the current node's info to the StringBuilder
    // we assume each element has toString method per instructions
    LLNode<T> current = head;
    while (current != null) {
      String currentInfo = current.getInfo().toString();
      LLNode<T> next = current.getLink();

      sb.append(currentInfo);
      // add comma and whitespace for readability, if not last element
      if (next != null) {
        sb.append(", ");
      }
      // set current to next node for next iteration of loop
      current = next;
    }
    return sb.toString();
  }

  public int count(T target) {
    // Returns a count of the number of elements e in the collection

    // Homework Notes:
    // start at the head node and iterate through the collection
    // keep a count of how many times we find an element equal to target
    LLNode<T> current = head;
    int count = 0;

    while (current != null) {

      // check if current is equal to target
      if (current.getInfo().equals(target)) {
        // increment count since we found a match
        count++;
      }
      // move to the next node
      current = current.getLink();
    }
    return count;
  }

  public void removeAll(T target) {
    // Removes all elements from the collection such that e.equals(target) is true

    // Homework Notes
    // start at the head node and iterate through the collection
    // for each node, check if it equals target
    // if it does, remove it from the collection
    LLNode<T> current = head;
    LLNode<T> previous = null;

    while (current != null) {
      boolean targetFound = current.getInfo().equals(target);
      // check if current is equal to target
      if (targetFound) {

        if (current == head) {
          // we need to set head to next node
          // this will orphan the former head
          head = current.getLink();

        } else {
          // connect previous to the node after current
          previous.setLink(current.getLink());

        }

      }
      // set our pointer variables for next iteration
      // set previous to current for next iteration
      if (!targetFound) {
        // if we didn't find a match, we need to move previous
        // if we did find a match, then we removed it, and so previous
        // should stay the same for next iteration
        previous = current;
      }
      // set current to next node for next iteration
      current = current.getLink();

    }
  }
}
