package com.webproject.webprojectboard.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAuditingField is a Querydsl query type for AuditingField
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QAuditingField extends EntityPathBase<AuditingField> {

    private static final long serialVersionUID = -1242708238L;

    public static final QAuditingField auditingField = new QAuditingField("auditingField");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.time.LocalDateTime> modifiedAt = createDateTime("modifiedAt", java.time.LocalDateTime.class);

    public final StringPath modifiedBy = createString("modifiedBy");

    public QAuditingField(String variable) {
        super(AuditingField.class, forVariable(variable));
    }

    public QAuditingField(Path<? extends AuditingField> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAuditingField(PathMetadata metadata) {
        super(AuditingField.class, metadata);
    }

}

