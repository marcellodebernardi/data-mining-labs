# DATA MINING - LAB 3

## 1 - CLASSIFICATION IN WEKA
The correctly and incorrectly classified instances are:
Correctly Classified Instances         700               70      %
Incorrectly Classified Instances       300               30      %

The "good" instances were all correctly classified. The "bad" instances
were all incorrectly classified.

The new confusion matrix is as follows:
  a   b   <-- classified as
  700   0 |   a = good
  300   0 |   b = bad

Every single instance in the dataset was classified as "good". With K = 999,
when classifying each instance the algorithm looks at all other instances.
Since the dataset contains more "good" lenders than "bad" lenders, it is
always the case that the majority of the K instances looked at are "good".


## 2 - MAXENT CLASSIFICATION

4.  Using the classification hypothesis from Cell 2 and a looser range, first
    identified that the best value for both w2 and w3 were somewhere between
    4 and 6. Narrowed it down with a tighter range. Then applied following range:

    ```
    lw0 = -1:0.05:1;
    lw1 = 5.3:0.05:5.5;
    lw2 = 4.3:0.05:4.5;
    ```
    Which obtained following result:
    ```
    Best Weights Found: -0.050,5.350,4.400.
    Train acc: 0.81
    Test acc: 0.83
    ```
    The loop executed 1000 times (40 * 5 * 5).

5.  After one run of Cell 4b, the new weights are
  ```
  [0.066543178776321,1.222607395813489,1.677419405413738]
  ```

  The training accuracy is now 0.76.

6.  It was evaluated 8 times. This is much lower than the 1000 iterations
    used in exhaustive search. Gradient descent is a better optimization
    strategy than exhaustive search.

## 3 - MAXENT VS KNN

The accuracy values for different K values are below:

```
K=1. Train acc: 1.00
K=1. Test acc: 0.72
K=2. Train acc: 0.84
K=2. Test acc: 0.72
K=3. Train acc: 0.79
K=3. Test acc: 0.73
K=4. Train acc: 0.74
K=4. Test acc: 0.73
K=5. Train acc: 0.74
K=5. Test acc: 0.74
K=6. Train acc: 0.73
K=6. Test acc: 0.75
K=7. Train acc: 0.78
K=7. Test acc: 0.73
K=8. Train acc: 0.74
K=8. Test acc: 0.71
K=9. Train acc: 0.74
K=9. Test acc: 0.70
```

The best train accuracy is obtained by K=1. The best test accuracy is
obtained with K=6.
