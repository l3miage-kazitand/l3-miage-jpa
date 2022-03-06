package fr.uga.im2ag.l3.miage.db.repository;

import fr.uga.im2ag.l3.miage.db.repository.api.TeacherRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TeacherTest extends Base {

    TeacherRepository teacherRepository;

    @BeforeEach
    void before() {
        teacherRepository = daoFactory.newTeacherRepository(entityManager);
    }

    @AfterEach
    void after() {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().rollback();
        }
    }

    @Test
    void shouldSaveTeacher()  {
        // TODO
        final var subject = Fixtures.createSubject();
        final var grade = Fixtures.createClass();
        final var favs = Fixtures.createStudent(grade);
        final var teacher = Fixtures.createTeacher(subject, grade, favs);

        entityManager.getTransaction().begin();
        teacherRepository.save(teacher);
        entityManager.getTransaction().commit();
        entityManager.detach(teacher);

        var pStudent = teacherRepository.findById(teacher.getId());
    }

    @Test
    void shouldFindHeadingGraduationClassByYearAndName() {
        // TODO
    }

}
