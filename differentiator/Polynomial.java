package differentiator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Polynomial {
    private final Map<Integer, Float> coefficients;
    private final ArrayList<Term> terms;

    public Polynomial() {
        coefficients = new HashMap<>();
        terms = new ArrayList<>();
    }

    public void addTerm(int power, float coefficient) {
        coefficients.put(power, coefficients.getOrDefault(power, 0f) + coefficient);
        combineTerms();
    }

    private void combineTerms() {
        terms.clear();
        coefficients.forEach((power, coefficient) -> terms.add(new Term(power, coefficient)));
        Collections.sort(terms);
    }

    public void differentiate() {
        for (Term term : terms) {
            term.differentiate();
        }
        coefficients.clear();
        terms.forEach(term -> coefficients.put(term.power, term.coefficient));
    }

    public void differentiate(int degree) {
        if (degree < 1)
            return;
        differentiate(degree - 1);
        differentiate();
    }

    public double evaluate(float x) {
        double result = 0.0;
        for (Term term : terms) {
            double termValue = term.coefficient;
            for (int i = 0; i < term.power; i++) {
                termValue *= x;
            }
            if (!term.isPositive) {
                termValue *= -1;
            }
            result += termValue;
        }
        return result;
    }


    @Override
    public String toString() {
        final StringBuilder polynomial = new StringBuilder();
        polynomial.append(terms.get(0));
        for (int i = 1, size = terms.size(); i < size; i++) {
            Term term = terms.get(i);
            if (term.coefficient == 0) continue;
            polynomial.append(term.isPositive ? " + " : " - ");
            polynomial.append(term);
        }
        return polynomial.toString();
    }

    private static class Term implements Comparable<Term> {
        float coefficient;
        int power;
        boolean isPositive;

        public Term(int power, float coefficient) {
            this.power = power;
            isPositive = coefficient > 0;
            this.coefficient = Math.abs(coefficient);
        }

        void differentiate() {
            if (power >= 0) {
                coefficient *= power;
                power--;
            }
        }

        @Override
        public String toString() {
            if (coefficient == 0) return "0.0";
            if (power == 0) return String.valueOf(coefficient);
            if (power == 1) return coefficient + "X";
            return coefficient + "X^" + power;
        }

        @Override
        public int compareTo(Term o) {
            return o.power - this.power;
        }

    }
}
