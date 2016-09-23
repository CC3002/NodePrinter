package com.c3002.node;

import java.util.Iterator;

public interface INode extends IBasicNode {

  void add(IBasicNode node);

  Iterator<IBasicNode> iterator();

}
