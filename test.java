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


// linked list merge recursive
public static <T exteds Integer> Cell<T> mergeRecursive(Cell<T> list1, Cell<T> list2) {
  if (list1 == null)
    return list2;
  else if (list2 == null)
    return list1;
  else if (list1.first.compareTo(list2.first) <= 0)
   return new Cell<>(list1.first, mergeRecursive(list1.next, list2));
  else
    return new Cell<>(list2.first, mergeRecursive(list1, list2.next));
}


// LINKED list
public static Cell<Integer> mergeIterative(Cell<Integer> list1, Cell<Integer> list2) {
  Cell<Integer> listHead = new Cell<>(null, null);
  Cell<Integer> listTail = listHead;
  Integer previous = null;

  while (list1 != null && list2 != null) {
      if (list1.first.equals(previous)) {
        list1 = list1.next;
      }
      else if (list2.first.equals(previous)) {
        list2 = list2.next;
      }
      else if (list1.first.compareTo(list2.first) <= 0) {
        listTail.next = new Cell<>(list1.first, null);
        previous = list1.first;
        list1 = list1.next;
        listTail = listTail.next;
      }
      else {
        listTail.next = new Cell<>(list2.first, null);
        previous = list2.first;
        list2 = list2.next
        listTail = listTail.next;
      }
  }

  listTail.next = list1 != null ? list1 : list2;
  return listHead.next;
}
