# PolynomialDifferentiator

PolynomialDifferentiator is a Java class that calculates the first derivative of a polynomial function expressed in standard form using the power rule of differentiation.

## Usage

The PolynomialDifferentiator class can be used in two ways:

1. By default, when no argument is passed to the constructor, the user will be prompted to enter the polynomial function to be differentiated in the standard form.
2. Alternatively, the user can directly pass the polynomial function as a String argument to the constructor.

Once the polynomial function is parsed, the following methods are available to the user:

- `getFirstDerivative()` returns the first derivative of the polynomial.
- `getNthDerivative(int n)` returns the nth derivative of the polynomial.
- `evaluate(float x)` evaluates the polynomial for the given value of x.
- `toString()` returns the string representation of the polynomial.

## Input format

The program assumes that the input polynomial function is expressed in the standard form, which is defined as follows:

f(x) = ax^n + bx^(n-1) + c*x^(n-2) + ... + d,

where a, b, c, and d are constants, x is the independent variable, and n is a positive integer value.

The independent variable in the input function must be x. Other forms of polynomial functions or non-polynomial functions may not work correctly with this program.

## Example usage

```

// Example 1
PolynomialDifferentiator polyDiff = new PolynomialDifferentiator(" 4x^3 + 3x^2 - 2x + 1");
Polynomial firstDerivative = polyDiff.getFirstDerivative();
System.out.println("First derivative: " + firstDerivative); // Output: First derivative: 12x^2 + 6x - 2

// Example 2
PolynomialDifferentiator polyDiff2 = new PolynomialDifferentiator();
Polynomial nthDerivative = polyDiff2.getNthDerivative(3); // assume that user inputs 4x^3  
System.out.println("Third derivative: " + nthDerivative); // Output: Third derivative: 24

```

## Polynomial Class

This class represents a polynomial function in one variable. It allows for the addition of terms, differentiation, evaluation, and string representation.

### Fields

- `coefficients`: a Map that stores the coefficients for each power of X.
- `terms`: an ArrayList that stores the Term objects for each term in the polynomial. The terms are sorted in descending order of power.

### Methods

- `addTerm(int power, float coefficient)`: adds a term to the polynomial with the specified power and coefficient.
- `differentiate()`: differentiates the polynomial with respect to X.
- `differentiate(int degree)`: differentiates the polynomial degree times.
- `evaluate(float x)`: evaluates the polynomial at the specified value of X.
- `toString()`: returns a string representation of the polynomial.

### Term Class

This class represents a single term in the polynomial. It is used internally by the Polynomial class and should not be used directly.

### Fields

- `coefficient`: the coefficient of the term.
- `power`: the power of X in the term.
- `isPositive`: a boolean indicating whether the term is positive.

### Methods

- `differentiate()`: differentiates the term with respect to X.
- `toString()`: returns a string representation of the term.

**Note**: The Polynomial class sorts the Term objects in descending order of power, so the compareTo() method is used to implement this sorting.
