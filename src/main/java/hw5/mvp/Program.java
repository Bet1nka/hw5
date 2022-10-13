package hw5.mvp;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Model resultModel = new Model();
        View view = new ViewImpl(scn, System.out);
        Presenter presenter = new Presenter(resultModel, view);
        presenter.execute();
    }
}
