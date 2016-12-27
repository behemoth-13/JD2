package by.pvt;

import by.pvt.exception.InitException;

public interface SourceInit {
	
	void init() throws InitException ;
	
	void destroy();
}
