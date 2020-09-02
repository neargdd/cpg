/*
 * Copyright (c) 2019, Fraunhofer AISEC. All rights reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 *                    $$$$$$\  $$$$$$$\   $$$$$$\
 *                   $$  __$$\ $$  __$$\ $$  __$$\
 *                   $$ /  \__|$$ |  $$ |$$ /  \__|
 *                   $$ |      $$$$$$$  |$$ |$$$$\
 *                   $$ |      $$  ____/ $$ |\_$$ |
 *                   $$ |  $$\ $$ |      $$ |  $$ |
 *                   \$$$$$   |$$ |      \$$$$$   |
 *                    \______/ \__|       \______/
 *
 */

package de.fraunhofer.aisec.cpg.passes.scopes;

import de.fraunhofer.aisec.cpg.graph.Declaration;
import org.checkerframework.checker.nullness.qual.NonNull;

public class GlobalScope extends StructureDeclarationScope {

  public GlobalScope() {
    super(null);
  }
  /*

  private List<VariableDeclaration> variables = new ArrayList<>();

  public List<VariableDeclaration> getVariables() {
    return variables;
  }

  public void setVariables(List<VariableDeclaration> variables) {
    this.variables = variables;
  }

  public void addVariable(VariableDeclaration variable) {
    this.variables.add(variable);
  }*/

  public void addDeclaration(@NonNull Declaration declaration) {
    // add it to the current translation unit

  }
}
