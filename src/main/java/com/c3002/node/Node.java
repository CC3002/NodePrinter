package com.c3002.node;

import com.c3002.node.console.Printer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Node implements INode {

  private final transient String name;
  private final transient List<IBasicNode> nodes = new ArrayList<IBasicNode>();

  public Node(final String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void add(final IBasicNode node) {
    nodes.add(node);
  }

  @Override
  public Iterator<IBasicNode> iterator() {
    return nodes.iterator();
  }

  @Override
  public void accept(final Printer printer, final StringBuffer stream, final int indent) {
    printer.visitNode(this, stream, indent);
  }

}
