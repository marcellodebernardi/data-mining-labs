# DATA MINING LAB 2

## 1 - REGRESSION AND OVERFITTING
9.  Higher-order polynomials match the distribution more closely, with the
    greatest decrease in train SSE occurring when moving from a second
    degree polynomial to a third degree polynomial.
13.
    1.  The lowest **training SSE** is achieved by the degree 8 polynomial.
        The lowest **eval SSE** is achieved by the degree 3 polynomial.
    2.  The **train SSE** decreases steeply for the first 3 polynomial degrees,
        and continues to slowly decrease as the polynomial degree increases.
        The **eval SSE** quickly reaches a minimum at degree 3, and then slowly
        increases with the polynomial degree. The ratio of evaluation error
        over training error reaches a minimum at degree 3, and steadily
        increases after that point.
    3.  This is because of **overfitting**. After degree 3, increasing the
        polynomial order of the model makes the model match the training data
        even more closely, which makes it generalize more poorly on new data
        sets.


## 2 - REGULARIZATION
7.  
    1.  Lambda 0.001 has a sum squared value of 8.5041
        Lambda 1 has a sum squared value of 0.7394
    2.  For a higher lambda value, more regularization is being applied to
        the model parameters. So with lambda one the sum squared value is lower
        because the parameters (weights) are smaller.
8.  | Best Fit Lambda  | Min Train Error | Corresponding Lambda | Corresponding Test Error |
    | -----------------|-----------------|----------------------|--------------------------|
    | Order 9 Data 10  | 0.06            | 0.001                | 3.18                     |
    | Order 9 Data 100 | 0.84            | 0.001                | 0.31                     |

    1.  In the first row the minimum train error is achieved with the smallest
        lambda value. The test error is smaller for larger lambda values.
    3.  The test error grows with smaller lambda values. This is because of
        overfitting. Regularization is supposed to prevent overfitting. With
        small lambda values, a higher degree of overfitting occurs and so the
        model doesn't generalize well to new data, and the test error increases.


## 3 - CROSS VALIDATION
5.  The correct line to use is SSE = sum((yvalset - phival*w_map).^2);
    This is because the training set is used for training, the validation
    set is used for adjusting the lambda parameter, and the test set is used
    at the end to determine the quality of the model.
    The final train and test errors are 0.133 and 0.268, respectively.


## 4 - MULTIVARIATE REGRESSION
7.  Training MAE: 4229.4683
    10-fold crossvalidation test error: 4336.8976
    2-fold crossvalidation test error: 4381.3868
    50-split test error: 4434.8517
8.  Training MAE: 2968.1157
    2-fold crossvalidation test error: 3453.2504
    50-split test error: 3469.4293

    The training error is lower than the testing error, presumably because
    the strong non-linear model fits the data much better.
