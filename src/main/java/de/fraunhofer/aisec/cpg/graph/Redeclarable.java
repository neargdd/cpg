package de.fraunhofer.aisec.cpg.graph;

import java.util.Iterator;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.Nullable;

interface Redeclarable<N extends Declaration> {

  class DeclarationChain<N extends Declaration> {

    @Nullable Redeclarable<N> first;
    @Nullable Redeclarable<N> prev;
    @Nullable Redeclarable<N> latest;
  }

  DeclarationChain<N> chain();

  default Iterator<N> declarationIterator(N node) {
    return new Iterator<>() {

      N current = node;
      boolean passedFirst = false;

      @Override
      public boolean hasNext() {
        if (current == chain().first) {
          if (passedFirst) {
            return false;
          }
          passedFirst = true;
        }
        N next = (N) current.getNextRedeclaration();
        return next != current;
      }

      @Override
      public N next() {
        N next = (N) current.getNextRedeclaration();
        current = next;

        return next;
      }
    };
  }

  default N get() {
    return (N) this;
  }

  /**
   * Sets the previous declaration of this, if it exists. If it does not exist, this is probably the
   * first.
   */
  default void setPreviousDeclaration(@Nullable Redeclarable<N> previousDeclaration) {
    Redeclarable<N> first;

    if (previousDeclaration != null) {
      // learn first from previous
      chain().first = previousDeclaration.getFirst();
      assert (chain().first != null);

      chain().prev = previousDeclaration;
    } else {
      chain().first = this;
    }

    // point first one's latest to us
    chain().first.setLatest(this);

    updateFields();
  }

  default void setLatest(Redeclarable<N> l) {
    chain().latest = l;
  }

  @Nullable
  default Redeclarable<N> getPrevious() {
    // we do not know the latest
    if (chain().latest == null) {
      // if we know the previous, return it
      if (chain().prev != null) {
        return chain().prev;
      }
    }

    return chain().latest;
  }

  @Nullable
  default Redeclarable<N> getFirst() {
    return chain().first;
  }

  default N getMostRecentDeclaration() {
    return Objects.requireNonNullElse(chain().latest, this).get();
  }

  default void updateFields() {}
}
