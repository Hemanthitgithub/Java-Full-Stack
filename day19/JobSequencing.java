package day19;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Job{
	int Id,Deadline, Profit;
	
	Job(int Id,int Deadline,int Profit){
		this.Id = Id;
		this.Deadline = Deadline;
		this.Profit = Profit;
	}
}
public class JobSequencing {
	
	public static List<Job> jobSequencing(List<Job> jobs){
		Collections.sort(jobs,(a,b)-> b.Profit -a.Profit);
		boolean[] slots = new boolean[100];
		List<Job>result = new ArrayList<>();
		
		for(Job job : jobs) {
			for(int i = Math.min(job.Deadline -1,slots.length -1);i>=0;i--) {
				if(!slots[i]) {
					slots[i] = true;
					result.add(job);
					break;
				}
			}
		}
			return result;
		}
		
	public static void main(String[] args) {
		List<Job> jobs = new ArrayList<>();
		jobs.add(new Job(1,4,20));
		jobs.add(new Job(2,1,30));
		jobs.add(new Job(3,1,40));
		jobs.add(new Job(4,2,50));
		
		List<Job> jobSequence = jobSequencing(jobs);
		System.out.println("The sequence of jobs to maximize profit is:");
		for(Job job : jobSequence) {
			System.out.println("Job ID:"+job.Id +",Deadline:"+job.Deadline+",Profit:"+job.Profit);
		}
	}
}
	
		