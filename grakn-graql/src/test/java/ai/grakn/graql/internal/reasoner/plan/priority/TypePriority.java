/*
 * GRAKN.AI - THE KNOWLEDGE GRAPH
 * Copyright (C) 2018 Grakn Labs Ltd
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package ai.grakn.graql.internal.reasoner.plan.priority;

import ai.grakn.graql.Var;
import ai.grakn.graql.internal.reasoner.atom.Atom;
import ai.grakn.graql.internal.reasoner.plan.SimplePlanner;
import java.util.Set;

/**
 *
 * <p>
 * Class defining resolution weight for type atoms.
 * </p>
 *
 * @author Kasper Piskorski
 *
 */
class TypePriority extends BasePriority {

    TypePriority(Atom atom) {  super(atom);}

    @Override
    public int computePriority(Set<Var> subbedVars){
        int priority = super.computePriority(subbedVars);
        priority += SimplePlanner.IS_TYPE_ATOM;
        priority += atom().getSchemaConcept() == null && !atom().isRelation()? SimplePlanner.NON_SPECIFIC_TYPE_ATOM : 0;
        return priority;
    }
}
