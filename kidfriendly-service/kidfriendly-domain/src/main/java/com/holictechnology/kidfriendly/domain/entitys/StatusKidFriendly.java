package com.holictechnology.kidfriendly.domain.entitys;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "STATUS_KIDFRIENDLY", schema = "sistemap_kidfriendly")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idStatusKidFriendly", scope = StatusKidFriendly.class)
public class StatusKidFriendly implements Serializable {

    private static final long serialVersionUID = -4430168026656246166L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_STATUS_KIDFRIENDLY", nullable = false, unique = true)
    private Short idStatusKidFriendly;
    
    @Column(name = "DES_STATUS_KIDFRIENDLY", nullable = false, length = 45)
    private String desStatusKidFriendly;

    public Short getIdStatusKidFriendly() {
        return idStatusKidFriendly;
    }

    public void setIdStatusKidFriendly(Short idStatusKidFriendly) {
        this.idStatusKidFriendly = idStatusKidFriendly;
    }

    public String getDesStatusKidFriendly() {
        return desStatusKidFriendly;
    }

    public void setDesStatusKidFriendly(String desStatusKidFriendly) {
        this.desStatusKidFriendly = desStatusKidFriendly;
    }
}
