package de.farberg.scripting.sandbox;

import java.io.FilePermission;
import java.security.AllPermission;
import java.security.Permission;
import java.util.Collection;
import java.util.LinkedList;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.junit.Before;
import org.junit.Test;

public class TestFilePermissions {
    private static final String CREATE_TEMP_FILE_AND_DELETEONEXIT =
            "File.createTempFile(\"ljlk\", \".del\").deleteOnExit();";

    private ScriptEngine bshEngine;

    @Before
    public void setUp() {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        bshEngine = scriptEngineManager.getEngineByName("bsh");
    }

    @Test
    public void testCreateTemporaryFileWithAllPermissionsEnabled() throws InstantiationException {
        ScriptingSandbox sb = new ScriptingSandbox(bshEngine);

        Collection<Permission> permissions = new LinkedList<Permission>();
        permissions.add(new AllPermission());
        sb.setPermissions(permissions);

        sb.eval(CREATE_TEMP_FILE_AND_DELETEONEXIT);
    }

    @Test(expected=java.lang.Throwable.class)
    public void testCreateTemporaryFileWithoutPermissions() throws InstantiationException {
        ScriptingSandbox sb = new ScriptingSandbox(bshEngine);

        Collection<Permission> permissions = new LinkedList<Permission>();
        permissions.add(new FilePermission("<<ALL FILES>>", "read"));
        sb.setPermissions(permissions);

        sb.eval(CREATE_TEMP_FILE_AND_DELETEONEXIT);
    }

}
