public static LispList<Integer> filter(LispList<Integer> list, int threshold) {
  if (list.isEmpty()) return list;
  else if (list.head() < threshold) return filter(list.tail(), threshold);
  else return filter(list.tail(), threshold).cons(list.head());
}


// EXERCISE 4
public static LispList<Integer> multiply(LispList<Integer> list, int scalar) {
  if (list.isEmpty()) return list;
  else return multiply(list.tail(), scalar).cons(list.head() * scalar);
}


// EXERCISE 5
public static LispList<Integer> after(LispList<Integer> list, int target) {
  if (list.isEmpty()) return list;
  else if (list.head() == target) return list.tail();
  else return after(list, target);
}


// EXERCISE 6
public static LispList<Integer> positions(LispList<Integer> list, int target) {
  return positionsHelper(list, target, 0);
}

private static LispList<Integer> positionsHelper(LispList<Integer> list, int target, int position) {
  if (list.isEmpty()) return LispList.empty();
  else if (list.head() == target) return positionsHelper(list.tail(), target, position + 1).cons(position);
  else return positionsHelper(list.tail(), target, position + 1);
}


// EXERCISE 7
public static LispList<Integer> removePos(LispList<Integer> list, int position) {
  if (list.isEmpty()) return list;
  else if (position == 0) return list.tail();
  else return removePos(list, position - 1).cons(list.head());
}


// EXERCISE 8
public static boolean sublist(LispList<Integer> sublist, LispList<Integer> superlist) {
  if (sublist.isEmpty()) return true;
  else if (superlist.isEmpty()) return false;
  else if (sublist.head() == superlist.head() && sublist(sublist.tail(), superlist.tail())) return true;
  else return sublist(sublist, superlist.tail());
}


// EXERCISE 9
public static boolean isSubset(LispList<Integer> subset, LispList<Integer> superset) {
  Set<Integer> supersetCopy = new HashSet<>();

  for (; !superset.isEmpty(); superset = superset.tail())
    supersetCopy.add(superset.head());

  for (; !subset.isEmpty(); subset = subset.tail())
    if (!supersetCopy.contains(subset.head())) return false;

  return true;
}

// EXERCISE 9
public static boolean isSubset(LispList<Integer> subset, LispList<Integer> superset) {
  if subset.isEmpty() return true;
  else if (superset.isEmpty()) return false;
  else return isIn(subset.head(), superset) && isSubset(subset.tail(), superset);
}

private static boolean isIn(int element, LispList<Integer> list) {
  if (list.isEmpty()) return false;
  else return list.head() == element || isIn(element, list.tail())
}
