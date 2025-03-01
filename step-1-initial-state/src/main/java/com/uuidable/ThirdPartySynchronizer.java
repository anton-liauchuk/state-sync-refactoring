package com.uuidable;

public interface ThirdPartySynchronizer {
	void schedule(String id);
	void unschedule(String id);
}
