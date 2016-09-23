package com.c3002.node.console;

import com.c3002.node.IBasicNode;
import com.c3002.node.ILeaf;
import com.c3002.node.INode;

import java.util.Iterator;

public class Printer {

  private static final String NODE_POSTFIX = ">";
  private static final String LEAF_POSTFIX = ".";
  private static final String INDENT = "  ";

  public String print(final IBasicNode node) {
    final StringBuffer stream = new StringBuffer();
    node.accept(this, stream, 0);
    return stream.toString();
  }

  protected void printIndentedName(final IBasicNode leaf, final StringBuffer stream,
      final int indent) {
    for (int loop = 0; loop < indent; loop++) {
      stream.append(INDENT);
    }
    stream.append(leaf.getName());
  }

  public void visitLeaf(final ILeaf leaf, final StringBuffer stream, final int indent) {
    printIndentedName(leaf, stream, indent);
    stream.append(LEAF_POSTFIX);
    stream.append(System.lineSeparator());
  }

  public void visitNode(final INode node, final StringBuffer stream, final int indent) {
    printIndentedName(node, stream, indent);
    stream.append(NODE_POSTFIX);
    stream.append(System.lineSeparator());
    final Iterator<IBasicNode> iterator = node.iterator();
    while (iterator.hasNext()) {
      iterator.next().accept(this, stream, indent + 1);
    }
  }

}
