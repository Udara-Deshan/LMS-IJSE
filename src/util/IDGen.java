package util;

/**
 * @author : Udara Deshan <udaradeshan.ud@gmail.com>
 * @since : 7/12/2022
 **/
public class IDGen {
    public enum TableName {
        STUDENT
    }

    private TableName tableName;
    private String prifix;
    private String column;

    public IDGen(TableName tableName) {
        switch (tableName) {
            case STUDENT:
                this.tableName = tableName;
                this.column = "studentId";
                this.prifix = "S";
                break;

        }
    }

    public String getNextID() throws Exception {
        return makeNextID(IDGenController.getLastID(String.valueOf(tableName), column));
    }

    private String makeNextID(String lastID) {
        if (lastID != null) {
            String[] arr = lastID.split(prifix);
            int i = Integer.parseInt(arr[1]) + 1;
            if (i < 10) {
                return prifix + "00" + i;
            } else if (i < 100) {
                return prifix + "0" + i;
            } else {
                return prifix + i;
            }
        } else {
            return prifix + "001";
        }
    }

}
