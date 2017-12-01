# DATA MINING - LAB 5

## 1 - FEATURE SELECTION
3.  Removal of attributes is done at each turn by checking which attributes
    results in the best accuracy once removed. The table is below:

    | Subset Size | Attributes Selected    | Accuracy | Attributes Removed |
    |-------------|------------------------|----------|--------------------|
    | 5           | W, P, Hol, Vac, Health | 85.9%    | None               |
    | 4           | W, P, Hol, Health      | 89.5%    | Vac                |
    | 3           | W, P, Hol              | 91.2%    | Health             |
    | 2           | W, P                   | 85.0%    | Hol                |
    | 1           | P                      | 80.7%    | W                  |

    **The best accuracy is obtained with a subset of size 3, with attributes
    W, P, Hol.**

4.  Weka's **GreedyStepwise** with backwards selection replicates the procedure
    above. The selected attributes are `wage-increase-first-year`, `pension`, and
    `statutory-holidays`. **This matches Q3**. With forward selection, the
    selected attributes are `pension` and `contribution-to-health-plan`.

5.  The picket attributes are `petallength` and `petalwidth`. All the rest
    are discarded, i.e. `sepallength`, `sepalwidth`, and all their copies.


## 2 - DIMENSIONALITY REDUCTION
8.  The required number of PCs according to the eigenvalue plot is 56. This
    matches the results from Q2.6, where setting the variable `nPCA` to
    values between 54 and 58 first achieves 99% reconstruction accuracy.
9.  Found 71% accuracy at 27. 71% is also achieved with other numbers of
    PCA dimensions, but 27 is the lowest numbers at which this occurs. **This
    is not as accurate as classification of raw images**, but is computationally
    much less intensive.
