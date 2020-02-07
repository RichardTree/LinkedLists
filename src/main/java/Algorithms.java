
import java.util.ArrayList;

public class Algorithms {

  public static ArrayList<Integer> getUnsortedList () {
    ArrayList<Integer> list = new ArrayList<>();

    list.add(4);
    list.add(1);
    list.add(2);
    list.add(5);
    list.add(3);

    return list;
  }

  public static void main(String[] args) {
    System.out.println("Merge Sort: " + Algorithms.mergeSort(getUnsortedList()).toString());
    System.out.println("Selection Sort: "+ Algorithms.selectionSort(getUnsortedList()).toString());
    System.out.println("Insertion Sort: "+ Algorithms.insertionSort(getUnsortedList()).toString());


  }
  public static ArrayList<Integer> selectionSort (ArrayList<Integer> list){
    int inputLength = list.size();

    for (int i = 0; i < inputLength-1; i++) {

      int minElement = i;

      for (int rightOfMinElement = i+1; rightOfMinElement < list.size(); rightOfMinElement++){
        if (list.get(rightOfMinElement) < list.get(minElement)){
          minElement = rightOfMinElement;
        }
      }
      int elemntToSwap = list.get(minElement);
      list.set(minElement, list.get(i));
      list.set(i, elemntToSwap);
    }
    return list;
  }

  public static ArrayList<Integer> mergeSort (ArrayList<Integer> list) {
    if (list.size() <= 1){
      return list;
    }


    int middleOfArray = list.size()/2;
    ArrayList<Integer> leftSide = new ArrayList<>(list.subList(0, middleOfArray));
    ArrayList<Integer> rightSide = new ArrayList<>(list.subList(middleOfArray, list.size()));

    mergeSort(leftSide);
    mergeSort(rightSide);


    mergeLists(leftSide,rightSide,list);
    return list;
  }

  public static void mergeLists (ArrayList<Integer> leftSide, ArrayList<Integer> rightSide, ArrayList<Integer> outcomeList) {

    int leftIndex = 0;
    int rightIndex = 0;
    int mergedIndex = 0;

    outcomeList.clear();
    while (leftIndex < leftSide.size() && rightIndex < rightSide.size()) {
      if (leftSide.get(leftIndex) <= rightSide.get(rightIndex)) {
        outcomeList.add(mergedIndex, leftSide.get(leftIndex++));
      }
      else {
        outcomeList.add(mergedIndex, rightSide.get(rightIndex++));
      }
      mergedIndex++;
    }

    while (leftIndex < leftSide.size()) {
      outcomeList.add(mergedIndex++, leftSide.get(leftIndex++));
    }

    while (rightIndex < rightSide.size()) {
      outcomeList.add(mergedIndex++, rightSide.get(rightIndex++));
    }
  }

  public static ArrayList<Integer> insertionSort (ArrayList<Integer> inputList) {



    for (int i = 1; i < inputList.size(); i++){
      int key = inputList.get(i);
      int index = i-1;

      while (index >= 0 && inputList.get(index) > key) {

        inputList.set(index+1, inputList.get(index));
        index=index-1;
      }
      inputList.set(index+1, key);
    }
    return inputList;
  }

}
