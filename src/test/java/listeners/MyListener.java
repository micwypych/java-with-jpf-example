package listeners;

import gov.nasa.jpf.Property;
import gov.nasa.jpf.PropertyListenerAdapter;
import gov.nasa.jpf.jvm.ClassFile;
import gov.nasa.jpf.report.Publisher;
import gov.nasa.jpf.search.Search;
import gov.nasa.jpf.vm.*;

public class MyListener extends PropertyListenerAdapter {
    public MyListener() {
        System.err.println("MyListner()");
    }

    @Override
    public boolean check(Search search, VM vm) {
        System.err.println("check()");
        return super.check(search, vm);
    }

    @Override
    public void reset() {
        System.err.println("reset()");
        super.reset();
    }

    @Override
    public Property clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public void vmInitialized(VM vm) {
        System.err.println("vmInitialized()");
        super.vmInitialized(vm);
    }

    @Override
    public void instructionExecuted(VM vm, ThreadInfo currentThread, Instruction nextInstruction, Instruction executedInstruction) {
        super.instructionExecuted(vm, currentThread, nextInstruction, executedInstruction);
    }

    @Override
    public void executeInstruction(VM vm, ThreadInfo currentThread, Instruction instructionToExecute) {
        System.err.println("executeInstruction()");
        super.executeInstruction(vm, currentThread, instructionToExecute);
    }

    @Override
    public void threadStarted(VM vm, ThreadInfo startedThread) {
        System.err.println("threadStarted()");
        super.threadStarted(vm, startedThread);
    }

    @Override
    public void threadWaiting(VM vm, ThreadInfo waitingThread) {
        super.threadWaiting(vm, waitingThread);
    }

    @Override
    public void threadNotified(VM vm, ThreadInfo notifiedThread) {
        super.threadNotified(vm, notifiedThread);
    }

    @Override
    public void threadInterrupted(VM vm, ThreadInfo interruptedThread) {
        super.threadInterrupted(vm, interruptedThread);
    }

    @Override
    public void threadScheduled(VM vm, ThreadInfo scheduledThread) {
        super.threadScheduled(vm, scheduledThread);
    }

    @Override
    public void threadBlocked(VM vm, ThreadInfo blockedThread, ElementInfo lock) {
        super.threadBlocked(vm, blockedThread, lock);
    }

    @Override
    public void threadTerminated(VM vm, ThreadInfo terminatedThread) {
        super.threadTerminated(vm, terminatedThread);
    }

    @Override
    public void loadClass(VM vm, ClassFile cf) {
        super.loadClass(vm, cf);
    }

    @Override
    public void classLoaded(VM vm, ClassInfo loadedClass) {
        super.classLoaded(vm, loadedClass);
    }

    @Override
    public void objectCreated(VM vm, ThreadInfo currentThread, ElementInfo newObject) {
        super.objectCreated(vm, currentThread, newObject);
    }

    @Override
    public void objectReleased(VM vm, ThreadInfo currentThread, ElementInfo releasedObject) {
        super.objectReleased(vm, currentThread, releasedObject);
    }

    @Override
    public void objectLocked(VM vm, ThreadInfo currentThread, ElementInfo lockedObject) {
        super.objectLocked(vm, currentThread, lockedObject);
    }

    @Override
    public void objectUnlocked(VM vm, ThreadInfo currentThread, ElementInfo unlockedObject) {
        super.objectUnlocked(vm, currentThread, unlockedObject);
    }

    @Override
    public void objectWait(VM vm, ThreadInfo currentThread, ElementInfo waitingObject) {
        super.objectWait(vm, currentThread, waitingObject);
    }

    @Override
    public void objectNotify(VM vm, ThreadInfo currentThread, ElementInfo notifyingObject) {
        super.objectNotify(vm, currentThread, notifyingObject);
    }

    @Override
    public void objectNotifyAll(VM vm, ThreadInfo currentThread, ElementInfo notifyingObject) {
        super.objectNotifyAll(vm, currentThread, notifyingObject);
    }

