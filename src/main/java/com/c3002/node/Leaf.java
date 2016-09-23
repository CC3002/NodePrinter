package com.c3002.node;

import com.c3002.node.console.Printer;

public class Leaf implements ILeaf {

  private final transient String name;

  public Leaf(final String name) {
    this.name = name;
  }

  @Override
  public void accept(final Printer printer, final StringBuffer stream, final int indent) {
    printer.visitLeaf(this, stream, indent);
  }

  @Override
  public String getName() {
    return name;
  }

}
