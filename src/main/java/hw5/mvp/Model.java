package hw5.mvp;

public class Model {

    private int first;

    private int second;
    private String symbol;

    public void setFirst(int first) {
        this.first = first;
    }

    public void setSymbol(String symbol){this.symbol = symbol;}

    public void setSecond(int second) {
        this.second = second;
    }

    public int getSum() {
        return first + second;
    }
    public int getresult() {
        if (this.symbol.equals("+")){
            return getSum();
        } else if (this.symbol.equals("-")) {
            return getSub();
        }else if (this.symbol.equals("*")) {
            return getmult();
        }else if (this.symbol.equals("/")) {
            return getDiv();
        }else return 0;

    }
    public int getSub(){return first - second;}
    public int getmult(){return first * second;}
    public int getDiv(){return first / second;}

    public static void main(String[] args) {
        Model sumModel = new Model();
        Model subModel = new Model();
        Model multModel = new Model();
        Model divModel = new Model();

        sumModel.setFirst(1);
        sumModel.setSecond(1);
        if (sumModel.getSum() != 2) {
            throw new AssertionError("Incorrect test result");
        }
        sumModel.setFirst(1);
        sumModel.setSecond(2);
        if (sumModel.getSum() != 3) {
            throw new AssertionError("Incorrect test result");
        }

        subModel.setFirst(1);
        subModel.setSecond(1);
        if (subModel.getSub() != 0) {
            throw new AssertionError("Incorrect test result");
        }
        subModel.setFirst(2);
        subModel.setSecond(1);
        if (subModel.getSub() != 1) {
            throw new AssertionError("Incorrect test result");
        }
        multModel.setFirst(1);
        multModel.setSecond(1);
        if (multModel.getmult() != 1) {
            throw new AssertionError("Incorrect test result");
        }
        multModel.setFirst(2);
        multModel.setSecond(2);
        if (multModel.getmult() != 4) {
            throw new AssertionError("Incorrect test result");
        }
        divModel.setFirst(2);
        divModel.setSecond(1);
        if (divModel.getDiv() != 2) {
            throw new AssertionError("Incorrect test result");
        }
        divModel.setFirst(6);
        divModel.setSecond(2);
        if (divModel.getDiv() != 3) {
            throw new AssertionError("Incorrect test result");
        }


    }
}
