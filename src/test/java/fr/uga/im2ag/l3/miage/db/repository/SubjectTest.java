package fr.uga.im2ag.l3.miage.db.repository;

import fr.uga.im2ag.l3.miage.db.model.Subject;
import fr.uga.im2ag.l3.miage.db.model.Teacher;
import fr.uga.im2ag.l3.miage.db.repository.api.SubjectRepository;
import fr.uga.im2ag.l3.miage.db.repository.api.TeacherRepository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collection;

class SubjectTest extends Base {

    SubjectRepository subjectRepository;

    @BeforeEach
    void before() {
        subjectRepository = daoFactory.newSubjectRepository(entityManager);
    }

    @AfterEach
    void after() {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().rollback();
        }
    }

    @Test
    void shouldSaveSubject() {

        final var subject = Fixtures.createSubject();

        entityManager.getTransaction().begin();
        subjectRepository.save(subject);
        entityManager.getTransaction().commit();
        entityManager.detach(subject);

        var pSubject = subjectRepository.findById(subject.getId());
        assertThat(pSubject).isNotNull().isNotSameAs(subject);
        assertThat(pSubject.getName()).isEqualTo(subject.getName());

    }

    @Test
    void shouldFindTeachersForSubject() {
        final var subject = Fixtures.createSubject();
        final var grade = Fixtures.createClass();
        final var favs = Fixtures.createStudent(grade);
        final var teacher = Fixtures.createTeacher(subject, grade, favs);

        entityManager.getTransaction().begin();
        entityManager.persist(subject);
        entityManager.persist(grade);
        entityManager.persist(favs);
        entityManager.persist(teacher);
        entityManager.getTransaction().commit();
        entityManager.detach(teacher);

        var pSubject = (ArrayList<Teacher>) subjectRepository.findTeachers(subject.getId());
        ArrayList<Teacher> listTeacher = new ArrayList<>();
        listTeacher.add(teacher);
        assertThat(pSubject).isNotEmpty();
        assertThat(pSubject).isEqualTo(listTeacher);
    }
    // faut créer un Teacher, le save dans la bd, et après tu detach le Teacher que
    // t'as créé, tu récupère l'instance depuis la bd et tu compares (ils doivent
    // être pareil)
}
