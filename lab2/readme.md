# DATA MINING LAB 2

## 1 - REGRESSION AND OVERFITTING
9.  Higher-order polynomials match the distribution more closely, with the
    greatest decrease in train SSE occurring when moving from a second
    degree polynomial to a third degree polynomial.
13.
    a.  The lowest **training SSE** is achieved by the degree 8 polynomial.
        The lowest **eval SSE** is achieved by the degree 3 polynomial.
    b.  The **train SSE** decreases steeply for the first 3 polynomial degrees,
        and continues to slowly decrease as the polynomial degree increases.
        The **eval SSE** quickly reaches a minimum at degree 3, and then slowly
        increases with the polynomial degree. The ratio of evaluation error
        over training error reaches a minimum at degree 3, and steadily
        increases after that point.
    c.  This is because of **overfitting**. After degree 3, increasing the
        polynomial order of the model makes the model match the training data
        even more closely, which makes it generalize more poorly on new data
        sets.


## 2 - REGULARIZATION
