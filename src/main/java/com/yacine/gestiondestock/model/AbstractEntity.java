package com.yacine.gestiondestock.model;

import java.io.Serializable;
import java.time.Instant;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

//la class abstract on la crée pour regrouper les champs ou attributs qi sont en commun
@Data //Pour les getters et setters
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class) //avec cette annotation on dis qu'elle va ecouter cette class et a chaque fois qu'elle va voir la date de creation
                                               //ainsi que la date de la derniere modification va mettre a jour ces champs dans la base de données lors de l'enregis
                                               //lors de la cration elle assigne une valeur a creationDate et lors de la modification elle va assigner une valeur a last
public class AbstractEntity implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @CreatedDate //date de création
    @Column(name = "creationDate", nullable = false)
    @JsonIgnore
    private Instant creationDate;

    @LastModifiedDate //date de la derniere modification
    @Column(name = "lastModifiedDate")
    @JsonIgnore
    private  Instant lastUpdateDate;
}
