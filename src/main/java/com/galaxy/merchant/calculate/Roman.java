package com.galaxy.merchant.calculate;

public enum Roman {
    I(1),
    V(5),
    X(10),
    L(50),
    C(100),
    D(500),
    M(1000);

    private int value;

    Roman(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static String tryParse(String name) {
        for (Roman roman : Roman.values()) {
            if (roman.name().equalsIgnoreCase(name)) {
                return roman.name();
            }
        }
        return null;
    }

    public static int getValueFromRoman(char romanChar) {
        int value = -1;

        switch (romanChar) {
            case 'I':
                value = Roman.I.getValue();
                break;
            case 'V':
                value = Roman.V.getValue();
                break;
            case 'X':
                value = Roman.X.getValue();
                break;
            case 'L':
                value = Roman.L.getValue();
                break;

            case 'C':
                value = Roman.C.getValue();
                break;

            case 'D':
                value = Roman.D.getValue();
                break;

            case 'M':
                value = Roman.M.getValue();
                break;
            default:
                return value;
        }

        return value;
    }
}
