# DATA MINING - LAB 4

## 1 - DECISION TREES
**Pruned case:**
1.  *Number of leaves*: 61
2.  *Size of Tree*: 93
3.  *Test Accuracy*: 90.5172%

**Unpruned case:**
1.  *Number of Leaves*: 121
2.  *Size of Tree*: 175
3.  *Test Accuracy*: 86.6379%

Tree pruning eliminates nodes in the tree with little significance for
classification. This improves predictive accuracy because it reduces
over-fitting. This is why the pruned case has less nodes and better predictive
accuracy.


## 2 - DATA PROPORTIONS WITH MAXENT VS NAIVE BAYES
4.  MaxEnt accuracy is `0.80,  0.83` for train, test. There are 25 data points
    in each class. The **minority class** (class 3) is detected with 0.2
    accuracy. The normalized confusion matrix is

    | Classified as A | Classified as B | Classified as C | Actual class |
    |-----------------|-----------------|-----------------| -------------|
    | 1.0             | 0               | 0               | Class A      |
    | 0               | 1.0             | 0               | Class B      |
    | 0               | 0.8             | 0.2             | Class C      |

    Class C is confused with class B.

5.  The new accuracy is 0.12. This is because the frequency of data points
    on either side of the classification boundaries has changed, and this time
    a greater portion of data happens to be on the wrong side of the boundaries
    that were established by training on a different dataset. Thus the
    classifier fails to generalize well to datasets with different relative
    frequencies of classes.
8.  Set the actual frequencies of the classes in the dataset as the priors.
    That is, 25/65, 6/65, and 25/65. This obtains an accuracy of 0.96 for class
    A, 0 for class B, and 1 for class C. Overall accuracy is 0.88.


## 3 - SCALING WITH N OF DIMENSIONS
4.  The train and test errors on 200-dimensional data are as follows:

    | Train Error | Test Error | Classifier |
    |-------------|------------|------------|
    | 1.0         | 0.86       | LR         |
    | 1.0         | 1.0        | NB         |

    For high-dimensional data, LR is prone to over-fitting. Naive Bayes works
    well for high-dimensional data because of the naive assumption of features
    being conditionally independent makes the model less expressive and thus
    less prone to overfitting.
