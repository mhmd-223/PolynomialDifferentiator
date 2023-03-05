package chapter2.differentiator;

class PolynomialDifferentiatorTest {
    public static void testPolynomialDifferentiator() {
        // Test case 1
        PolynomialDifferentiator pd = new PolynomialDifferentiator("x^2 + 2x + 1");
        assert "2.0X + 2.0".equals(pd.getFirstDerivative().toString());

        // Test case 2
        pd = new PolynomialDifferentiator(" 3x^4 - 2x^3 + 5x^2 - 6x + 2");
        assert "12.0X^3 - 6.0X^2 + 10.0X - 6.0".equals(pd.getFirstDerivative().toString());

        // Test case 3
        pd = new PolynomialDifferentiator("12x^5 + 3x^4 - 5x^3 + 7x^2 - 9x + 2");
        assert "240.0X^3 + 36.0X^2 - 30.0X + 14.0".equals(pd.getNthDerivative(2).toString());

        // Test case 4
        Polynomial p = new Polynomial();
        p.addTerm(3, 2.0f);
        p.addTerm(2, 4.0f);
        p.addTerm(1, -1.0f);
        p.addTerm(0, 5.0f);
        assert p.evaluate(2.0f) == 35.0;

        // Test case 5
        p = new Polynomial();
        p.addTerm(2, 3.0f);
        p.addTerm(1, -2.0f);
        p.addTerm(0, 1.0f);
        p.differentiate();
        assert p.toString().equals("6.0X - 2.0");

        // Test case 6
        p = new Polynomial();
        p.addTerm(3, 2.0f);
        p.addTerm(2, 4.0f);
        p.addTerm(1, -1.0f);
        p.addTerm(0, 5.0f);
        p.differentiate(2);
        assert p.toString().equals("12.0X + 8.0");

        System.out.println("All test cases passed.");
    }

    public static void main(String[] args) {
        testPolynomialDifferentiator();
    }
}
