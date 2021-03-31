package expression;

public class Numero extends Expression{
    float fvalue;
    int ivalue;


    public Numero(int value){
        this.ivalue=value;
        this.type="int";
    }

    public Numero(float value){
        this.fvalue=value;
        this.type="float";
    }

    @Override
    public String toString() {
        if (type.equals("int")) {
            return Integer.toString(ivalue);
        }
        else {
            return Float.toString(fvalue);
        }
    }
}
