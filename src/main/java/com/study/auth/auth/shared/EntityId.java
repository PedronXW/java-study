package com.study.auth.auth.shared;

import java.util.UUID;

public class EntityId {
    private String value;

    public EntityId() {
        this.value = UUID.randomUUID().toString();
    }

    public EntityId(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
    
      public Boolean equals(EntityId id) {
        if (id == null) {
          return false;
        }
    
        if (!(id instanceof EntityId)) {
          return false;
        }
    
        if (id == this) {
          return true;
        }
    
        return this.getValue() == id.value;
      }
}
