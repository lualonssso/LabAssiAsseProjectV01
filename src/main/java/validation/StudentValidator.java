package validation;
import domain.Student;

public class StudentValidator implements Validator<Student> {
    public void validate(Student student) throws ValidationException {
        if (student.getID() == null || student.getID().equals("")|| student.getID().length()>100 ){
            throw new ValidationException("ID invalid! \n");
        }
        if (student.getNume() == null || student.getNume().equals("") || student.getID().length()>100) {
            throw new ValidationException("Nume invalid! \n");
        }
        if (student.getGrupa() <= 930 || student.getGrupa() >= 938) {
            throw new ValidationException("Grupa invalida! \n");
        }
    }
}

