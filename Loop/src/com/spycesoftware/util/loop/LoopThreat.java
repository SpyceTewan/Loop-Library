package com.spycesoftware.util.loop;

public class LoopThreat extends Thread{
	private Loop loop;
	
	public LoopThreat(Loop loop){
		this.loop = loop;
	}
	
	@Override
	public void run() {
		
		while(loop.isRunning()){
			if(loop.getLoopCount() < loop.getMaxRuns() || loop.getMaxRuns() == -1){
				try {
					Thread.sleep(loop.getInterval());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			
				loop.getRunnable().run();
				loop.count();
			
				switch(loop.getLogMethod()){
					case ALL:
						System.out.println("Loop Threat " + loop.getName() + " executed");
						System.out.println("Loop Threat " + loop.getName() + " count: " + loop.getLoopCount());
						System.out.println("Loop Threat " + loop.getName() + " waited " + loop.getInterval() + " milliseconds");
					break;
				
					case COUNTER:
						System.out.println("Loop Threat " + loop.getName() + " count: " + loop.getLoopCount());
						break;
				
					case NOTHING:
					break;
					default:
					break;
			
				
				}	
			}else{
				loop.stop();
				
			}
		}
		super.run();
	}
}
