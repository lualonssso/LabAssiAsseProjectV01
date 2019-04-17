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
    /**
     * LAB 2
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();
        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");
        Service s = new Service(fileRepository1, fileRepository2, fileRepository3);

        assertEquals( 0, s.saveStudent("leie0131", "lucia", 933));
    }

    @Test
    public void shouldAnswerWithFalse()
    {
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();
        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");
        Service s = new Service(fileRepository1, fileRepository2, fileRepository3);

        assertNotEquals( 0, s.saveStudent("1", "ana", 221));
    }

    /**
     * LAB 4
     */

    @Test
    public void addStudentTestCase()
    {

    }
}
