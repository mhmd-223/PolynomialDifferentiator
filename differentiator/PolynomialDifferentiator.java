package chapter2.differentiator;

import java.util.Scanner;

public class PolynomialDifferentiator {
    private final Polynomial polynomial = new Polynomial();

    public PolynomialDifferentiator() {
        getInput();
    }

    public PolynomialDifferentiator(String polyInput) {
        parsePolynomial(polyInput);
    }

    public static void main(String[] args) {

    }

    private void validateTerm(String term) {
        if (!term.matches("[+-]?(\\d+\\.?\\d*)?(x(\\^\\d+)?)?")) {
            System.out.println("Invalid Term: " + term);
            System.exit(-1);
        }
    }

    private void getInput() {
        String infoMessage = """
                This program calculates the first derivative of a polynomial function expressed in standard form using the power rule of differentiation.
                Here are some instructions to consider before using the program:
                    - Standard form: The input polynomial function should be in the form f(x) = ax^n + bx^(n-1) + c*x^(n-2) + ... + d,
                      where a, b, c, and d are constants, x is the independent variable, and n is a positive integer value.
                    - Input format: The program assumes that the input polynomial function is expressed in the standard form specified.
                      Other forms of polynomial functions or non-polynomial functions may not work correctly with this program.
                    - Independent variable: The independent variable in the input function must be x.
                By following these instructions, you can ensure that the program works accurately and provides the correct first derivative of the polynomial function.
                                """;
        System.out.println(infoMessage);
        System.out.print("Enter f(x) = ");
        try (Scanner scanner = new Scanner(System.in)) {
            parsePolynomial(scanner.nextLine());
        }
    }

    private void parsePolynomial(String polyInput) {
        polyInput = polyInput.toLowerCase().replace(" ", "");
        String[] terms = polyInput.split("(?=[+-])");

        for (String term : terms) {
            validateTerm(term);

            int powerSignPos = term.indexOf('^');
            int variablePos = term.indexOf('x');
            float coefficient = 0f;
            int power = 0;

            // there is a power for x
            if (powerSignPos > 0) {
                if (variablePos >= 0) power = Integer.parseInt(term.substring(powerSignPos + 1));
            } else if (variablePos >= 0) power = 1;

            // in case of +x, -x
            if (variablePos == 0) coefficient = 1f;
            else if (variablePos == 1) {
                if (term.charAt(0) == '-')
                    coefficient = -1f;
                else if (term.charAt(0) == '+')
                    coefficient = 1f;
                else
                    coefficient = Float.parseFloat(term.substring(0, variablePos));
            } else if (variablePos > 0)
                coefficient = Float.parseFloat(term.substring(0, variablePos));

            polynomial.addTerm(power, coefficient);
        }
    }

    public Polynomial getFirstDerivative() {
        polynomial.differentiate();
        return polynomial;
    }

    public Polynomial getNthDerivative(int n) {
        polynomial.differentiate(n);
        return polynomial;
    }

    public double evaluate(float x) {
        return polynomial.evaluate(x);
    }

    @Override
    public String toString() {
        return "f(x) = " + polynomial;
    }
}

