package com.study.auth.auth.shared;



public abstract class Entity<T> {
    private EntityId id;
    protected T props;

    public EntityId getId() {
        return id;
    }

    protected Entity(EntityId id, T props) {
        this.id = id;
        this.props = props;
    }

    protected Entity(T props) {
        this.props = props;
        this.id = new EntityId();
    }

    public Boolean equals(Entity<T> entity) {
        if (entity == null) {
            return false;
        }

        if (!(entity instanceof Entity)) {
            return false;
        }

        if (entity == this) {
            return true;
        }

        return this.id.equals(entity.getId());
    }
    
}
