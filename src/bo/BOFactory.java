package bo;

import bo.student.Impl.StudentBOImpl;

/**
 * @author : Udara Deshan <udaradeshan.ud@gmail.com>
 * @since : 7/12/2022
 **/
public class BOFactory {
    private static BOFactory bOFactory;

    public enum BOType {
        STUDENT
    }

    public static BOFactory getBOFactory() {
        return (bOFactory != null) ? bOFactory : (bOFactory = new BOFactory());
    }

    public SuperBO getSuperBO(BOType bOType) {
        switch (bOType) {
            case STUDENT:
                return new StudentBOImpl();

            default:
                return null;
        }
    }
}
