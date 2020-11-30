import java.util.*;
public class test{
  public static void main(String[] args){
    int a[] = {5,3,7,10,8,2};
    for(int i=1;i<a.length;i++){
      int key=a[i];
      int j=i-1;
      while(j>=0 && a[j]>key){
        a[j+1]=a[j];
        j--;
      }
      a[j+1]=key;
    }
    for(int i: a){ 
    System.out.print(i+" ");
    }
  }
}

