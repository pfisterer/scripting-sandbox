package de.farberg.scripting.sandbox;

import java.io.FilePermission;
import java.security.Permission;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;

/**
 * -Djava.security.manager -Djava.security.policy=src/main/java/java-all-permissions.policy
 */
public class Main {

    public static void main(String[] args) throws Throwable {

        try {
            System.out.println("Current security manager: " + System.getSecurityManager());

            ScriptEngineManager scriptEngineManager = new ScriptEngineManager();

            System.out.println("Available scripting engines: ");
            for (ScriptEngineFactory factory : scriptEngineManager.getEngineFactories())
                System.out.println("- " + factory.getEngineName() + ", short names: "
                        + Arrays.toString(factory.getNames().toArray()));

            ScriptEngine bshEngine = scriptEngineManager.getEngineByName("bsh");
            System.out.println("Got a new bsh engine: " + bshEngine);

            ScriptingSandbox sb = new ScriptingSandbox(bshEngine);

            Collection<Permission> permissions = new LinkedList<Permission>();
//            permissions.add(new RuntimePermission("accessDeclaredMembers"));
//            permissions.add(new AllPermission());
//            permissions.add(new FilePermission("<<ALL FILES>>", "read"));
            sb.setPermissions(permissions);

            sb.eval("System.out.println(\"hallo\")");
            
            try {
                sb.eval("File.createTempFile(\"ljlk\", \".del\").deleteOnExit();");
            } catch (Throwable e) {
                System.out.println("Nope!");
            }
            
        } catch (Throwable t) {
            System.err.println("Exception in code: " + t);
            t.printStackTrace();
        }

        System.exit(0);
    }
}
