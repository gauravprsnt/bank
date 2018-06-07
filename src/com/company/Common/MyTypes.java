package com.company.Common;

public  final class MyTypes {
    public static String getMyType(int type) {
        switch (type) {
            case 0:
                return getEnumDetail(Type.COMMISSION_EMPLOYEE);
            case 1:
                return getEnumDetail(Type.SALARY_EMPLOYEE);
            case 2:
                return getEnumDetail(Type.HOURLY_EMPLOYEE);
            case 3:
                return getEnumDetail(Type.BASE_PLUS_COMMISSION_EMPLOYEE);
            case 4:
                return getEnumDetail(Type.BASESALARY_EMPLOYEE);
            default:
                return "Not found";
        }
    }

    private static String getEnumDetail(Type type) {
        return type.getKey()+" ("+type.getValue()+")";
    }
}
