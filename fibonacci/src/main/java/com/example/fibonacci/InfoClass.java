package com.example.fibonacci;

public class InfoClass {
    private final String number;
    public InfoClass(String number){
        this.number = number;
    }
    public String getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null) return false;
        if(getClass()!=o.getClass()) return false;
        InfoClass dataClass = (InfoClass) o;
        return this.number.equals(((InfoClass) o).number) ;
    }
    @Override
    public int hashCode(){
        int res = 1;
        res = 31*res + number.hashCode();
        return res;
    }
}
