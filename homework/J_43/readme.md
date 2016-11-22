#J.43
Using the observer pattern create a simple GUI for J.33.  
Your Subject class will be the bridge.  

One Observer/Client classes will consist of a JProgressBar in your GUI which, for the current Woolies on the Bridge, displays time spent crossing divided by total time needed to cross.  The JProgressBar may go back and forth depending on which Woolies enter and exit the bridge. 

A second Observer/Client class will write a Troll's Log File to disk that logs for all events (entering, exiting, who, destination, and what time) which occur on the bridge, in case he gets audited, there should be one file saved per calendar day.  

A third Observer/Client class will turn the GUI green whenever the bridge is empty and yellow whenever there is a Woolie on it.
