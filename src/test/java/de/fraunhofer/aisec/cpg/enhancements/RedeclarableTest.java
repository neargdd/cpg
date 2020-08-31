package de.fraunhofer.aisec.cpg.enhancements;

import static org.junit.jupiter.api.Assertions.assertEquals;

import de.fraunhofer.aisec.cpg.graph.NodeBuilder;
import de.fraunhofer.aisec.cpg.graph.RecordDeclaration;
import org.junit.jupiter.api.Test;

public class RedeclarableTest {
  @Test
  void testRedeclare() {
    RecordDeclaration a1 = NodeBuilder.newRecordDeclaration("A", "class", "class A;");

    a1.setPreviousDeclaration(null);

    RecordDeclaration a2 = NodeBuilder.newRecordDeclaration("A", "class", "class A;");
    a2.setIsDefinition(true);

    a2.setPreviousDeclaration(a1);

    assertEquals(a1, a2.getPrevious());
    assertEquals(a2, a1.getPrevious());

    assertEquals(a2, a1.getMostRecentDeclaration());
    assertEquals(a2, a2.getMostRecentDeclaration());

    assertEquals(a2, a1.getDefinition());
    assertEquals(a2, a2.getDefinition());
  }
}
