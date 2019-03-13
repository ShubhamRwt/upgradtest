package com.company;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class students{
    String decision;
    String name;
    float cgpa;
    String token;

    public String getName() {
        return name;
    }

    students(String decision, String name, float cgpa, String token){


         this.decision=decision;
        this.name=name;
         this.cgpa=cgpa;
         this.token=token;
    }
}

class cgpacompare implements Comparator<students> {

    @Override
    public int compare(students o1, students o2) {
        if(o1.cgpa<o2.cgpa){
        return 1;
        }
        if(o1.cgpa>o2.cgpa){
            return -1;
        }
        return 0;

    }
}
public class Upgrad {
    public static void main(String[] args) {

        Scanner s= new Scanner(System.in);
             int n=s.nextInt();

        PriorityQueue<students> pr=new PriorityQueue<students>(new cgpacompare());
        for (int i = 0; i <n ; i++) {

            String decision=s.next();

            if(decision.equals("ENTER")) {
                String name = s.next();
                float cgpa = s.nextFloat();
                String token = s.next();

                students st = new students(decision, name, cgpa, token);
                pr.add(st);
            }
            if(decision.equals("SERVED")){
                pr.remove();
            }

        }


        if(pr.isEmpty()){
            System.out.println("EMPTY");
        }

         else {
            while (!pr.isEmpty()) {
                System.out.println(pr.poll().getName());
            }
        }

    }
}

