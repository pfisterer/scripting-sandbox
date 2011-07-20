package de.farberg.scripting.sandbox;

import java.io.FileDescriptor;
import java.net.InetAddress;
import java.security.Permission;

public class TracingDelegateSecurityManager extends SecurityManager {
    private final SecurityManager sm;

    public TracingDelegateSecurityManager(SecurityManager sm) {
        super();
        this.sm = sm;
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean getInCheck() {
        System.out.println("getInCheck");
        return super.getInCheck();
    }

    @SuppressWarnings("rawtypes")
    @Override
    protected Class[] getClassContext() {
        System.out.println("getClassContext");
        return super.getClassContext();
    }

    @SuppressWarnings("deprecation")
    @Override
    protected ClassLoader currentClassLoader() {
        System.out.println("currentClassLoader");
        return super.currentClassLoader();
    }

    @SuppressWarnings("deprecation")
    @Override
    protected Class<?> currentLoadedClass() {
        System.out.println("currentLoadedClass");
        return super.currentLoadedClass();
    }

    @SuppressWarnings("deprecation")
    @Override
    protected int classDepth(String name) {
        System.out.println("classDepth(" + name + ")");
        return super.classDepth(name);
    }

    @SuppressWarnings("deprecation")
    @Override
    protected int classLoaderDepth() {
        System.out.println("classLoaderDepth");
        return super.classLoaderDepth();
    }

    @SuppressWarnings("deprecation")
    @Override
    protected boolean inClass(String name) {
        System.out.println("inClass(" + name + ")");
        return super.inClass(name);
    }

    @SuppressWarnings("deprecation")
    @Override
    protected boolean inClassLoader() {
        System.out.println("inClassLoader");
        return super.inClassLoader();
    }

    @Override
    public Object getSecurityContext() {
        System.out.println("getSecurityContext");
        return super.getSecurityContext();
    }

    @Override
    public boolean checkTopLevelWindow(Object window) {
        System.out.println("checkTopLevelWindow(" + window + ")");
        return super.checkTopLevelWindow(window);
    }

    @Override
    public ThreadGroup getThreadGroup() {
        System.out.println("getThreadGroup");
        return super.getThreadGroup();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        System.out.println("clone");
        return new TracingDelegateSecurityManager((SecurityManager) super.clone());
    }

    @Override
    public void checkPermission(Permission perm) {
        System.out.println("checkPermission: " + perm);
        if (sm != null)
            sm.checkPermission(perm);
    }

    @Override
    public void checkPermission(Permission perm, Object context) {
        System.out.println("checkPermission: " + perm + ", context: " + context);
        if (sm != null)
            sm.checkPermission(perm, context);
    }

    @Override
    public void checkCreateClassLoader() {
        System.out.println("checkCreateClassLoader");
        if (sm != null)
            sm.checkCreateClassLoader();
    }

    @Override
    public void checkAccess(Thread t) {
        System.out.println("checkAccess: " + t);
        if (sm != null)
            sm.checkAccess(t);
    }

    @Override
    public void checkAccess(ThreadGroup g) {
        System.out.println("checkAccess: " + g);
        if (sm != null)
            sm.checkAccess(g);
    }

    @Override
    public void checkExit(int status) {
        System.out.println("checkExit: " + status);
        if (sm != null)
            sm.checkExit(status);
    }

    @Override
    public void checkExec(String cmd) {
        System.out.println("checkExec: " + cmd);
        if (sm != null)
            sm.checkExec(cmd);
    }

    @Override
    public void checkLink(String lib) {
        System.out.println("checkLink: " + lib);
        if (sm != null)
            sm.checkLink(lib);
    }

    @Override
    public void checkRead(FileDescriptor fd) {
        System.out.println("checkRead: " + fd);
        if (sm != null)
            sm.checkRead(fd);
    }

    @Override
    public void checkRead(String file) {
        System.out.println("checkRead: " + file);
        if (sm != null)
            sm.checkRead(file);
    }

    @Override
    public void checkRead(String file, Object context) {
        System.out.println("checkRead: " + file + ", context: " + context);
        if (sm != null)
            sm.checkRead(file, context);
    }

    @Override
    public void checkWrite(FileDescriptor fd) {
        System.out.println("checkWrite: " + fd);
        if (sm != null)
            sm.checkWrite(fd);
    }

    @Override
    public void checkWrite(String file) {
        System.out.println("checkWrite: " + file);
        if (sm != null)
            sm.checkWrite(file);
    }

    @Override
    public void checkDelete(String file) {
        System.out.println("checkDelete: " + file);
        if (sm != null)
            sm.checkDelete(file);
    }

    @Override
    public void checkConnect(String host, int port) {
        System.out.println("checkConnect: host: " + host + ", port: " + port);
        if (sm != null)
            sm.checkConnect(host, port);
    }

    @Override
    public void checkConnect(String host, int port, Object context) {
        System.out.println("checkConnect: host: " + host + ", port: " + port + ", context: " + context);
        if (sm != null)
            sm.checkConnect(host, port, context);
    }

    @Override
    public void checkListen(int port) {
        System.out.println("checkListen: " + port);
        if (sm != null)
            sm.checkListen(port);
    }

    @Override
    public void checkAccept(String host, int port) {
        System.out.println("checkAccept: host: " + host + ", port: " + port);
        if (sm != null)
            sm.checkAccept(host, port);
    }

    @Override
    public void checkMulticast(InetAddress maddr) {
        System.out.println("checkMulticast: " + maddr);
        if (sm != null)
            sm.checkMulticast(maddr);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void checkMulticast(InetAddress maddr, byte ttl) {
        System.out.println("checkMulticast: " + maddr + ", ttl: " + ttl);
        if (sm != null)
            sm.checkMulticast(maddr, ttl);
    }

    @Override
    public void checkPropertiesAccess() {
        System.out.println("checkPropertiesAccess");
        if (sm != null)
            sm.checkPropertiesAccess();
    }

    @Override
    public void checkPropertyAccess(String key) {
        System.out.println("checkPropertyAccess: " + key);
        if (sm != null)
            sm.checkPropertyAccess(key);
    }

    @Override
    public void checkPrintJobAccess() {
        System.out.println("checkPrintJobAccess");
        if (sm != null)
            sm.checkPrintJobAccess();
    }

    @Override
    public void checkSystemClipboardAccess() {
        System.out.println("checkSystemClipboardAccess");
        if (sm != null)
            sm.checkSystemClipboardAccess();
    }

    @Override
    public void checkAwtEventQueueAccess() {
        System.out.println("checkAwtEventQueueAccess:");
        if (sm != null)
            sm.checkAwtEventQueueAccess();
    }

    @Override
    public void checkPackageAccess(String pkg) {
        System.out.println("checkPackageAccess: " + pkg);
        if (sm != null)
            sm.checkPackageAccess(pkg);
    }

    @Override
    public void checkPackageDefinition(String pkg) {
        System.out.println("checkPackageDefinition: " + pkg);
        if (sm != null)
            sm.checkPackageDefinition(pkg);
    }

    @Override
    public void checkSetFactory() {
        System.out.println("checkSetFactory");
        if (sm != null)
            sm.checkSetFactory();
    }

    @Override
    public void checkMemberAccess(Class<?> clazz, int which) {
        System.out.println("checkMemberAccess: class: " + clazz + ", which: " + which);
        if (sm != null)
            sm.checkMemberAccess(clazz, which);
    }

    @Override
    public void checkSecurityAccess(String target) {
        System.out.println("checkSecurityAccess: " + target);
        if (sm != null)
            sm.checkSecurityAccess(target);
    }

}