    @Override
    public void objectExposed(VM vm, ThreadInfo currentThread, ElementInfo fieldOwnerObject, ElementInfo exposedObject) {
        super.objectExposed(vm, currentThread, fieldOwnerObject, exposedObject);
    }

    @Override
    public void objectShared(VM vm, ThreadInfo currentThread, ElementInfo sharedObject) {
        super.objectShared(vm, currentThread, sharedObject);
    }

    @Override
    public void gcBegin(VM vm) {
        super.gcBegin(vm);
    }

    @Override
    public void gcEnd(VM vm) {
        super.gcEnd(vm);
    }

    @Override
    public void exceptionThrown(VM vm, ThreadInfo currentThread, ElementInfo thrownException) {
        super.exceptionThrown(vm, currentThread, thrownException);
    }

    @Override
    public void exceptionBailout(VM vm, ThreadInfo currentThread) {
        super.exceptionBailout(vm, currentThread);
    }

    @Override
    public void exceptionHandled(VM vm, ThreadInfo currentThread) {
        super.exceptionHandled(vm, currentThread);
    }

    @Override
    public void choiceGeneratorRegistered(VM vm, ChoiceGenerator<?> nextCG, ThreadInfo currentThread, Instruction executedInstruction) {
        super.choiceGeneratorRegistered(vm, nextCG, currentThread, executedInstruction);
    }

    @Override
    public void choiceGeneratorSet(VM vm, ChoiceGenerator<?> newCG) {
        System.err.println("choiceGeneratorSet()");
        super.choiceGeneratorSet(vm, newCG);
    }

    @Override
    public void choiceGeneratorAdvanced(VM vm, ChoiceGenerator<?> currentCG) {
        super.choiceGeneratorAdvanced(vm, currentCG);
    }

    @Override
    public void choiceGeneratorProcessed(VM vm, ChoiceGenerator<?> processedCG) {
        super.choiceGeneratorProcessed(vm, processedCG);
    }

    @Override
    public void methodEntered(VM vm, ThreadInfo currentThread, MethodInfo enteredMethod) {
        super.methodEntered(vm, currentThread, enteredMethod);
    }

    @Override
    public void methodExited(VM vm, ThreadInfo currentThread, MethodInfo exitedMethod) {
        super.methodExited(vm, currentThread, exitedMethod);
    }

    @Override
    public void stateAdvanced(Search search) {
        super.stateAdvanced(search);
    }

    @Override
    public void stateProcessed(Search search) {
        super.stateProcessed(search);
    }

    @Override
    public void stateBacktracked(Search search) {
        super.stateBacktracked(search);
    }

    @Override
    public void statePurged(Search search) {
        super.statePurged(search);
    }

    @Override
    public void stateStored(Search search) {
        super.stateStored(search);
    }

    @Override
    public void stateRestored(Search search) {
        super.stateRestored(search);
    }

    @Override
    public void searchProbed(Search search) {
        super.searchProbed(search);
    }

    @Override
    public void propertyViolated(Search search) {
        super.propertyViolated(search);
    }

    @Override
    public void searchStarted(Search search) {
        super.searchStarted(search);
    }

    @Override
    public void searchConstraintHit(Search search) {
        super.searchConstraintHit(search);
    }

    @Override
    public void searchFinished(Search search) {
        super.searchFinished(search);
    }

    @Override
    public void publishStart(Publisher publisher) {
        super.publishStart(publisher);
    }

    @Override
    public void publishTransition(Publisher publisher) {
        super.publishTransition(publisher);
    }

    @Override
    public void publishPropertyViolation(Publisher publisher) {
        super.publishPropertyViolation(publisher);
    }

    @Override
    public void publishConstraintHit(Publisher publisher) {
        super.publishConstraintHit(publisher);
    }

    @Override
    public void publishFinished(Publisher publisher) {
        super.publishFinished(publisher);
    }

    @Override
    public void publishProbe(Publisher publisher) {
        super.publishProbe(publisher);
    }
}