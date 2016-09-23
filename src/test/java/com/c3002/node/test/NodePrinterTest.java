package com.c3002.node.test;

import static org.junit.Assert.assertEquals;

import com.c3002.node.ILeaf;
import com.c3002.node.INode;
import com.c3002.node.Leaf;
import com.c3002.node.Node;
import com.c3002.node.console.Printer;

import org.junit.Test;

public class NodePrinterTest {

  @Test
  public void testPrint() {
    final INode rootA = new Node("A");
    final INode nodeB = new Node("B");
    final ILeaf nodeC = new Leaf("C");
    final ILeaf nodeD = new Leaf("D");
    rootA.add(nodeB);
    rootA.add(nodeC);
    nodeB.add(nodeD);

    final String actual = new Printer().print(rootA);
    final String expected = "A>" + System.lineSeparator() + "  B>" + System.lineSeparator()
        + "    D." + System.lineSeparator() + "  C." + System.lineSeparator();
    assertEquals("Unexpected console output.", expected, actual);
  }

}
