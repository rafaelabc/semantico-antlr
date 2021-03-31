package expression;

public class Adicao extends Expression {
    Expression left;
    Expression right;


    public Adicao(Expression left, Expression right){
        this.left=left;
        this.right=right;
    }

    @Override
    public String toString() {
        return left.toString()+" + "+right.toString();
    }

}
