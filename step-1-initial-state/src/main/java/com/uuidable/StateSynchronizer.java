package com.uuidable;

public class StateSynchronizer {

	private final InternalSynchronizer internalSynchronizer;
	private final ThirdPartySynchronizer thirdPartySynchronizer;

	public StateSynchronizer(InternalSynchronizer internalSynchronizer, ThirdPartySynchronizer thirdPartySynchronizer) {
		this.internalSynchronizer = internalSynchronizer;
		this.thirdPartySynchronizer = thirdPartySynchronizer;
	}

	public void synchronize(Setup setup, InternalState internalState, boolean forceUpdate) {
		if (forceUpdate) {
			if (!InternalState.REMOVED.equals(internalState)) {
				internalSynchronizer.remove(setup.id());
			}

			if (setup.thirdPartySyncRequired() && DesiredState.ON.equals(setup.state())) {
				thirdPartySynchronizer.enable(setup.id());
			} else {
				if (!setup.thirdPartySyncRequired() || !DesiredState.ON.equals(setup.state())) {
					thirdPartySynchronizer.disable(setup.id());
				}
			}
			internalSynchronizer.update(setup);

			if (DesiredState.ON.equals(setup.state()) && !setup.thirdPartySyncRequired()) {
				internalSynchronizer.add(setup.id());
			}
		} else {
			if (DesiredState.ON.equals(setup.state()) && !(InternalState.ADDED.equals(internalState) || InternalState.ERROR.equals(internalState))
				&& !setup.thirdPartySyncRequired()) {
				internalSynchronizer.add(setup.id());
			}

			if (!DesiredState.ON.equals(setup.state())) {
				if (setup.thirdPartySyncRequired()) {
					thirdPartySynchronizer.disable(setup.id());
				}
				if (!InternalState.REMOVED.equals(internalState)) {
					internalSynchronizer.remove(setup.id());
				}
			}
		}
	}
}