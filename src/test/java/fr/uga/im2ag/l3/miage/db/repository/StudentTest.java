package fr.uga.im2ag.l3.miage.db.repository;

import fr.uga.im2ag.l3.miage.db.repository.api.StudentRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentTest extends Base {

    StudentRepository studentRepository;

    @BeforeEach
    void before() {
        studentRepository = daoFactory.newStudentRepository(entityManager);
    }

    @AfterEach
    void after() {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().rollback();
        }
    }

    @Test
    void shouldSaveStudent() {
        // TODO
        /*final var subject = Fixtures.createSubject();
        final var grade = Fixtures.createClass();
        final var student = Fixtures.createStudent(grade);

        entityManager.getTransaction().begin();
        studentRepository.save(student);
        entityManager.getTransaction().commit();
        entityManager.detach(subject);

        var pStudent = studentRepository.findById(student.getId());
        assertThat(pStudent).isNotNull();
        assertThat(pStudent).isEqualTo(student);*/
    }

    @Test
    void shouldFindStudentHavingGradeAverageAbove() {
        // TODO
    }

}
