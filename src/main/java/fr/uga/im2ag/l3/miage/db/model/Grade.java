package fr.uga.im2ag.l3.miage.db.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("G")
@NamedQueries(
    @NamedQuery(name = "get-all-grades", query = "select G from Grade G" )
)
public class Grade {

    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToOne
    private Subject subject;

    @Column(name = "g_value")
    private Float value;

    @Column(nullable = false)
    private Float weight;

    public Long getId() {
        return id;
    }

    public Subject getSubject() {
        return subject;
    }

    public Grade setSubject(Subject subject) {
        this.subject = subject;
        return this;
    }

    public Float getValue() {
        return value;
    }

    public Grade setValue(Float value) {
        this.value = value;
        return this;
    }

    public Float getWeight() {
        return weight;
    }

    public Grade setWeight(Float weight) {
        this.weight = weight;
        return this;
    }
}
