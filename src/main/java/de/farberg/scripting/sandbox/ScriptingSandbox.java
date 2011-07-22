package de.farberg.scripting.sandbox;


import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.CodeSource;
import java.security.Permission;
import java.security.Permissions;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;
import java.security.cert.Certificate;
import java.util.Collection;

import javax.script.ScriptEngine;
import javax.script.ScriptException;

/**
 * Inspired by http://worldwizards.blogspot.com/2009/08/java-scripting-api-sandbox.html
 */
public class ScriptingSandbox {
    private ScriptEngine scriptEngine;
    private AccessControlContext accessControlContext;

    public ScriptingSandbox(ScriptEngine scriptEngine) throws InstantiationException {
        this.scriptEngine = scriptEngine;
        setPermissions(null);
    }

    public void setPermissions(Collection<Permission> permissionCollection) {
        Permissions perms = new Permissions();

        if (permissionCollection != null) {
            for (Permission p : permissionCollection) {
                perms.add(p);
            }
        }

        ProtectionDomain domain = new ProtectionDomain(new CodeSource(null, (Certificate[]) null), perms);
        accessControlContext = new AccessControlContext(new ProtectionDomain[] { domain });
    }

    public Object eval(final String code) {

        return AccessController.doPrivileged(new PrivilegedAction<Object>() {
            @Override
            public Object run() {
                try {
                    return scriptEngine.eval(code);
                } catch (ScriptException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }, accessControlContext);
    }

}
