package fr.uga.im2ag.l3.miage.db.repository.impl;

import fr.uga.im2ag.l3.miage.db.repository.api.GradeRepository;
import fr.uga.im2ag.l3.miage.db.model.Grade;
import fr.uga.im2ag.l3.miage.db.model.Subject;

import javax.persistence.EntityManager;
import java.util.List;

public class GradeRepositoryImpl extends BaseRepositoryImpl implements GradeRepository {

    /**
     * Build a base repository
     *
     * @param entityManager the entity manager
     */
    public GradeRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public List<Grade> findHighestGrades(int limit) {
        return entityManager.createQuery("select TOP limit * G from Grade G group by G.value", Grade.class)
                .setParameter("limit", limit)
                .getResultList();
    }

    @Override
    public List<Grade> findHighestGradesBySubject(int limit, Subject subject) {
        return entityManager.createQuery("select * from Grade G where G.value >= :limit and id = :subject", Grade.class)
                .setParameter("limit", limit)
                .setParameter("subject", subject.getId())
                .getResultList();
    }

    @Override
    public void save(Grade entity) {
        entityManager.persist(entity);
    }

    @Override
    public void delete(Grade entity) {
        entityManager.remove(entity);
    }

    @Override
    public Grade findById(Long id) {
        return null;
    }

    @Override
    public List<Grade> getAll() {
        return entityManager.createNamedQuery("get-all-grades", Grade.class)
                .getResultList();
    }
}
