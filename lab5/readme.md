# DATA MINING - LAB 5

## 1 - FEATURE SELECTION
2.  The most informative ones seem to be `pension` and
    `contribution-to-health-plan`. The least informative is
    `statutory-holidays`.

3.  Removal of attributes is done at each turn by checking which attributes
    results in the best accuracy once removed.

    | Subset Size | Attributes Selected    | Accuracy | Attributes Removed |
    |-------------|------------------------|----------|--------------------|
    | 5           | W, P, Hol, Vac, Health | 85.9%    | None               |
    | 4           | W, P, Hol, Health      | 89.5%    | Vac                |
    | 3           | W, P, Hol              | 91.2%    | Health             |
    | 2           | W, P                   | 85.0%    | Hol                |
    | 1           | P                      | 80.7%    | W                  |

    This result in trying 5 + 4 + 3 + 2 = 14 combinations. In total there are
    C(5,5) + C(5,4) + C(5,3) + C(5,2) + C(5,1) combinations. An example of an
    untried combination is `[P, Hol, Vac]`.

4.  The ranking is `wage-increase-first-year`, `statutory-holidays`,
    `contribution-to-health-plan`, `vacation`, `pension`. For chi squared,
    the ranking is `pension`, `wage-increase-first-year`, `statutory-holidays`,
    `contribution-to-health-plan`, `vacation`.

    The selected attributes are `wage-increase-first-year`, `pension`, and
    `statutory-holidays`. This matches Q3. With forward selection, the selected
    attributes are `pension` and `contribution-to-health-plan`.

5.  todo


## 2 - DIMENSIONALITY REDUCTION
5.  Glasses appeared first at PCA 8 or 9. The reconstruction error first drops
    to 0.009 at 58 PCs. **The required number of PCs according to the
    eigenvalue plot is 56, this matches the previous question**.
6.  Found 71% accuracy at 27.
