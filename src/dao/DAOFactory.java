package dao;

import dao.student.Impl.StudentDAOImpl;

/**
 * @author : Udara Deshan <udaradeshan.ud@gmail.com>
 * @since : 7/12/2022
 **/
public class DAOFactory {
    public enum DAOType {
        STUDENT
    }
    private static DAOFactory dAOFactory;

    public static DAOFactory getDAOFactory() {
        return (dAOFactory != null) ? dAOFactory : (dAOFactory = new DAOFactory());
    }

    public SuperDAO getSuperDAO(DAOType dAOType) {
        switch (dAOType) {
            case STUDENT:
                return new StudentDAOImpl();

            default:
                return null;
        }
    }

}
