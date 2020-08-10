package test;

import java.lang.Thread.State;

public class Program
{
	public static void main(String[] args) 
	{
		Thread thread = Thread.currentThread();
		String name = thread.getName();
		System.out.println("Thread Name	:	"+name);
		int priority = thread.getPriority();
		System.out.println("Thread Priority	:	"+priority);
		ThreadGroup grp = thread.getThreadGroup();
		System.out.println("Thread Group	:	"+grp.getName());
		State state = thread.getState();
		System.out.println("Thread State	:	"+state.name());
		boolean type = thread.isDaemon();
		System.out.println("Thread Type	:	"+(type? "Daemon Thread": "User Thread"));
		boolean status = thread.isAlive();
		System.out.println("Thread Status	:	"+(status? "Alive": "Dead"));
	}
	public static void main1(String[] args) 
	{
		Thread thread = Thread.currentThread();
		System.out.println(thread.toString());//Thread[main,5,main]
	}
}
