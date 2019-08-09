package com.bkm.kys.types;

public enum Terminal {

    STATIC(1),
    POS(2),
    ATM(3),
    MOBILE(4),
    WEB(5);

    public int id;

    Terminal(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public int getTerminalType(String terminal){

        for (Terminal obj : Terminal.values())
            if ( obj.toString().equals(terminal) )
                return obj.id;

        return 0;
    }

}
