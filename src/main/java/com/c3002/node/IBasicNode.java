package com.c3002.node;

import com.c3002.node.console.Printer;

public interface IBasicNode {

  String getName();

  void accept(Printer printer, StringBuffer stream, int indent);

}
