package com.spycesoftware.util.loop;

public class Loop {
	private LoopThreat threat;
	private boolean running;
	private long loopCount;
	private long interval;
	private String name;
	private Runnable runnable;
	private LogMethod logMethod;
	private int maxRuns;
	
	public Loop(String name, long interval, Runnable runnable){
		this.interval = interval;
		this.runnable = runnable;
		this.name = name;
		logMethod = LogMethod.ALL;
		this.maxRuns = -1;
		
		threat = new LoopThreat(this);
	}
	
	public Loop(String name, long interval, Runnable runnable, LogMethod log){
		this.interval = interval;
		this.runnable = runnable;
		this.name = name;
		this.logMethod = log;
		this.maxRuns = -1;
		
		threat = new LoopThreat(this);
	}
	
	public Loop(String name, long interval, Runnable runnable, LogMethod log, int maxRuns){
		this.interval = interval;
		this.runnable = runnable;
		this.name = name;
		this.logMethod = log;
		this.maxRuns = maxRuns;
		
		threat = new LoopThreat(this);
	}
	
	
	public void start(){
		threat.start();
		threat.run();
		running = true;
		
		switch(logMethod){
		
		case ALL:
			System.out.println("Loop Threat " + name + " started!");
			System.out.println("Loop Threat " + name + " is starting with an interval of " + interval + " milliseconds");
		break;
		
		case START_STOP:
			System.out.println("Loop Threat " + name + " started!");
		break;
		default:
			break;
		}
		
	}
	
	public void stop(){
		
		running = false;
		switch(logMethod){
		
		case ALL:
			if(maxRuns == loopCount){
				System.out.println("Loop Threat " + name + " ran out!");
			}
			
			System.out.println("Loop Threat " + name + " is stopping!");
		break;
		
		case START_STOP:
			System.out.println("Loop Threat " + name + " is stopping!");
		break;
		default:
			break;
		}
		
	}
	
	public boolean isRunning(){
		return running;
	}
	
	public long getLoopCount(){
		return loopCount;
	}
	
	public long getInterval(){
		return interval;
	}
	
	public Runnable getRunnable(){
		return runnable;
	}
	
	public void setLogMethod(LogMethod log){
		this.logMethod = log;
	}
	
	public LogMethod getLogMethod(){
		return this.logMethod;
	}
	
	public void count(){
		loopCount++;
	}
	
	public String getName(){
		return name;
	}
	
	public int getMaxRuns(){
		return maxRuns;
	}
	
}
