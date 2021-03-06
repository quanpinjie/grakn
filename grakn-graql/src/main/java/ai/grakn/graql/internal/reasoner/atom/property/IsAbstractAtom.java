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

package ai.grakn.graql.internal.reasoner.atom.property;

import ai.grakn.graql.Var;
import ai.grakn.graql.VarPattern;
import ai.grakn.graql.admin.Atomic;
import ai.grakn.graql.admin.ReasonerQuery;
import ai.grakn.graql.internal.reasoner.atom.AtomicBase;
import ai.grakn.graql.internal.reasoner.utils.IgnoreHashEquals;
import com.google.auto.value.AutoValue;

/**
 *
 * <p>
 * Atomic corresponding to {@link ai.grakn.graql.internal.pattern.property.IsAbstractProperty}.
 * </p>
 *
 * @author Kasper Piskorski
 *
 */
@AutoValue
public abstract class IsAbstractAtom extends AtomicBase {

    @Override @IgnoreHashEquals public abstract VarPattern getPattern();
    @Override @IgnoreHashEquals public abstract ReasonerQuery getParentQuery();

    public static IsAbstractAtom create(Var varName, ReasonerQuery parent) {
        return new AutoValue_IsAbstractAtom(varName, varName.isAbstract().admin(), parent);
    }

    private static IsAbstractAtom create(IsAbstractAtom a, ReasonerQuery parent) {
        return new AutoValue_IsAbstractAtom(a.getVarName(), a.getPattern(), parent);
    }

    @Override
    public Atomic copy(ReasonerQuery parent) { return create(this, parent); }

    @Override
    public boolean isAlphaEquivalent(Object obj) {
        return !(obj == null || this.getClass() != obj.getClass());
    }

    @Override
    public int alphaEquivalenceHashCode() { return 1;}

    @Override
    public boolean isStructurallyEquivalent(Object obj) {
        return isAlphaEquivalent(obj);
    }

    @Override
    public int structuralEquivalenceHashCode() {
        return alphaEquivalenceHashCode();
    }

}
