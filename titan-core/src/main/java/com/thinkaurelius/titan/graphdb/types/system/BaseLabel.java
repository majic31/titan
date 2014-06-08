package com.thinkaurelius.titan.graphdb.types.system;

import com.thinkaurelius.titan.core.EdgeLabel;
import com.thinkaurelius.titan.core.Multiplicity;
import com.thinkaurelius.titan.graphdb.internal.TitanSchemaCategory;
import com.tinkerpop.blueprints.Direction;

public class BaseLabel extends BaseRelationType implements EdgeLabel {

    public static final BaseLabel SchemaDefinitionEdge =
            new BaseLabel("SchemaRelated", 36, Direction.BOTH);

    public static final BaseLabel VertexLabelEdge =
            new BaseLabel("vertexlabel", 2, Direction.OUT);


    private final Direction directionality;

    private BaseLabel(String name, int id, Direction directionality) {
        super(name, id, TitanSchemaCategory.EDGELABEL);
        this.directionality = directionality;
    }

    @Override
    public long[] getSignature() {
        return new long[]{BaseKey.SchemaDefinitionDesc.getID()};
    }

    @Override
    public Integer getTtl() {
        return null;
    }

    @Override
    public Multiplicity getMultiplicity() {
        return Multiplicity.MULTI;
    }

    @Override
    public final boolean isPropertyKey() {
        return false;
    }

    @Override
    public final boolean isEdgeLabel() {
        return true;
    }

    @Override
    public boolean isDirected() {
        return true;
    }

    @Override
    public boolean isUnidirected() {
        return isUnidirected(Direction.OUT);
    }

    @Override
    public boolean isUnidirected(Direction dir) {
        return dir== directionality;
    }


}
