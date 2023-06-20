package org.example.util;

import org.hibernate.boot.model.naming.*;

public class ImplicitNamingStrategyImpl implements ImplicitNamingStrategy {
    @Override
    public Identifier determinePrimaryTableName(ImplicitEntityNameSource implicitEntityNameSource) {
        return null;
    }

    @Override
    public Identifier determineJoinTableName(ImplicitJoinTableNameSource implicitJoinTableNameSource) {
        return null;
    }

    @Override
    public Identifier determineCollectionTableName(ImplicitCollectionTableNameSource implicitCollectionTableNameSource) {
        return null;
    }

    @Override
    public Identifier determineDiscriminatorColumnName(ImplicitDiscriminatorColumnNameSource implicitDiscriminatorColumnNameSource) {
        return null;
    }

    @Override
    public Identifier determineTenantIdColumnName(ImplicitTenantIdColumnNameSource implicitTenantIdColumnNameSource) {
        return null;
    }

    @Override
    public Identifier determineIdentifierColumnName(ImplicitIdentifierColumnNameSource implicitIdentifierColumnNameSource) {
        return null;
    }

    @Override
    public Identifier determineBasicColumnName(ImplicitBasicColumnNameSource implicitBasicColumnNameSource) {
        return null;
    }

    @Override
    public Identifier determineJoinColumnName(ImplicitJoinColumnNameSource implicitJoinColumnNameSource) {
        return null;
    }

    @Override
    public Identifier determinePrimaryKeyJoinColumnName(ImplicitPrimaryKeyJoinColumnNameSource implicitPrimaryKeyJoinColumnNameSource) {
        return null;
    }

    @Override
    public Identifier determineAnyDiscriminatorColumnName(ImplicitAnyDiscriminatorColumnNameSource implicitAnyDiscriminatorColumnNameSource) {
        return null;
    }

    @Override
    public Identifier determineAnyKeyColumnName(ImplicitAnyKeyColumnNameSource implicitAnyKeyColumnNameSource) {
        return null;
    }

    @Override
    public Identifier determineMapKeyColumnName(ImplicitMapKeyColumnNameSource implicitMapKeyColumnNameSource) {
        return null;
    }

    @Override
    public Identifier determineListIndexColumnName(ImplicitIndexColumnNameSource implicitIndexColumnNameSource) {
        return null;
    }

    @Override
    public Identifier determineForeignKeyName(ImplicitForeignKeyNameSource implicitForeignKeyNameSource) {
        return null;
    }

    @Override
    public Identifier determineUniqueKeyName(ImplicitUniqueKeyNameSource implicitUniqueKeyNameSource) {
        return null;
    }

    @Override
    public Identifier determineIndexName(ImplicitIndexNameSource implicitIndexNameSource) {
        return null;
    }
}
