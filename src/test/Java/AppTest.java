import domain.Nota;
import domain.Student;
import domain.Tema;
import org.junit.Test;
import repository.NotaXMLRepository;
import repository.StudentXMLRepository;
import repository.TemaXMLRepository;
import service.*;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;
import validation.Validator;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 * C:\Users\PortatilPapa2\Desktop\LabAssiAsseProjectV01\src\main\java\test\AppTest.java
 */
public class AppTest
{

    Validator<Student> studentValidator = new StudentValidator();
    Validator<Tema> temaValidator = new TemaValidator();
    Validator<Nota> notaValidator = new NotaValidator();
    StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
    TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
    NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");
    Service s = new Service(fileRepository1, fileRepository2, fileRepository3);

    /**
     * LAB 2
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertEquals( 0, s.saveStudent("leie0131", "lucia", 933));
    }

    @Test
    public void shouldAnswerWithFalse()
    {
        assertNotEquals( 0, s.saveStudent("1", "ana", 221));
    }

    /**
     * LAB 3 IN CLASS
     */

    @Test //no error
    public void testCaseAssignmentTrue()
    {
        assertEquals( 0, s.saveTema("Assignment1", "descrrffgf", 4, 2));
    }

    @Test  //error
    public void testCaseAssignmentFalse()
    {
        assertNotEquals( 0, s.saveTema("assign", "description", 2, 3));
    }

    /**
     * LAB 3 TAKE HOME
     */

    @Test
    public void testCase1()
    {
        assertEquals( 1, s.saveTema("", "descrrffgf", 4, 1));
    }

    @Test
    public void testCase2()
    {
        assertEquals( 1, s.saveTema("assign", "", 4, 1));
    }

    @Test
    public void testCase3()
    {
        assertEquals( 1, s.saveTema("assign", "descrrffgf", -1, 1));
    }

    @Test
    public void testCase4()
    {
        assertEquals( 1, s.saveTema("assign", "descrrffgf", 1, 6));
    }

    @Test
    public void testCase5()
    {
        assertNotEquals( 1, s.saveTema("assign", "descrrffgf", 5, 1));
    }

    @Test
    public void testCase6()
    {
        assertNotEquals( 1, s.saveTema("assign", "descrrffgf", 5, 1));
    }

    /**
     * LAB 4 IN CLASS
     */

    @Test
    public void addStudentTestCase()
    {
        assertEquals(0, s.saveStudent("aaa", "bbb", 933));
    }

    @Test
    public void addAssignmentTestCase()
    {
        assertEquals(0, s.saveTema("aaa", "description", 4, 3));
    }

    @Test
    public void addGradetTestCase()
    {
        assertNotEquals(0, s.saveNota("aaa", "aaa", 9.9, 3, "well"));
    }

    @Test
    public void integrationTestCase()
    {
        addStudentTestCase();
        addAssignmentTestCase();
        addGradetTestCase();
    }

    /**
     * LAB 4 TAKE HOME
     */

    @Test
    public void addStudentTestCase1()
    {

        assertEquals(0, s.saveStudent("laei", "lucia", 933));
    }

    @Test
    public void addAssignmentIntegrationTestCase()
    {
        addStudentTestCase1();

        assertEquals(0, s.saveTema("assign1", "description", 4, 3));
    }

    @Test
    public void addGradetIntegrationTestCase()
    {
        addStudentTestCase1();
        addAssignmentIntegrationTestCase();

        assertNotEquals(0, s.saveNota("laei", "description", 9, 3, "good"));
    }


}


