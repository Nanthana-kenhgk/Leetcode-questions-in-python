// Problem: 1700. Count number of students who are unable to eat lunch
// A queue represents students' sandwich preferences (0 - circular, 1 - square)
// An array represents the stack of sandwiches in order
// If the student at front of the queue doesn't want the sandwich at the top, 
// they go to the end of the queue. Otherwise, both student and sandwich are removed.
class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        //Creates a queue to simulate the students' queue
        Queue <Integer> queue = new LinkedList<>();
        for(int i=0;i<students.length;i++){
            queue.add(students[i]);          //Enqueues the students' preferences into the queue
        }
        int count = 0; //tracks students who didn't take the sandwich
        int start = 0; //index that represents the start or top of the sandwich array
        int removed = 0; //Temporarily stores the removed student
        do{
            //Edge case: The queue is empty
            if(queue.isEmpty()){
                return 0;
            }
            removed = queue.remove();
            if(sandwiches[start]==removed){  // The student takes the sandwich
                start++;     // Move to the next sandwich
                count = 0;   // Reset the counter
            }
            else{                    // The student refuses the sandwich and goes to the back of the queue
                count++;
                queue.add(removed);
            }
        }while(count<=queue.size());
        //returns the number of students who did not eat lunch
        return count-1;
    }
}
