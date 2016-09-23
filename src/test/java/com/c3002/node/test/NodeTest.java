package com.c3002.node.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.c3002.node.IBasicNode;
import com.c3002.node.ILeaf;
import com.c3002.node.INode;
import com.c3002.node.Leaf;
import com.c3002.node.Node;

import org.junit.Test;

import java.util.Iterator;

public class NodeTest {

  private final transient INode rootA = new Node("A");
  private final transient INode nodeB = new Node("B");

  @Test
  public void testCreation() {
    assertEquals("Unexpected node name.", "A", rootA.getName());
  }

  protected void initializeWithOneNode() {
    rootA.add(nodeB);
  }

  @Test
  public void testAddHasNextSubnode() {
    initializeWithOneNode();
    assertTrue("Expects one sub-node.", rootA.iterator().hasNext());
  }

  @Test
  public void testAddSameSubnode() {
    initializeWithOneNode();
    assertEquals("Expects the recently added node.", nodeB, rootA.iterator().next());
  }

  @Test
  public void testAddOnlyOneSubnode() {
    initializeWithOneNode();
    final Iterator<IBasicNode> iterator = rootA.iterator();
    iterator.next();
    assertFalse("There should by only one sub-node.", iterator.hasNext());
  }

  /**
   * Testing node structure.
   * 
   * <p>
   * A
   *    B
   *        D
   *    C
   * </p>
   */
  @Test
  public void testAddSeveralNodes() {
    final ILeaf nodeC = new Leaf("C");
    final ILeaf nodeD = new Leaf("D");
    rootA.add(nodeB);
    rootA.add(nodeC);
    nodeB.add(nodeD);
    Iterator<IBasicNode> iterator = rootA.iterator();
    assertTrue("Expects the first subnode.", iterator.hasNext());
    assertEquals("Expects the node B.", nodeB, iterator.next());
    assertTrue("Expects the second subnode.", iterator.hasNext());
    assertEquals("Expects the node C.", nodeC, iterator.next());
    assertFalse("Expects no more subnodes of A.", iterator.hasNext());
    iterator = nodeB.iterator();
    assertTrue("Expects one subnode", iterator.hasNext());
    assertEquals("Expects node D.", nodeD, iterator.next());
    assertFalse("Expects no more subnodes of D.", iterator.hasNext());
  }
  
  @Test
  public void testGetNameOfLeaf() {
    assertEquals("Unexpected leaf name.", "leaf", new Leaf("leaf").getName());
  }

}
